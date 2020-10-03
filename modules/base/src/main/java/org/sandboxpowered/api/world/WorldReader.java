package org.sandboxpowered.api.world;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.block.entity.BlockEntity;
import org.sandboxpowered.api.block.multipart.Slot;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.shape.Box;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.state.FluidState;
import org.sandboxpowered.api.util.math.Position;

import java.util.Collections;
import java.util.List;
import java.util.stream.Stream;

public interface WorldReader {
    default BlockState getBlockState(Position position) {
        return getBlockState(position, Slot.BLOCK);
    }

    BlockState getBlockState(Position position, Slot slot);

    @Nullable
    default BlockEntity getBlockEntity(Position position) {
        return getBlockEntity(position, Slot.BLOCK);
    }

    @Nullable
    BlockEntity getBlockEntity(Position position, Slot slot);

    FluidState getFluidState(Position position);

    default boolean isValid(Position position) {
        return isHeightValid(position) && position.getX() >= -30000000 && position.getZ() >= -30000000 && position.getX() < 30000000 && position.getZ() < 30000000;
    }

    default boolean isHeightValid(Position position) {
        return isHeightValid(position.getY());
    }

    default boolean isHeightValid(int height) {
        return height > 0 && height < 256;
    }

    Stream<Entity> getEntitiesWithin(Box box);

    <T extends Entity> Stream<T> getEntitiesWithin(Box box, Class<T> filter);
}