package com.hrznstudio.sandbox.api.client;

import com.hrznstudio.sandbox.api.client.screen.IScreen;
import com.hrznstudio.sandbox.api.entity.player.Player;
import com.hrznstudio.sandbox.api.util.Functions;
import com.hrznstudio.sandbox.api.world.World;

import javax.annotation.Nullable;

public interface Client {

    Player getPlayer();

    World getWorld();

    @Nullable
    IScreen getCurrentScreen();

    static Client getInstance() {
        return Functions.clientInstance.get();
    }
}
