package com.hrznstudio.sandbox.api.server;

import com.hrznstudio.sandbox.api.game.GameMode;
import com.hrznstudio.sandbox.api.util.Functions;
import com.hrznstudio.sandbox.api.util.Identity;
import com.hrznstudio.sandbox.api.util.Mono;
import com.hrznstudio.sandbox.api.world.World;

public interface Server {
    static Server getInstance() {
        return Functions.serverInstance.get();
    }

    World getWorld(Identity identity);

    Mono<GameMode> getGameMode();
}