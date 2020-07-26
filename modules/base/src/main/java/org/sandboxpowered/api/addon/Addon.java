package org.sandboxpowered.api.addon;

import org.sandboxpowered.api.SandboxAPI;
import org.sandboxpowered.api.registry.Registrar;

public interface Addon {
    /**
     * General mod init, event registration etc
     */
    void init(SandboxAPI api);

    void register(Registrar registrar);
}
