package org.sandboxpowered.api.recipes;

import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Identity;

public class RecipeTypes {
    public static final Registry.Entry<Recipe.Type<?>> CRAFTING = getType("crafting");
    public static final Registry.Entry<Recipe.Type<?>> SMELTING = getType("smelting");
    public static final Registry.Entry<Recipe.Type<?>> BLASTING = getType("blasting");
    public static final Registry.Entry<Recipe.Type<?>> SMOKING = getType("smoking");
    public static final Registry.Entry<Recipe.Type<?>> CAMPFIRE = getType("campfire");
    public static final Registry.Entry<Recipe.Type<?>> STONECUTTING = getType("stonecutting");

    private static Registry.Entry<Recipe.Type<?>> getType(String id) {
        return (Registry.Entry<Recipe.Type<?>>) (Object) Recipe.Type.REGISTRY.get(Identity.of("minecraft", id));
    }
}