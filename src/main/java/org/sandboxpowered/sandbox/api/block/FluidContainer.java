package org.sandboxpowered.sandbox.api.block;

import org.sandboxpowered.sandbox.api.fluid.Fluid;
import org.sandboxpowered.sandbox.api.fluid.Fluids;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.state.FluidState;
import org.sandboxpowered.sandbox.api.state.Properties;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.world.World;
import org.sandboxpowered.sandbox.api.world.WorldReader;

public interface FluidContainer {
    default boolean canContainFluid(WorldReader world, Position position, BlockState state, Fluid fluid) {
        return fluid == Fluids.WATER;
    }

    default boolean fillWith(World world, Position position, BlockState state, FluidState fluid) {
        if (canContainFluid(world, position, state, fluid.getFluid())) {
            world.setBlockState(position, state.with(Properties.WATERLOGGED, true));
            return true;
        }
        return false;
    }

    default Fluid drainFrom(World world, Position position, BlockState state) {
        if (state.get(Properties.WATERLOGGED)) {
            world.setBlockState(position, state.with(Properties.WATERLOGGED, false));
            return Fluids.WATER;
        }
        return Fluids.EMPTY;
    }
}