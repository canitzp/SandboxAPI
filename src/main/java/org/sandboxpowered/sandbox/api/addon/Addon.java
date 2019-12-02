package org.sandboxpowered.sandbox.api.addon;

import org.sandboxpowered.sandbox.api.SandboxAPI;

public interface Addon {
    /**
     * General mod init, event registration etc
     */
    void init(SandboxAPI api);
}
