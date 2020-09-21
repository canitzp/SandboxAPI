package org.sandboxpowered.api.recipe;

import com.google.gson.JsonElement;

import java.util.function.Predicate;

public interface Ingredient<S> extends Predicate<S> {
    static <T> Ingredient<T> from(T t) {
        return null;
    }

    @SafeVarargs
    static <T> Ingredient<T> from(T... ts) {
        return null;
    }

    S[] getMatching();

    boolean isEmpty();

    JsonElement toJson();

    interface Deserializer<T> {
        Ingredient<T> fromJson(JsonElement element);
    }
}