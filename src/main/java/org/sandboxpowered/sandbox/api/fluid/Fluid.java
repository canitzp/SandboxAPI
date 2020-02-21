package org.sandboxpowered.sandbox.api.fluid;


import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.item.Item;
import org.sandboxpowered.sandbox.api.item.ItemProvider;
import org.sandboxpowered.sandbox.api.registry.Registry;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.state.FluidState;
import org.sandboxpowered.sandbox.api.state.Properties;
import org.sandboxpowered.sandbox.api.state.StateFactory;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.util.math.Vec3d;
import org.sandboxpowered.sandbox.api.world.WorldReader;

import java.util.Optional;

public interface Fluid extends ItemProvider, Content<Fluid> {
    Registry<Fluid> REGISTRY = Registry.getRegistryFromType(Fluid.class);

    FluidState getBaseState();

    StateFactory<Fluid, FluidState> getStateFactory();

    default boolean isEmpty() {
        return false;
    }

    boolean isStill(FluidState state);

    BlockState asBlockState(FluidState state);

    default boolean matches(Fluid fluid) {
        return fluid == asStill() || fluid == asFlowing();
    }

    Fluid asStill();

    default FluidState asStill(boolean falling) {
        return asStill().getBaseState().with(Properties.FALLING, falling);
    }

    Fluid asFlowing();

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
     * @return the bucket item for this fluid
     */
    Item asBucket();

    default <X> Mono<X> getComponent(Component<X> component) {
        return getComponent(component, null);
    }

    default <X> Mono<X> getComponent(Component<X> component, FluidStack stack) {
        return Mono.empty();
    }

    @Override
    default Class<Fluid> getContentType() {
        return Fluid.class;
    }
}