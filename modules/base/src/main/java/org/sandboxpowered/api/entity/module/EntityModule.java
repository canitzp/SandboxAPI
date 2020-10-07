package org.sandboxpowered.api.entity.module;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.data.SyncedData;
import org.sandboxpowered.api.entity.player.Hand;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.util.DamageSource;
import org.sandboxpowered.api.util.nbt.CompoundTag;

import java.util.function.Function;

public interface EntityModule {
    SyncedData<?>[] EMPTY_SYNCED_DATA = new SyncedData<?>[0];

    default void tick(Entity entity) {
    }

    default boolean interact(Entity instance, PlayerEntity player, Hand hand) {
        return false;
    }

    default void damage(Entity instance, DamageSource source, float amount) {
    }

    default void onDeath(Entity instance, DamageSource cause) {
    }

    default void serialize(Entity entity, CompoundTag tag) {
        for (SyncedData<?> holder : getSyncedData()) {
            entity.getDataManager().write(holder, tag);
        }
    }

    default void deserialize(Entity entity, CompoundTag tag) {
        for (SyncedData<?> data : getSyncedData()) {
            entity.getDataManager().read(data, tag);
        }
    }

    default SyncedData<?>[] getSyncedData() {
        return EMPTY_SYNCED_DATA;
    }

    default Object getInitialValue(SyncedData<?> data) {
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
