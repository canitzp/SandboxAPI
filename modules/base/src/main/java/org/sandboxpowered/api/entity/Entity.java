package org.sandboxpowered.api.entity;

import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.entity.data.DataManager;
import org.sandboxpowered.api.entity.module.EntityDataModule;
import org.sandboxpowered.api.entity.data.SyncedData;
import org.sandboxpowered.api.entity.module.EntityModule;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.annotation.Alpha;
import org.sandboxpowered.api.util.math.Vec3d;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.api.world.World;

import java.util.Map;
import java.util.UUID;

@Alpha
public interface Entity {
    default <X> Mono<X> getComponent(Component<X> component) {
        return Mono.empty();
    }

    Type getType();

    DataManager getDataManager();

    boolean isSneaking();

    Map<EntityModule<?>, ?> getModules();

    Vec3d getMotion();

    Vec3d setMotion();

    World getWorld();

    UUID getPersistentID();

    default void addDataModule(EntityDataModule module) {
        addModule(module);
        for (SyncedData<?> entityData : module.getEntityData()) {
            getDataManager().add(entityData, null);
        }
    }

    default void addModule(EntityModule<?> module) {
        getModules().put(module, cast(module.createInstance(this)));
    }

    default boolean hasModule(EntityModule<?> module) {
        return getModules().containsKey(module);
    }

    default <T> T getModule(EntityModule<T> module) {
        return cast(getModules().get(module));
    }

    default void readData(CompoundTag tag) {
        for (Map.Entry<EntityModule<?>, ?> module : getModules().entrySet()) {
            module.getKey().deserialize(cast(module.getValue()), tag);
        }
    }

    default void writeData(CompoundTag tag) {
        for (Map.Entry<EntityModule<?>, ?> module : getModules().entrySet()) {
            module.getKey().serialize(cast(module.getValue()), tag);
        }
    }

    default void tick() {
        for (Map.Entry<EntityModule<?>, ?> module : getModules().entrySet()) {
            module.getKey().tick(cast(module.getValue()));
        }
    }

    @SuppressWarnings("unchecked")
    static <F, T> T cast(F from) {
        return (T) from;
    }

    interface Type extends Content<Type> {
        Registry<Type> REGISTRY = Registry.getRegistryFromType(Type.class);

        @Override
        default Class<Type> getContentType() {
            return Type.class;
        }
    }
}
