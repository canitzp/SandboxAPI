package org.sandboxpowered.sandbox.api;

import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.registry.Registry;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.Log;
import org.sandboxpowered.sandbox.api.util.Side;

public interface SandboxAPI {
    Side getSide();

    default void execute(Side side, Runnable runnable) {
        if (getSide() == side) {
            runnable.run();
        }
    }

    default <T extends Content<T>> Registry.Entry<T> register(Identity identity, T content) {
        return Registry.getRegistryFromType(content.getContentType()).register(identity, content);
    }

    Log getLog();
}