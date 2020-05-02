package org.sandboxpowered.api.recipes;

import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Identity;

public class RecipeTypes {
    public static final Registry.Entry<Recipe.Type<CraftingRecipe>> CRAFTING = getType("crafting");
    public static final Registry.Entry<Recipe.Type<Recipe<ItemStack>>> SMELTING = getType("smelting");
    public static final Registry.Entry<Recipe.Type<Recipe<ItemStack>>> BLASTING = getType("blasting");
    public static final Registry.Entry<Recipe.Type<Recipe<ItemStack>>> SMOKING = getType("smoking");
    public static final Registry.Entry<Recipe.Type<Recipe<ItemStack>>> CAMPFIRE = getType("campfire");
    public static final Registry.Entry<Recipe.Type<Recipe<ItemStack>>> STONECUTTING = getType("stonecutting");

    private static <X extends Recipe<?>> Registry.Entry<Recipe.Type<X>> getType(String id) {
        return (Registry.Entry<Recipe.Type<X>>) (Object) Recipe.Type.REGISTRY.get(Identity.of("minecraft", id));
    }
}