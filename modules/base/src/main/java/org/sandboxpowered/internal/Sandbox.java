package org.sandboxpowered.internal;

import org.sandboxpowered.api.SandboxAPI;
import org.sandboxpowered.api.addon.Addon;
import org.sandboxpowered.api.addon.AddonInfo;
import org.sandboxpowered.api.registry.Registrar;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.Internal;

import java.util.Map;
import java.util.Optional;

@Internal
public interface Sandbox {
    Identity getPlatform();

    Optional<AddonInfo> getAddon(String addonId);

    Map<AddonInfo, Addon> getAllAddons();

    SandboxAPI getAPIFor(AddonInfo info);

    Registrar getRegistrarFor(AddonInfo info);
}
