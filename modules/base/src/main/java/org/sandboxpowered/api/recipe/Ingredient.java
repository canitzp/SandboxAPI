package org.sandboxpowered.api.recipe;

import com.google.gson.JsonElement;

import java.util.function.Predicate;

public interface Ingredient<S> extends Predicate<S> {
    S[] getMatching();

    boolean isEmpty();

    JsonElement toJson();
}
