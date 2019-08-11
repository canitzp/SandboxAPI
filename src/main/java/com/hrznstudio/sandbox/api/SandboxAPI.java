package com.hrznstudio.sandbox.api;

import com.hrznstudio.sandbox.api.util.Side;

public interface SandboxAPI {
    Side getSide();

    default void execute(Side side, Runnable runnable) {
        if (getSide() == side) {
            runnable.run();
        }
    }
}
