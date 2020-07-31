package org.sandboxpowered.api.entity.data;

import org.sandboxpowered.api.network.PacketBuffer;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.internal.InternalService;

public interface SyncedData<T> {
    static <T> SyncedData<T> of(Identity id, SyncedDataSerializer<T> serializer, boolean saveToWorld) {
        return InternalService.getInstance().makeSyncedData(id, serializer, saveToWorld);
    }

    Identity getId();

    SyncedDataSerializer<T> getSerializer();

    boolean isSavedInWorld();

    interface SyncedDataSerializer<T> {
        T read(PacketBuffer buf);

        void write(PacketBuffer buf, T value);

        T read(CompoundTag tag, String key);

        void write(CompoundTag buf, String key, T value);

        T copy(T value);

        default SyncedData<T> createKey(Identity id, boolean saveToWorld) {
            return SyncedData.of(id, this, saveToWorld);
        }
    }
}
