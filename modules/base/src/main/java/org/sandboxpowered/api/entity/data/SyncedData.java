package org.sandboxpowered.api.entity.data;

import org.sandboxpowered.api.network.PacketBuffer;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.nbt.CompoundTag;

public interface SyncedData<T> {
    Identity getId();

    SyncedDataSerializer<T> getSerializer();

    boolean isNotSerialized();

    interface SyncedDataSerializer<T> {
        T read(PacketBuffer buf);

        void write(PacketBuffer buf, T value);

        default T read(CompoundTag tag, String key) {
            throw new RuntimeException("Tried to read using serializer that has no implementation: " + getClass().getSimpleName());
        }

        default void write(CompoundTag buf, String key, T value) {
            throw new RuntimeException("Tried to write using serializer that has no implementation: " + getClass().getSimpleName());
        }

        T copy(T value);
    }
}
