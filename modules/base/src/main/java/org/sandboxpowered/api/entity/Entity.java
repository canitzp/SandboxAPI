package org.sandboxpowered.api.entity;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.block.Blocks;
import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.entity.data.DataManager;
import org.sandboxpowered.api.entity.data.SyncedData;
import org.sandboxpowered.api.entity.module.EntityModule;
import org.sandboxpowered.api.entity.player.Hand;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.fluid.Fluid;
import org.sandboxpowered.api.fluid.Fluids;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.DamageSource;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.annotation.Alpha;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.math.Vec3d;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.api.world.World;

import java.util.Map;
import java.util.Optional;
import java.util.Random;
import java.util.UUID;

@Alpha
public interface Entity {
    default <X> Mono<X> getComponent(Component<X> component) {
        return Mono.empty();
    }

    Type getType();

    DataManager getDataManager();

    boolean isSneaking();

    default boolean isSubmergedInWater() {
        return isSubmerged(Fluids.WATER);
    }

    default boolean isSubmerged(Registry.Entry<Fluid> fluid) {
        return isSubmerged(fluid.get());
    }

    boolean isSubmerged(Fluid fluid);

    int getAir();

    void setAir(int air);

    boolean isAlive();

    Map<EntityModule.Type<?>, EntityModule> getModules();

    World getWorld();

    UUID getPersistentID();

    Random getRandom();

    Vec3d getMotion();

    Vec3d setMotion();

    //Maybe return a Vec3d?
    double getX();

    double getY();

    double getZ();

    Position getPosition();

    boolean isInvulnerable();

    void queueVelocitySync();

    default <T extends EntityModule> T addModule(EntityModule.Type<T> module) {
        T instance = module.create();
        getModules().put(module, instance);
        for (SyncedData<?> holder : instance.getSyncedData()) {
            getDataManager().add(holder, cast(instance.getInitialValue(holder)));
        }
        return instance;
    }

    default void addModules(EntityModule.Type<?>... modules) {
        for (EntityModule.Type<?> module : modules) {
            addModule(module);
        }
    }

    default boolean hasModule(EntityModule.Type<?> module) {
        return getModules().containsKey(module);
    }

    @SuppressWarnings("unchecked")
    @Nullable
    default <T extends EntityModule> T getModule(EntityModule.Type<T> module) {
        return (T) getModules().get(module);
    }

    default <T extends EntityModule> Optional<T> getOptionalModule(EntityModule.Type<T> module) {
        return Optional.ofNullable(getModule(module));
    }

    default void writeData(CompoundTag tag) {
        for (EntityModule module : getModules().values()) {
            module.serialize(this, tag);
        }
    }

    default void readData(CompoundTag tag) {
        for (EntityModule module : getModules().values()) {
            module.deserialize(this, tag);
        }
    }

    default void tick() {
        for (EntityModule module : getModules().values()) {
            module.tick(this);
        }
    }

    default boolean interact(PlayerEntity player, Hand hand) {
        for (EntityModule module : getModules().values()) {
            if (module.interact(this, player, hand)) return true;
        }

        return false;
    }

    default boolean damage(DamageSource source, float amount) {
        if (isInvulnerableTo(source)) return false;

        for (EntityModule module : getModules().values()) {
            module.damage(this, source, amount);
        }

        queueVelocitySync();
        return false;
    }

    default boolean isInvulnerableTo(DamageSource source) {
        return isInvulnerable() && source != DamageSource.OUT_OF_WORLD && !source.isCreativePlayer();
    }

    default boolean isInsideBubbleColumn() {
        return getWorld().getBlockState(getPosition()).is(Blocks.BUBBLE_COLUMN.get());
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
