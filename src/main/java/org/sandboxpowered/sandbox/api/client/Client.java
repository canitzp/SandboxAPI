package org.sandboxpowered.sandbox.api.client;

import org.sandboxpowered.sandbox.api.client.screen.Screen;
import org.sandboxpowered.sandbox.api.entity.player.PlayerEntity;
import org.sandboxpowered.sandbox.api.util.Functions;
import org.sandboxpowered.sandbox.api.world.World;

import javax.annotation.Nullable;

public interface Client {

    static Client getInstance() {
        return Functions.clientInstance.get();
    }

    PlayerEntity getPlayer();

    World getWorld();

    @Nullable
    Screen getCurrentScreen();

    TextRenderer getTextRenderer();
}
