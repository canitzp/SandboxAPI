package org.sandboxpowered.sandbox.api.block;

import org.sandboxpowered.sandbox.api.fluid.Fluid;
import org.sandboxpowered.sandbox.api.fluid.FluidStack;
import org.sandboxpowered.sandbox.api.fluid.Fluids;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.state.Properties;
import org.sandboxpowered.sandbox.api.util.Direction;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.world.WorldReader;
import org.sandboxpowered.sandbox.api.world.WorldWriter;

public interface FluidLoggable {
    default boolean canContainFluid(WorldReader world, Position position, BlockState state, Fluid fluid, Mono<Direction> direction) {
        return fluid == Fluids.WATER;
    }

    default FluidStack getFluid(WorldReader world, Position position, BlockState state, Mono<Direction> direction) {
        if (state.contains(Properties.WATERLOGGED)) {
            if (state.get(Properties.WATERLOGGED)) return FluidStack.of(Fluids.WATER);
        }
        return FluidStack.empty();
    }

    default FluidStack fillWith(WorldReader world, Position position, BlockState state, FluidStack fluid, Mono<Direction> direction, boolean simulate) {
        if (!(world instanceof WorldWriter)) return fluid;
        if (canContainFluid(world, position, state, fluid.getFluid(), direction)) {
            if (!simulate) ((WorldWriter)world).setBlockState(position, state.with(Properties.WATERLOGGED, true));
            return fluid.shrink(1000);
        }
        return fluid;
    }

    default FluidStack drainFrom(WorldReader world, Position position, BlockState state, int amount, Mono<Direction> direction, boolean simulate) {
        if (!(world instanceof WorldWriter)) return FluidStack.empty();
        if (state.get(Properties.WATERLOGGED) && amount <= 1000) {
            if (!simulate) ((WorldWriter)world).setBlockState(position, state.with(Properties.WATERLOGGED, false));
            return FluidStack.of(Fluids.WATER, amount);
        }
        return FluidStack.empty();
    }

    default boolean needsWaterloggedProperty() {
        return true;
    }
}
