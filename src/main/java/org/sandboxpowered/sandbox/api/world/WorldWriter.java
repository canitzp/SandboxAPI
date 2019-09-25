package org.sandboxpowered.sandbox.api.world;

import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.util.math.Position;

public interface WorldWriter {
    boolean setBlockState(Position position, BlockState state, BlockFlag... flags);

    default boolean setBlockState(Position position, BlockState state) {
        return setBlockState(position, state, BlockFlag.DEFAULT);
    }

}