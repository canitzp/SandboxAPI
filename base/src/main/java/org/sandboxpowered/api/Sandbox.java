package org.sandboxpowered.api;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;

import com.github.zafarkhaja.semver.Parser;
import com.github.zafarkhaja.semver.expr.Expression;
import com.github.zafarkhaja.semver.expr.ExpressionParser;

import org.sandboxpowered.api.addon.Addon;
import org.sandboxpowered.api.addon.AddonInfo;
import org.sandboxpowered.api.registry.Registrar;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.Internal;

import java.util.Map;

@Internal
public interface Sandbox {
	Parser<Expression> PARSER = ExpressionParser.newInstance();

	static Sandbox getSandbox() {
		throw new IllegalStateException("No Sandbox instance is defined! Please report this!");
	}

	Identity getPlatform();

	Optional<AddonSpec> getAddon(String addonId);

	Map<AddonSpec, Addon> getAllAddons();

	SandboxAPI getAPIFor(AddonInfo spec);

	Registrar getRegistrarFor(AddonInfo spec);

	default List<AddonSpec> getLoadOrder() {
		Set<AddonSpec> visited = new HashSet<>();
		List<AddonSpec> loadOrder = new ArrayList<>();
		for (AddonSpec spec : getAllAddons().keySet()) {
			handleDependencies(visited, loadOrder, spec);
		}
		return loadOrder;
	}

	//TODO: do we want to split this up between init and register?
	default void launchAll() {
		getLoadOrder().forEach(spec -> {
			if (!spec.getPlatformSupport(getPlatform()).canRun()) {
				throw new IllegalStateException(String.format("Addon %s cannot run on platform %s!", spec.getAddonId(), getPlatform().toString()));
			}
			Addon addon = getAllAddons().get(spec);
			if (addon != null) {
				SandboxAPI api = getAPIFor(spec);
				Registrar registrar = getRegistrarFor(spec);
				try {
					addon.init(api);
					addon.register(registrar);
				} catch (Exception e) {
					throw new RuntimeException(String.format("Initialization for addon %s failed: %s", spec.getAddonId(), e.getMessage()), e);
				}
			} else {
				//TODO: log that an addon has no entrypoint?
			}
		});
	}

	//TODO: does this properly prevent circular dependencies while satisfying everything?
	default void handleDependencies(Set<AddonSpec> visited, List<AddonSpec> order, AddonSpec spec) {
		if (visited.contains(spec)) return;
		visited.add(spec);
		Map<String, String> dependencies = spec.getDependencies();
		for (String dep : dependencies.keySet()) {
			Optional<AddonSpec> optionalDep = getAddon(dep);
			if (!optionalDep.isPresent()) throw new IllegalStateException(String.format("Addon %s depends on other addon %s that isn't loaded!", spec.getAddonId(), dep));
			AddonSpec dependency = optionalDep.get();
			String versionString = dependencies.get(dep);
			Expression version = PARSER.parse(versionString);
			if (!version.interpret(dependency.getVersion())) throw new IllegalStateException(String.format("Addon %s depends on %s version %s but found version %s instead!", spec.getAddonId(), dep, versionString, dependency.getVersion().toString()));
			handleDependencies(visited, order, spec);
		}
		order.add(spec);
	}
}
