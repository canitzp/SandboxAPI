package com.hrznstudio.sandbox.api.fluid;

import com.hrznstudio.sandbox.api.item.IItem;
import com.hrznstudio.sandbox.api.item.ItemProvider;
import com.hrznstudio.sandbox.api.state.BlockState;
import com.hrznstudio.sandbox.api.state.FluidState;
import com.hrznstudio.sandbox.api.state.Properties;
import com.hrznstudio.sandbox.api.state.StateFactory;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.util.math.Vec3d;
import com.hrznstudio.sandbox.api.world.WorldReader;

import java.util.Optional;

public interface IFluid extends ItemProvider {
    FluidState getBaseState();

    StateFactory<IFluid, FluidState> getStateFactory();

    default boolean isEmpty() {
        return false;
    }

    boolean isStill(FluidState state);

    BlockState asBlockState(FluidState state);

    default boolean matches(IFluid fluid) {
        return fluid == asStill() || fluid == asFlowing();
    }

    IFluid asStill();

    default FluidState asStill(boolean falling) {
        return asStill().getBaseState().with(Properties.FALLING, falling);
    }

    IFluid asFlowing();

    boolean isInfinite();

    int getLevel(FluidState fluidState);

    default FluidState asFlowing(int level, boolean falling) {
        return asFlowing().getBaseState().with(Properties.FLUID_LEVEL, level).with(Properties.FALLING, falling);
    }

    default int getTickRate(WorldReader world) {
        return 5;
    }

    default Optional<Vec3d> getVelocity(WorldReader world, Position position, FluidState state) {
        return Optional.empty();
    }

    /**
     * Return the bucket item for this fluid
     */
    @Override
    IItem asItem();
}