package org.sandboxpowered.api.entity;

import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.entity.data.DataManager;
import org.sandboxpowered.api.entity.data.EntityDataHolder;
import org.sandboxpowered.api.entity.data.SyncedData;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.annotation.Alpha;
import org.sandboxpowered.api.util.nbt.CompoundTag;

import java.util.Collections;
import java.util.List;

@Alpha
public interface Entity {
    default <X> Mono<X> getComponent(Component<X> component) {
        return Mono.empty();
    }

    Type getType();

    DataManager getDataManager();

    boolean isSneaking();

    List<SyncedData<?>> getDataKeys();

    default void addDataHolder(EntityDataHolder holder) {
        Collections.addAll(getDataKeys(), holder.getEntityData());
    }

    //The base data storing could potentially be moved to the implementations
    default void readData(CompoundTag tag) {
        for (SyncedData<?> dataKey : getDataKeys()) {
            if (dataKey.isSavedInWorld()) getDataManager().read(dataKey, tag);
        }
    }

    default void writeData(CompoundTag tag) {
        for (SyncedData<?> dataKey : getDataKeys()) {
            if (dataKey.isSavedInWorld()) getDataManager().write(dataKey, tag);
        }
    }

    interface Type extends Content<Type> {
        Registry<Type> REGISTRY = Registry.getRegistryFromType(Type.class);

        @Override
        default Class<Type> getContentType() {
            return Type.class;
        }
    }
}
