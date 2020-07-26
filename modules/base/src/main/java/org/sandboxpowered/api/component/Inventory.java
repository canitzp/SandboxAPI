package org.sandboxpowered.api.component;

import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.internal.IntegerRangeIterator;

import java.util.Iterator;
import java.util.function.Predicate;

public interface Inventory extends Iterable<Integer> {

    Predicate<ItemStack> ANY = stack -> true;

    boolean isEmpty();

    int getSize();

    int getMaxStackSize(int slot);

    ItemStack get(int slot);

    ItemStack extract(int slot, Predicate<ItemStack> itemFilter, int amount, boolean simulate);

    default ItemStack extract(int slot, int amount, boolean simulate) {
        return extract(slot, ANY, amount, simulate);
    }

    default ItemStack extract(Predicate<ItemStack> itemFilter, int amount, boolean simulate) {
        ItemStack extracted = null;
        for (int slot : this) {
            if (extracted == null || extracted.isEmpty()) {
                extracted = extract(slot, itemFilter, amount, simulate);
            } else if (extracted.getCount() < amount) {
                ItemStack test = extract(slot, itemFilter, amount - extracted.getCount(), true);
                if (extracted.isEqualTo(test)) {
                    ItemStack ex = extract(slot, itemFilter, amount - extracted.getCount(), simulate);
                    extracted = extracted.grow(ex.getCount());
                }
            }
            if (extracted != null && extracted.getCount() >= amount) {
                break;
            }
        }
        if (extracted != null && !extracted.isEmpty())
            return extracted;
        return ItemStack.empty();
    }

    default ItemStack extract(int amount, boolean simulate) {
        return extract(ANY, amount, simulate);
    }

    default ItemStack extract(int slot, Predicate<ItemStack> itemFilter, int amount) {
        return extract(slot, itemFilter, amount, false);
    }

    default ItemStack extract(int slot, int amount) {
        return extract(slot, stack -> true, amount, false);
    }

    default ItemStack extract(Predicate<ItemStack> itemFilter, int amount) {
        return extract(itemFilter, amount, false);
    }

    default ItemStack extract(int amount) {
        return extract(stack -> true, amount, false);
    }

    ItemStack insert(int slot, ItemStack stack, boolean simulate);

    default ItemStack insert(ItemStack stack, boolean simulate) {
        for (int slot : this) {
            stack = insert(slot, stack, simulate);
            if (stack.isEmpty())
                break;
        }
        return stack;
    }

    default ItemStack insert(int slot, ItemStack stack) {
        return insert(slot, stack, false);
    }

    default ItemStack insert(ItemStack stack) {
        return insert(stack, false);
    }

    void setStack(int slot, ItemStack stack);

    @Override
    default Iterator<Integer> iterator() {
        return new IntegerRangeIterator(0, getSize());
    }
}