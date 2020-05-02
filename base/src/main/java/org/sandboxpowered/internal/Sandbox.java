package org.sandboxpowered.internal;

import com.github.zafarkhaja.semver.Parser;
import com.github.zafarkhaja.semver.expr.Expression;
import com.github.zafarkhaja.semver.expr.ExpressionParser;
import org.sandboxpowered.api.SandboxAPI;
import org.sandboxpowered.api.addon.Addon;
import org.sandboxpowered.api.addon.AddonInfo;
import org.sandboxpowered.api.registry.Registrar;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.Internal;

import java.util.*;

@Internal
public interface Sandbox {
    Parser<Expression> PARSER = ExpressionParser.newInstance();

    Identity getPlatform();

    Optional<AddonInfo> getAddon(String addonId);

    Map<AddonInfo, Addon> getAllAddons();

    SandboxAPI getAPIFor(AddonInfo info);

    Registrar getRegistrarFor(AddonInfo info);

    default List<AddonInfo> getLoadOrder() {
        Set<AddonInfo> visited = new HashSet<>();
        List<AddonInfo> loadOrder = new ArrayList<>();
        for (AddonInfo info : getAllAddons().keySet()) {
            handleDependencies(visited, loadOrder, info);
        }
        return loadOrder;
    }

    default void initAll() {
        getLoadOrder().forEach(info -> {
            if (!info.getPlatformSupport(getPlatform()).canRun()) {
                throw new IllegalStateException(String.format("Addon %s cannot run on platform %s!", info.getId(), getPlatform().toString()));
            }
            Addon addon = getAllAddons().get(info);
            SandboxAPI api = getAPIFor(info);
            try {
                addon.init(api);
            } catch (Exception e) {
                throw new RuntimeException(String.format("Initialization for addon %s failed: %s", info.getId(), e.getMessage()), e);
            }
        });
    }

    default void registerAll() {
        getLoadOrder().forEach(info -> {
            if (!info.getPlatformSupport(getPlatform()).canRun()) {
                throw new IllegalStateException(String.format("Addon %s cannot run on platform %s!", info.getId(), getPlatform().toString()));
            }
            Addon addon = getAllAddons().get(info);
            Registrar registrar = getRegistrarFor(info);
            try {
                addon.register(registrar);
            } catch (Exception e) {
                throw new RuntimeException(String.format("Registration for addon %s failed: %s", info.getId(), e.getMessage()), e);
            }
        });
        //now that all addons have done registration, we can safely register the requested resources!
//        ResourceManager.register();
    }

    //TODO: does this properly prevent circular dependencies while satisfying everything?
    default void handleDependencies(Set<AddonInfo> visited, List<AddonInfo> order, AddonInfo info) {
        if (visited.contains(info)) return;
        visited.add(info);
        Map<String, String> dependencies = info.getDependencies();
        for (String dep : dependencies.keySet()) {
            Optional<AddonInfo> optionalDep = getAddon(dep);
            if (!optionalDep.isPresent())
                throw new IllegalStateException(String.format("Addon %s depends on other addon %s that isn't loaded!", info.getId(), dep));
            AddonInfo dependency = optionalDep.get();
            String versionString = dependencies.get(dep);
            Expression version = PARSER.parse(versionString);
            if (!version.interpret(dependency.getVersion()))
                throw new IllegalStateException(String.format("Addon %s depends on %s version %s but found version %s instead!", info.getId(), dep, versionString, dependency.getVersion().toString()));
            handleDependencies(visited, order, info);
        }
        order.add(info);
    }
}
