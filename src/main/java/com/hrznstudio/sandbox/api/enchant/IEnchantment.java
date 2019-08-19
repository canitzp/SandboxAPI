package com.hrznstudio.sandbox.api.enchant;

import com.hrznstudio.sandbox.api.item.ItemStack;

public interface IEnchantment {
    int getMinimumLevel();

    int getMaximumLevel();

    boolean isAcceptableItem(ItemStack stack);

    boolean isCurse();

    boolean isTreasure();
}