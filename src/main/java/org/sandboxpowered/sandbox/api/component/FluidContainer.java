package org.sandboxpowered.sandbox.api.component;

import org.sandboxpowered.sandbox.api.fluid.FluidStack;
import org.sandboxpowered.sandbox.api.util.IntegerRangeIterator;

import java.util.Iterator;
import java.util.function.Predicate;

public interface FluidContainer extends Iterable<Integer> {

    Predicate<FluidStack> ANY = stack -> true;

    boolean isEmpty();

    int getSize();

    int getMaxStackSize(int slot);

    FluidStack get(int slot);

    FluidStack extract(int slot, Predicate<FluidStack> fluidFilter, int amount, boolean simulate);

    default FluidStack extract(int slot, int amount, boolean simulate) {
        return extract(slot, ANY, amount, simulate);
    }

    default FluidStack extract(Predicate<FluidStack> fluidFilter, int amount, boolean simulate) {
        FluidStack extracted = null;
        for (int slot : this) {
            if (extracted == null || extracted.isEmpty()) {
                extracted = extract(slot, fluidFilter, amount, simulate);
            } else if (extracted.getVolume() < amount) {
                FluidStack test = extract(slot, fluidFilter, amount - extracted.getVolume(), true);
                if (extracted.isEqualTo(test)) {
                    FluidStack ex = extract(slot, fluidFilter, amount - extracted.getVolume(), simulate);
                    extracted = extracted.grow(ex.getVolume());
                }
            }
            if (extracted != null && extracted.getVolume() >= amount) {
                break;
            }
        }
        if (extracted != null && !extracted.isEmpty())
            return extracted;
        return FluidStack.empty();
    }

    default FluidStack extract(int amount, boolean simulate) {
        return extract(ANY, amount, simulate);
    }

    default FluidStack extract(int slot, Predicate<FluidStack> fluidFilter, int amount) {
        return extract(slot, fluidFilter, amount, false);
    }

    default FluidStack extract(int slot, int amount) {
        return extract(slot, stack -> true, amount, false);
    }

    default FluidStack extract(Predicate<FluidStack> fluidFilter, int amount) {
        return extract(fluidFilter, amount, false);
    }

    default FluidStack extract(int amount) {
        return extract(stack -> true, amount, false);
    }

    FluidStack insert(int slot, FluidStack stack, boolean simulate);

    default FluidStack insert(FluidStack stack, boolean simulate) {
        for (int slot : this) {
            stack = insert(slot, stack, simulate);
            if (stack.isEmpty())
                break;
        }
        return stack;
    }

    default FluidStack insert(int slot, FluidStack stack) {
        return insert(slot, stack, false);
    }

    default FluidStack insert(FluidStack stack) {
        return insert(stack, false);
    }

    void setStack(int slot, FluidStack stack);

    @Override
    default Iterator<Integer> iterator() {
        return new IntegerRangeIterator(0, getSize());
    }
}
