package org.sandboxpowered.api.entity;

import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.entity.data.DataHolder;
import org.sandboxpowered.api.entity.data.DataManager;
import org.sandboxpowered.api.entity.module.EntityModule;
import org.sandboxpowered.api.entity.module.SingletonEntityModule;
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

    Map<EntityModule.Type<?>, EntityModule> getModules();

    Vec3d getMotion();

    Vec3d setMotion();

    World getWorld();

    UUID getPersistentID();

    default <T> void addDataHolder(DataHolder<T> holder) {
        getDataManager().add(holder.data, holder.initial);
    }

    default void addModule(EntityModule module) {
        getModules().put(module.getType(), module);
    }

    default void addDataModule(SingletonEntityModule module) {
        addModule(module);
        DataHolder<?>[] holders = module.getDataHolders();
        if (holders != null) {
            for (DataHolder<?> holder : holders) addDataHolder(holder);
        }
    }

    default boolean hasModule(EntityModule.Type<?> module) {
        return getModules().containsKey(module);
    }

    @SuppressWarnings("unchecked")
    default <T extends EntityModule> T getModule(EntityModule.Type<T> module) {
        return (T) getModules().get(module);
    }

    default void readData(CompoundTag tag) {
        for (EntityModule module : getModules().values()) {
            module.deserialize(this, tag);
        }
    }

    default void writeData(CompoundTag tag) {
        for (EntityModule module : getModules().values()) {
            module.serialize(this, tag);
        }
    }

    default void tick() {
        for (EntityModule module : getModules().values()) {
            module.tick(this);
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
