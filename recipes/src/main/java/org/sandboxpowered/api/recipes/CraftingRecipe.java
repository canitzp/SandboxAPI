package org.sandboxpowered.api.recipes;

import org.sandboxpowered.api.component.Inventory;

public interface CraftingRecipe<I extends Inventory> extends InventoryRecipe<I> {
    boolean fits(int width, int height);
}