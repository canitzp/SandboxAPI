package org.sandboxpowered.api.recipes;

import com.google.gson.JsonObject;
import org.sandboxpowered.api.component.Inventory;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.nbt.ReadableCompoundTag;
import org.sandboxpowered.api.util.nbt.WritableCompoundTag;
import org.sandboxpowered.api.world.WorldReader;

import java.util.Collection;

public interface Recipe<I extends Inventory> {
    Identity getIdentity();

    boolean matches(I inventory, WorldReader reader);

    ItemStack getPreviewResult();

    ItemStack getCraftingResult(I inventory, WorldReader reader);

    Type<?> getType();

    Collection<ItemStack> getRemainingStacks(I inventory, WorldReader reader);

    interface Serializer<R extends Recipe<?>> {
        void write(R recipe, WritableCompoundTag tag);

        R read(ReadableCompoundTag tag);

        R fromJson(JsonObject object);
    }

    @SuppressWarnings("rawtypes")
    interface Type<R extends Recipe<?>> extends Content<Type<R>> {
        Registry<Type> REGISTRY = Registry.getRegistryFromType(Type.class);
    }
}