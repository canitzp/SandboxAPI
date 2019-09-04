package com.hrznstudio.sandbox.api.item;

import com.hrznstudio.sandbox.api.fluid.Fluid;

public class BucketItem extends Item {
    private Fluid fluid;

    public BucketItem(Settings settings, Fluid fluid) {
        super(settings);
        this.fluid = fluid;
    }

    public Fluid getFluid() {
        return fluid;
    }
}