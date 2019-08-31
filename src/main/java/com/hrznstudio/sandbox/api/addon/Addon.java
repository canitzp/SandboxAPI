package com.hrznstudio.sandbox.api.addon;

import com.hrznstudio.sandbox.api.SandboxAPI;

public interface Addon {
    /**
     * General mod init, event registration etc
     */
    void init(SandboxAPI api);

    /**
     * Content Registration
     */
    default void register() {

    }
}
