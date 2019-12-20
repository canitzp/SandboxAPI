package org.sandboxpowered.sandbox.api.fluid;


import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.item.Item;
import org.sandboxpowered.sandbox.api.item.ItemProvider;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.state.FluidState;
import org.sandboxpowered.sandbox.api.state.Properties;
import org.sandboxpowered.sandbox.api.state.StateFactory;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.util.math.Vec3d;
import org.sandboxpowered.sandbox.api.world.WorldReader;

public interface Fluid extends ItemProvider, Content<Fluid> {
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

    default Mono<Vec3d> getVelocity(WorldReader world, Position position, FluidState state) {
        return Mono.empty();
    }

    /**
     * @return the bucket item for this fluid
     */
    Item asBucket();

    default <X> Mono<X> getComponent(Component<X> component) {
        return getComponent(component, Mono.empty());
    }

    default <X> Mono<X> getComponent(Component<X> component, FluidStack stack) {
        return getComponent(component, Mono.of(stack));
    }

    default <X> Mono<X> getComponent(Component<X> component, Mono<FluidStack> stack) {
        return Mono.empty();
    }

    @Override
    default Class<Fluid> getContentType() {
        return Fluid.class;
    }
}