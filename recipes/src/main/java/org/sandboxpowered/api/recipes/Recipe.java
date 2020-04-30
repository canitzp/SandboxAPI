package org.sandboxpowered.api.recipes;

import org.sandboxpowered.api.component.Inventory;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.nbt.ReadableCompoundTag;
import org.sandboxpowered.api.util.nbt.WritableCompoundTag;
import org.sandboxpowered.api.world.World;

public interface Recipe<I extends Inventory> {

    Identity getIdentity();

    boolean matches(I inventory, World world);

    Type<?> getType();

    interface Serializer<R extends Recipe<?>> {
        void write(R recipe, WritableCompoundTag tag);

        R read(ReadableCompoundTag tag);
    }

    interface Type<R extends Recipe<?>> extends Content<Type<R>> {

    }
}
