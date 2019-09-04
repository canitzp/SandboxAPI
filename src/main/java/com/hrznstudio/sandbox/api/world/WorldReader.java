package com.hrznstudio.sandbox.api.world;

import com.hrznstudio.sandbox.api.block.entity.IBlockEntity;
import com.hrznstudio.sandbox.api.state.BlockState;
import com.hrznstudio.sandbox.api.state.FluidState;
import com.hrznstudio.sandbox.api.util.math.Position;

public interface WorldReader {
    BlockState getBlockState(Position position);

    IBlockEntity getBlockEntity(Position position);

    FluidState getFluidState(Position position);
}
