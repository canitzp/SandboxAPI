package org.sandboxpowered.sandbox.api.item;

import org.sandboxpowered.sandbox.api.fluid.BaseFluid;

public class BucketItem extends BaseItem {
    private BaseFluid fluid;

    public BucketItem(Settings settings, BaseFluid fluid) {
        super(settings);
        this.fluid = fluid;
    }

    public BaseFluid getFluid() {
        return fluid;
    }
}