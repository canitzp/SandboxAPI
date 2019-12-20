package org.sandboxpowered.sandbox.api.component.fluid;

import org.sandboxpowered.sandbox.api.block.FluidLoggable;
import org.sandboxpowered.sandbox.api.component.FluidContainer;
import org.sandboxpowered.sandbox.api.fluid.FluidStack;
import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.util.Direction;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.world.WorldReader;

import java.util.function.Predicate;

public class FluidLoggingContainer implements FluidContainer {
    private FluidLoggable loggable;
    private WorldReader world;
    private Position pos;
    private BlockState state;
    private Mono<Direction> direction;

    public FluidLoggingContainer(FluidLoggable loggable, WorldReader world, Position pos, BlockState state, Mono<Direction> direction) {
        this.loggable = loggable;
        this.world = world;
        this.pos = pos;
        this.state = state;
        this.direction = direction;
    }

    @Override
    public boolean isEmpty() {
        return loggable.getFluid(world, pos, state, direction).isEmpty();
    }

    @Override
    public int getSize() {
        return 1;
    }

    @Override
    public int getMaxStackSize(int slot) {
        return 1000;
    }

    @Override
    public FluidStack get(int slot) {
        return loggable.getFluid(world, pos, state, direction);
    }

    @Override
    public FluidStack extract(int slot, Predicate<FluidStack> fluidFilter, int amount, boolean simulate) {
        if (fluidFilter.test(get(0))) {
            return loggable.drainFrom(world, pos, state, amount, direction,  simulate);
        }
        return FluidStack.empty();
    }

    @Override
    public FluidStack insert(int slot, FluidStack stack, boolean simulate) {
        if (loggable.canContainFluid(world, pos, state, stack.getFluid(), direction) && stack.getVolume() >= 1000) {
            return loggable.fillWith(world, pos, state, stack, direction, simulate);
        }
        return stack;
    }

    @Override
    public void setStack(int slot, FluidStack stack) {
        if (loggable.canContainFluid(world, pos, state, stack.getFluid(), direction)) {
            loggable.fillWith(world, pos, state, stack, direction, true);
        }
    }
}
