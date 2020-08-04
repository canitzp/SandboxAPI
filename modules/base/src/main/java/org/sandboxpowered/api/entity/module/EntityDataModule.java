package org.sandboxpowered.api.entity.module;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.data.SyncedData;
import org.sandboxpowered.api.util.nbt.CompoundTag;

public interface EntityDataModule extends EntityModule<Entity> {
    @Override
    default Entity createInstance(Entity entity) {
        return entity;
    }

    SyncedData<?>[] getEntityData();

    @Override
    default void deserialize(Entity entity, CompoundTag tag) {
        for (SyncedData<?> data : getEntityData()) {
            entity.getDataManager().read(data, tag);
        }
    }

    @Override
    default void serialize(Entity entity, CompoundTag tag) {
        for (SyncedData<?> data : getEntityData()) {
            entity.getDataManager().write(data, tag);
        }
    }
}
