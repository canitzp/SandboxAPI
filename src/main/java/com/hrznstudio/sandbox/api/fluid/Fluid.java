package com.hrznstudio.sandbox.api.fluid;

import com.hrznstudio.sandbox.api.state.FluidState;
import com.hrznstudio.sandbox.api.state.Properties;
import com.hrznstudio.sandbox.api.state.StateFactory;
import com.hrznstudio.sandbox.api.util.Identity;

public abstract class Fluid implements IFluid {
    private StateFactory<IFluid, FluidState> stateFactory;

    protected static int getBlockstateLevel(FluidState fluidState_1) {
        return fluidState_1.isStill() ? 0 : 8 - Math.min(fluidState_1.get(Properties.FLUID_LEVEL), 8) + (fluidState_1.get(Properties.FALLING) ? 8 : 0);
    }

    @Override
    public final FluidState getBaseState() {
        return stateFactory.getBaseState();
    }

    @Override
    public final StateFactory<IFluid, FluidState> getStateFactory() {
        return stateFactory;
    }

    public final void setStateFactory(StateFactory<IFluid, FluidState> stateFactory) {
        this.stateFactory = stateFactory;
    }

    public void appendProperties(StateFactory.Builder<IFluid, FluidState> builder) {

    }

    public abstract Identity getTexturePath(boolean flowing);

    @Override
    public int getLevel(FluidState state) {
        return isStill(state) ? 8 : state.get(Properties.FLUID_LEVEL);
    }
}