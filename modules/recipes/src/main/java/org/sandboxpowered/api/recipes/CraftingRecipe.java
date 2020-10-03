package org.sandboxpowered.api.recipes;

public interface CraftingRecipe extends Recipe {
    boolean fits(int width, int height);
}