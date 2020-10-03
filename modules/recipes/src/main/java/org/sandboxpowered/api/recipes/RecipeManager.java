package org.sandboxpowered.api.recipes;

import java.util.List;

public interface RecipeManager {
    <R extends Recipe> R getFirst(Recipe.Type<R> type, RecipeContext context);

    <R extends Recipe> List<R> getMatches(Recipe.Type<R> type, RecipeContext context);

    <R extends Recipe> List<R> getAll(Recipe.Type<R> type);
}