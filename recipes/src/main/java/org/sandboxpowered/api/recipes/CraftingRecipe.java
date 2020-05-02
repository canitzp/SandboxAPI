package org.sandboxpowered.api.recipes;

import org.sandboxpowered.api.item.ItemStack;

public interface CraftingRecipe extends Recipe<ItemStack> {
    boolean fits(int width, int height);
}