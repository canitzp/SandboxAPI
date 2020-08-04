package org.sandboxpowered.api.world;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.util.Side;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

public interface World extends WorldReader, WorldWriter {

    Side getSide();

    default boolean isServer() {
        return getSide().isServer();
    }

    default boolean isClient() {
        return getSide().isClient();
    }

    default List<Entity> getEntities() {
        return Collections.emptyList();
    }

    default Entity getEntityByUUID(UUID uuid) {
        return null;
    }
}
