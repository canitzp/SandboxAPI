package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.fluid.Fluid;

public class FluidBlock extends Block {
    private Fluid fluid;

    public FluidBlock(Settings settings, Fluid fluid) {
        super(settings);
        this.fluid = fluid;
    }

    public Fluid getFluid() {
        return fluid;
    }
}