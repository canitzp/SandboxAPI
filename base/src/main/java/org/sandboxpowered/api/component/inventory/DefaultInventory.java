package org.sandboxpowered.api.component.inventory;

import org.sandboxpowered.api.component.Inventory;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.api.util.nbt.ReadableCompoundTag;
import org.sandboxpowered.api.util.nbt.WritableCompoundTag;

import java.util.Arrays;
import java.util.function.Predicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class DefaultInventory implements Inventory {
    private final ItemStack[] items;

    public DefaultInventory(int size, ItemStack defaultEntry) {
        items = new ItemStack[size];
        Arrays.fill(items, defaultEntry);
    }

    @Override
    public boolean isEmpty() {
        return Stream.of(items).allMatch(ItemStack::isEmpty);
    }

    @Override
    public int getSize() {
        return items.length;
    }

    @Override
    public int getMaxStackSize(int slot) {
        ItemStack in = get(slot);
        return in.isEmpty() ? 64 : Math.min(64, in.getMaxCount());
    }

    @Override
    public ItemStack get(int slot) {
        return items[slot];
    }

    @Override
    public ItemStack extract(int slot, Predicate<ItemStack> itemFilter, int amount, boolean simulate) {
        ItemStack stack = get(slot).copy();
        if (!itemFilter.test(stack))
            return ItemStack.empty();
        ItemStack out = stack.copy();
        out.setCount(Math.min(stack.getCount(), amount));
        stack.shrink(out.getCount());
        if (!simulate)
            setStack(slot, stack);
        return out;
    }

    @Override
    public ItemStack insert(int slot, ItemStack stack, boolean simulate) {
        ItemStack in = get(slot);
        int max = getMaxStackSize(slot);
        if (in.isEmpty()) {
            ItemStack coming = stack.copy();
            if (coming.getCount() > max) {
                coming.setCount(max);
            }
            if (!simulate)
                setStack(slot, coming);
            return stack.copy().shrink(coming.getCount());
        } else {
            int count = in.getCount();
            if (count >= max || !in.isEqualTo(stack) || !in.areTagsEqual(stack))
                return stack;
            ItemStack coming = stack.copy();
            if (count + coming.getCount() > max) {
                coming.setCount(max - count);
            }
            if (!simulate)
                setStack(slot, in.copy().grow(coming.getCount()));
            return stack.copy().shrink(coming.getCount());
        }
    }

    @Override
    public void setStack(int slot, ItemStack stack) {
        items[slot] = stack;
    }

    public void read(ReadableCompoundTag tag) {
        final int[] i = {0};
        tag.getList("items", CompoundTag.class).stream().map(ItemStack::read).forEach(stack -> {
            this.items[i[0]] = stack;
            i[0]++;
        });
    }

    public void write(WritableCompoundTag tag) {
        tag.setList("items", Stream.of(items).map(ItemStack::asTag).collect(Collectors.toList()));
    }
}