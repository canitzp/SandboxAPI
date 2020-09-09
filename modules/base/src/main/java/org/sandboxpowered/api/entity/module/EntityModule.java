package org.sandboxpowered.api.entity.module;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.data.DataHolder;
import org.sandboxpowered.api.util.nbt.CompoundTag;

import java.util.function.Function;

public interface EntityModule {
    default void tick(Entity entity) {}

    default void deserialize(Entity entity, CompoundTag tag) {
        DataHolder<?>[] holders = getDataHolders();
        if (holders != null) {
            for (DataHolder<?> holder : holders) {
                entity.getDataManager().read(holder.data, tag);
            }
        }
    }

    default void serialize(Entity entity, CompoundTag tag) {
        DataHolder<?>[] holders = getDataHolders();
        if (holders != null) {
            for (DataHolder<?> holder : holders) {
                entity.getDataManager().write(holder.data, tag);
            }
        }
    }

    default DataHolder<?>[] getDataHolders() {
        return null;
    }

    Type<?> getType();

    class Type<T extends EntityModule> {
        private final Function<Type<T>, T> factory;

        public Type(Function<Type<T>, T> factory) {
            this.factory = factory;
        }

        public T create() {
            return factory.apply(this);
        }
    }
}
