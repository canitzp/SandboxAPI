package org.sandboxpowered.api.recipe;

import com.google.gson.JsonElement;
import org.sandboxpowered.internal.InternalService;

import java.util.function.Predicate;

public interface Ingredient<S> extends Predicate<S> {
    static <T> Ingredient<T> of(T t) {
        return InternalService.getInstance().ingredient_of(t);
    }

    @SafeVarargs
    static <T> Ingredient<T> of(T... ts) {
        return InternalService.getInstance().ingredient_ofArray(ts);
    }

    static <T> Ingredient<T> fromJson(Class<T> type, JsonElement element) {
        return InternalService.getInstance().ingredient_fromJson(type, element);
    }

    S[] getMatching();

    boolean isEmpty();

    JsonElement toJson();

    interface Deserializer<T> {
        Ingredient<T> fromJson(JsonElement element);
    }
}