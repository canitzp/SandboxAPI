package com.hrznstudio.sandbox.api.world;

import com.hrznstudio.sandbox.api.block.state.BlockState;
import com.hrznstudio.sandbox.api.util.math.Position;

public interface World {
    BlockState getBlockState(Position position);

    boolean isClient();
}
