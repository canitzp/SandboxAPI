package org.sandboxpowered.api.entity.data;

import org.sandboxpowered.api.network.PacketBuffer;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.nbt.CompoundTag;

public interface SyncedData<T> {
    Identity getId();

    SyncedDataSerializer<T> getSerializer();

    boolean isSavedInWorld();

    interface SyncedDataSerializer<T> {
        T read(PacketBuffer buf);

        void write(PacketBuffer buf, T value);

        T read(CompoundTag tag, String key);

        void write(CompoundTag buf, String key, T value);

        T copy(T value);
    }
}
