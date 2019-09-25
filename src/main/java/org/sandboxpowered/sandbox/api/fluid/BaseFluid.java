package org.sandboxpowered.sandbox.api.fluid;

import org.sandboxpowered.sandbox.api.item.Item;
import org.sandboxpowered.sandbox.api.state.FluidState;
import org.sandboxpowered.sandbox.api.state.Properties;
import org.sandboxpowered.sandbox.api.state.StateFactory;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.Mono;

public abstract class BaseFluid implements Fluid {
    private StateFactory<Fluid, FluidState> stateFactory;

    protected static int getBlockstateLevel(FluidState fluidState_1) {
        return fluidState_1.isStill() ? 0 : 8 - Math.min(fluidState_1.get(Properties.FLUID_LEVEL), 8) + (fluidState_1.get(Properties.FALLING) ? 8 : 0);
    }

    @Override
    public final FluidState getBaseState() {
        return stateFactory.getBaseState();
    }

    @Override
    public final StateFactory<Fluid, FluidState> getStateFactory() {
        return stateFactory;
    }

    public final void setStateFactory(StateFactory<Fluid, FluidState> stateFactory) {
        this.stateFactory = stateFactory;
    }

    public void appendProperties(StateFactory.Builder<Fluid, FluidState> builder) {

    }

    @Override
    public final Mono<Item> asItem() {
        return Mono.of(asBucket());
    }

    public abstract Identity getTexturePath(boolean flowing);

    @Override
    public int getLevel(FluidState state) {
        return isStill(state) ? 8 : state.get(Properties.FLUID_LEVEL);
    }
}