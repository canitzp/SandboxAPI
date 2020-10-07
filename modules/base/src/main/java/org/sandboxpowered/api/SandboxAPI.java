package org.sandboxpowered.api;

import org.sandboxpowered.api.addon.AddonInfo;
import org.sandboxpowered.api.util.Log;
import org.sandboxpowered.api.util.Side;

public interface SandboxAPI {
    /**
     * Checks if a sandbox addon is loaded
     *
     * @param addonId the addonId to check
     * @return if the addon is loaded
     */
    boolean isAddonLoaded(String addonId);

    /**
     * Checks if a non-sandbox mod is loaded
     * <p>
     * E.G: fabric:reichenbach or forge:examplemod
     *
     * @param loader The loader to check, "universal" will ignore loader.
     * @param modId  The modId to check, if empty returns if the loader is enabled
     * @return if the mod is loaded
     */
    boolean isExternalModLoaded(String loader, String modId);

    AddonInfo getSourceAddon();

    Side getSide();

    default void execute(Side side, Runnable runnable) {
        if (getSide() == side) {
            runnable.run();
        }
    }

    Log getLog();
}