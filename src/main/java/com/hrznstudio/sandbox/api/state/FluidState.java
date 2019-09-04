package com.hrznstudio.sandbox.api.state;

import com.hrznstudio.sandbox.api.fluid.IFluid;

public interface FluidState extends PropertyContainer<FluidState> {
    IFluid getFluid();

    default BlockState asBlockState() {
        return getFluid().asBlockState(this);
    }

    default boolean isStill() {
        return getFluid().isStill(this);
    }

    default float getLevel() {
        return getFluid().getLevel(this);
    }
}
