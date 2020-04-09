package org.sandboxpowered.api;

import java.util.Map;

import org.sandboxpowered.api.addon.Addon;
import org.sandboxpowered.api.addon.AddonSpec;
import org.sandboxpowered.api.registry.Registrar;

public interface Sandbox {
	Map<AddonSpec, Addon> getAllAddons();

	SandboxAPI getAPIFor(AddonSpec spec);

	Registrar getRegistrarFor(AddonSpec spec);

	default void initializeAll() {
		getAllAddons().forEach((spec, addon) -> {
			SandboxAPI api = getAPIFor(spec);
			try {
				addon.init(api);
			} catch (Exception e) {
				throw new RuntimeException("Initialization for addon " + spec.getAddonId() + " failed: " + e);
			}
		});
	}

	default void registerAll() {
		getAllAddons().forEach((spec, addon) -> {
			Registrar registrar = getRegistrarFor(spec);
			try {
				addon.register(registrar);
			} catch (Exception e) {
				throw new RuntimeException("Registration for addon " + spec.getAddonId() + " failed: " + e);
			}
		});
	}
}
