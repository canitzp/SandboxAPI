package org.sandboxpowered.api.recipes;

import org.sandboxpowered.api.component.Inventory;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.item.ItemStack;

import java.util.ArrayList;
import java.util.Collection;

public interface CraftingRecipe<I extends Inventory> extends Recipe<I> {
    ItemStack getResult();

    ItemStack craft(I inventory);

    boolean fits(int width, int height);

    Collection<ItemStack> getRemainingStacks(I inventory);
}