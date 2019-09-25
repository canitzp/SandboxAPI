package org.sandboxpowered.sandbox.api.server;

import org.sandboxpowered.sandbox.api.game.GameMode;
import org.sandboxpowered.sandbox.api.util.Functions;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.world.World;

public interface Server {
    static Server getInstance() {
        return Functions.serverInstance.get();
    }

    World getWorld(Identity identity);

    Mono<GameMode> getGameMode();
}