package org.sandboxpowered.api;

import org.sandboxpowered.api.util.Log;
import org.sandboxpowered.api.util.Side;

//TODO: per-addon instances
public interface SandboxAPI {
    Side getSide();

    default void execute(Side side, Runnable runnable) {
        if (getSide() == side) {
            runnable.run();
        }
    }

    Log getLog();
}