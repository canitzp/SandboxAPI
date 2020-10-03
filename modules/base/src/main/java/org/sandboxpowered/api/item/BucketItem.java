package org.sandboxpowered.api.item;

import org.sandboxpowered.api.fluid.BaseFluid;

public class BucketItem extends BaseItem {
    private final BaseFluid fluid;

    public BucketItem(BaseFluid fluid, Settings settings) {
        super(settings);
        this.fluid = fluid;
    }

    public BaseFluid getFluid() {
        return fluid;
    }
}