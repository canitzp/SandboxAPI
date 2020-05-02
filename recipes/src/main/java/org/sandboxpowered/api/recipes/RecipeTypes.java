package org.sandboxpowered.api.recipes;

import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Identity;

public class RecipeTypes {
    public static final Registry.Entry<Recipe.Type<CraftingRecipe>> CRAFTING = getType("crafting");
    public static final Registry.Entry<Recipe.Type<Recipe>> SMELTING = getType("smelting");
    public static final Registry.Entry<Recipe.Type<Recipe>> BLASTING = getType("blasting");
    public static final Registry.Entry<Recipe.Type<Recipe>> SMOKING = getType("smoking");
    public static final Registry.Entry<Recipe.Type<Recipe>> CAMPFIRE = getType("campfire");
    public static final Registry.Entry<Recipe.Type<Recipe>> STONECUTTING = getType("stonecutting");

    private static <X extends Recipe> Registry.Entry<Recipe.Type<X>> getType(String id) {
        return (Registry.Entry<Recipe.Type<X>>) (Object) Recipe.Type.REGISTRY.get(Identity.of("minecraft", id));
    }
}