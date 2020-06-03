package org.sandboxpowered.api.fluid;

import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.state.FluidState;
import org.sandboxpowered.api.state.Properties;
import org.sandboxpowered.api.state.StateFactory;
import org.sandboxpowered.api.util.Identity;

import java.util.Optional;

public abstract class BaseFluid implements Fluid {
    private StateFactory<Fluid, FluidState> stateFactory;

    protected static int getBlockStateLevel(FluidState state) {
        return state.isStill() ? 0 : 8 - Math.min(state.get(Properties.FLUID_LEVEL), 8) + (state.get(Properties.FALLING) ? 8 : 0);
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
    public final Optional<Item> asItem() {
        return Optional.of(asBucket());
    }

    public abstract Identity getTexturePath(boolean flowing);

    @Override
    public int getLevel(FluidState state) {
        return isStill(state) ? 8 : state.get(Properties.FLUID_LEVEL);
    }
}