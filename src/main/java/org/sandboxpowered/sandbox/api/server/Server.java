package org.sandboxpowered.sandbox.api.server;

import org.sandboxpowered.sandbox.api.util.Functions;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.world.World;

public interface Server {
    static Server getInstance() {
        return Functions.getInstance().serverInstance();
    }

    World getWorld(Identity identity);
}