package org.sandboxpowered.api.entity.module;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.util.nbt.CompoundTag;

public interface EntityModule<T> {
    default void tick(T instance) {}

    T createInstance(Entity entity);

    void deserialize(T instance, CompoundTag tag);

    void serialize(T instance, CompoundTag tag);
}
