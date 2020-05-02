package org.sandboxpowered.api.recipes;

import java.util.List;

public interface RecipeContext {

    <T> T getInput(Ingredient<T> ingredient, int index);

    <T> List<T> getInputs(Ingredient<T> ingredient);

    <T> void addOutput(Ingredient<T> ingredient, T out);

    <T> void addOutput(Ingredient<T> ingredient, T... out);

}