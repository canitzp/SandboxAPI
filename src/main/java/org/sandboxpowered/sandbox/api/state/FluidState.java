package org.sandboxpowered.sandbox.api.state;

import org.sandboxpowered.sandbox.api.fluid.Fluid;

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
