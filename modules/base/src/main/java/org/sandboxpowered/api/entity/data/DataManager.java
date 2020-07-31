package org.sandboxpowered.api.entity.data;

import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.internal.InternalService;

public interface DataManager {
    static <T> SyncedData<T> registerData(SyncedData.SyncedDataSerializer<T> serializer, boolean saveToWorld) {
        return InternalService.getInstance().registerSyncedData(serializer, saveToWorld);
    }

    <T> void add(SyncedData<T> data, T initial);

    <T> void set(SyncedData<T> data, T value);

    <T> T get(SyncedData<T> data);

    default <T> void read(SyncedData<T> data, CompoundTag tag) {
        String key = data.getId().toString();
        if (!data.isSavedInWorld()) throw new IllegalStateException("SyncedData " + key + " can not be serialized");

        set(data, data.getSerializer().read(tag, key));
    }

    default <T> void write(SyncedData<T> data, CompoundTag tag) {
        String key = data.getId().toString();
        if (!data.isSavedInWorld()) throw new IllegalStateException("SyncedData " + key + " can not be serialized");

        data.getSerializer().write(tag, key, get(data));
    }
}
