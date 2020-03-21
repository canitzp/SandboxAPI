package org.sandboxpowered.sandbox.api.addon;

import org.sandboxpowered.sandbox.api.SandboxAPI;
import org.sandboxpowered.sandbox.api.registry.Registrar;

public interface Addon {
    /**
     * General mod init, event registration etc
     */
    void init(SandboxAPI api);

    void register(Registrar registrar);
}
