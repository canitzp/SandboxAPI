package org.sandboxpowered.api.world;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.math.Position;

import javax.annotation.Nullable;

public interface WorldWriter {
    boolean setBlockState(Position position, BlockState state, BlockFlag... flags);

    default boolean setBlockState(Position position, BlockState state) {
        return setBlockState(position, state, BlockFlag.DEFAULT);
    }

    default boolean breakBlock(Position position, boolean drop) {
        return breakBlock(position, drop, null);
    }

    boolean breakBlock(Position position, boolean drop, @Nullable Entity entity);
}