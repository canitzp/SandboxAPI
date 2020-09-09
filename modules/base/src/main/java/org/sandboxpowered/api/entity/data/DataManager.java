package org.sandboxpowered.api.entity.data;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.internal.InternalService;

import java.util.Optional;

public interface DataManager {
    static <T> SyncedData<T> register(Identity id, SyncedData.SyncedDataSerializer<T> serializer) {
        return register(id, serializer, true);
    }

    static <T> SyncedData<T> register(Identity id, SyncedData.SyncedDataSerializer<T> serializer, boolean saveToWorld) {
        return InternalService.getInstance().registerSyncedData(id, serializer, saveToWorld);
    }

    <T> void add(SyncedData<T> data, @Nullable T initial);

    <T> void set(SyncedData<T> data, @Nullable T value);

    @Nullable
    <T> T getNullable(SyncedData<T> data);

    default <T> T get(SyncedData<T> data) {
        T value = getNullable(data);
        if (value == null) throw new NullPointerException("value: " + data.getClass().getSimpleName());
        return value;
    }

    default <T> Optional<T> getOptional(SyncedData<T> data) {
        return Optional.ofNullable(getNullable(data));
    }

    default <T> void read(SyncedData<T> data, CompoundTag tag) {
        String key = data.getId().toString();
        if (data.isNotSerialized()) throw new IllegalStateException(data.getClass().getSimpleName() + " " + key + " can not be serialized");

        set(data, data.getSerializer().read(tag, key));
    }

    default <T> void write(SyncedData<T> data, CompoundTag tag) {
        String key = data.getId().toString();
        if (data.isNotSerialized()) throw new IllegalStateException(data.getClass().getSimpleName() + " " + key + " can not be serialized");

        data.getSerializer().write(tag, key, get(data));
    }
}
