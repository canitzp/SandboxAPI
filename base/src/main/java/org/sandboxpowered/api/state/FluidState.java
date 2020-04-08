package org.sandboxpowered.api.state;

import org.sandboxpowered.api.fluid.Fluid;

public interface FluidState extends PropertyContainer<FluidState> {
    Fluid getFluid();

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
