package com.hrznstudio.sandbox.api.world;

import com.hrznstudio.sandbox.api.state.BlockState;
import com.hrznstudio.sandbox.api.util.math.Position;

public interface WorldWriter {
    boolean setBlockState(Position position, BlockState state, BlockFlag... flags);

    default boolean setBlockState(Position position, BlockState state) {
        return setBlockState(position, state, BlockFlag.DEFAULT);
    }

}