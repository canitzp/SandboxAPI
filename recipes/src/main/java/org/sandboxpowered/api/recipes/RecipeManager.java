package org.sandboxpowered.api.recipes;

import org.sandboxpowered.api.component.Inventory;
import org.sandboxpowered.api.world.World;

import java.util.List;

public interface RecipeManager {
    <I extends Inventory, R extends Recipe<I>> R getFirst(Recipe.Type<R> type, I inventory, World world);

    <I extends Inventory, R extends Recipe<I>> List<R> getMatches(Recipe.Type<R> type, I inventory, World world);

    <R extends Recipe<?>> List<R> getAll(Recipe.Type<R> type);
}