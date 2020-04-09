package org.sandboxpowered.sandbox.api.content.resource.supplier;

import org.sandboxpowered.sandbox.api.block.Blocks;
import org.sandboxpowered.sandbox.api.fluid.BaseFluid;
import org.sandboxpowered.sandbox.api.fluid.Fluid;
import org.sandboxpowered.sandbox.api.fluid.Fluids;
import org.sandboxpowered.sandbox.api.item.Item;
import org.sandboxpowered.sandbox.api.item.Items;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.state.FluidState;
import org.sandboxpowered.sandbox.api.util.Identity;

import java.util.function.Supplier;

public class FluidSuppliers {
	public static Supplier<Fluid> VIRTUAL_FLUID = VirtualFluid::new;

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
