package org.sandboxpowered.sandbox.api.enchant;

import org.sandboxpowered.sandbox.api.item.ItemStack;

public interface Enchantment {
    int getMinimumLevel();

    int getMaximumLevel();

    boolean isAcceptableItem(ItemStack stack);

    boolean isCurse();

    boolean isTreasure();
}