package org.sandboxpowered.api.entity.data;

public class DataHolder<T> {
    public final SyncedData<T> data;
    public final T initial;

    public DataHolder(SyncedData<T> data, T initial) {
        this.data = data;
        this.initial = initial;
    }
}
