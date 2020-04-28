package org.sandboxpowered.api.block;

import org.sandboxpowered.api.fluid.BaseFluid;

public class FluidBlock extends BaseBlock {
    private final BaseFluid fluid;

    public FluidBlock(Settings settings, BaseFluid fluid) {
        super(settings);
        this.fluid = fluid;
    }

    public BaseFluid getFluid() {
        return fluid;
    }
}