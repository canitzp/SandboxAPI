package org.sandboxpowered.api;

import org.sandboxpowered.api.addon.Addon;
import org.sandboxpowered.api.addon.AddonInfo;
import org.sandboxpowered.api.registry.Registrar;

import java.util.Map;

public interface Sandbox {
	Map<AddonInfo, Addon> getAllAddons();

	SandboxAPI getAPIFor(AddonInfo spec);

	Registrar getRegistrarFor(AddonInfo spec);

	default void initializeAll() {
		getAllAddons().forEach((spec, addon) -> {
			SandboxAPI api = getAPIFor(spec);
			try {
				addon.init(api);
			} catch (Exception e) {
				throw new RuntimeException("Initialization for addon " + spec.getId() + " failed: " + e);
			}
		});
	}

	default void registerAll() {
		getAllAddons().forEach((spec, addon) -> {
			Registrar registrar = getRegistrarFor(spec);
			try {
				addon.register(registrar);
			} catch (Exception e) {
				throw new RuntimeException("Registration for addon " + spec.getId() + " failed: " + e);
			}
		});
	}
}
