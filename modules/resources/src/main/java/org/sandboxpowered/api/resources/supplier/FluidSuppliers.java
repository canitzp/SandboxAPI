package org.sandboxpowered.api.resources.supplier;

import org.sandboxpowered.api.block.Blocks;
import org.sandboxpowered.api.fluid.BaseFluid;
import org.sandboxpowered.api.fluid.Fluid;
import org.sandboxpowered.api.fluid.Fluids;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.item.Items;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.state.FluidState;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.Alpha;

import java.util.function.Supplier;

@Alpha
public final class FluidSuppliers {
    /**
     * A fluid that only exists in tanks and buckets, without in-world logic.
     */
    public static Supplier<Fluid> VIRTUAL_FLUID = VirtualFluid::new;

    private FluidSuppliers() {
    }

    //TODO: move elsewhere? helpful/necessary?
    private static class VirtualFluid extends BaseFluid {
        @Override
        public Identity getTexturePath(boolean flowing) {
            return Identity.of(getIdentity().getNamespace(), "fluids/" + getIdentity().getPath());
        }

        @Override
        public boolean isStill(FluidState state) {
            return true;
        }

        @Override
        public BlockState asBlockState(FluidState state) {
            return Blocks.AIR.get().getBaseState();
        }

        @Override
        public Fluid asStill() {
            return this;
        }

        @Override
        public Fluid asFlowing() {
            return Fluids.EMPTY.get();
        }

        @Override
        public boolean isInfinite() {
            return false;
        }

        @Override
        public Item asBucket() {
            return Item.REGISTRY.get(Identity.of(getIdentity().getNamespace(), getIdentity().getPath() + "_bucket")).orElse(Items.BUCKET.get());
        }
    }
}
