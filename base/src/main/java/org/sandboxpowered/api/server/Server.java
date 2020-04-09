package org.sandboxpowered.api.server;

import org.sandboxpowered.api.world.World;
import org.sandboxpowered.api.util.Functions;
import org.sandboxpowered.api.util.Identity;

public interface Server {
    static Server getInstance() {
        return Functions.getInstance().serverInstance();
    }

    World getWorld(Identity identity);
}