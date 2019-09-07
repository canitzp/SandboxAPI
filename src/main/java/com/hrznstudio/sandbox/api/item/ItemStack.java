package com.hrznstudio.sandbox.api.item;

import com.hrznstudio.sandbox.api.enchant.IEnchantment;
import com.hrznstudio.sandbox.api.util.Functions;
import com.hrznstudio.sandbox.api.util.nbt.CompoundTag;

public interface ItemStack {

    static ItemStack of(ItemProvider item) {
        return of(item.asItem(), 1);
    }

    static ItemStack of(ItemProvider item, int amount) {
        return of(item.asItem(), amount);
    }

    static ItemStack of(IItem item) {
        return of(item, 1);
    }

    static ItemStack of(IItem item, int amount) {
        return Functions.itemStackFunction.apply(item, amount);
    }

    boolean isEmpty();

    IItem getItem();

    int getCount();

    ItemStack setCount(int amount);

    default ItemStack shrink() {
        return shrink(1);
    }

    ItemStack shrink(int amount);

    default ItemStack grow() {
        return shrink(1);
    }

    ItemStack grow(int amount);

    int getLevel(IEnchantment enchantment);

    boolean hasTag();

    CompoundTag getTag();

    void setTag(CompoundTag tag);

    CompoundTag getOrCreateTag();

    CompoundTag getChildTag(String key);

    CompoundTag getOrCreateChildTag(String key);
}