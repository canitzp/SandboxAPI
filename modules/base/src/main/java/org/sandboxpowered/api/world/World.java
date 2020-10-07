package org.sandboxpowered.api.world;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.util.Side;
import org.sandboxpowered.api.util.SoundCategory;
import org.sandboxpowered.api.util.SoundType;
import org.sandboxpowered.api.util.math.Position;

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

    default void playSound(@Nullable PlayerEntity player, Position pos, SoundType soundIn, SoundCategory category, float volume, float pitch) {
        playSound(player, pos.getX() + 0.5, pos.getY() + 0.5, pos.getZ() + 0.5, soundIn, category, volume, pitch);
    }

    void playSound(@Nullable PlayerEntity player, double x, double y, double z, SoundType soundIn, SoundCategory category, float volume, float pitch);
}
