package org.sandboxpowered.api.recipes;

import com.google.gson.JsonObject;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.nbt.ReadableCompoundTag;
import org.sandboxpowered.api.util.nbt.WritableCompoundTag;

public interface Recipe {
    Identity getIdentity();

    boolean matches(RecipeContext context);

    Type<?> getType();

    void result(RecipeContext context);

    interface Serializer<R extends Recipe> {
        void write(R recipe, WritableCompoundTag tag);

        R read(ReadableCompoundTag tag);

        R fromJson(JsonObject object);
    }

    @SuppressWarnings({"rawtypes", "unchecked"})
    interface Type<R extends Recipe> extends Content<Type<R>> {
        Registry<Type> REGISTRY = Registry.getRegistryFromType(Type.class);

        static Builder builder(Identity identity) {
            return null;
        }

        interface Builder {
            <T> Builder withInput(Ingredient<T> ingredient);

            <T> Builder withOutput(Ingredient<T> ingredient);

            <R extends Recipe> Type<R> build(Class<R> rClass);
        }
    }
}