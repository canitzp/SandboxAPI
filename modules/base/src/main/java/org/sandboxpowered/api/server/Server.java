package org.sandboxpowered.api.server;

import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.internal.InternalService;

import java.util.List;
import java.util.stream.Stream;

public interface Server {
    static Server getInstance() {
        return InternalService.getInstance().serverInstance();
    }

    World getWorld(Identity identity);

    Stream<PlayerEntity> getPlayers();
}