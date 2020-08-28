package org.sandboxpowered.api.entity.module;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.data.DataHolder;
import org.sandboxpowered.api.entity.data.DataManager;
import org.sandboxpowered.api.entity.data.DataSerializers;
import org.sandboxpowered.api.entity.data.SyncedData;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.util.Identity;

import java.util.Optional;
import java.util.UUID;

public class TameableEntityModule extends SingletonEntityModule {
    private static final SyncedData<Byte> TAMEABLE_DATA = DataManager.register(Identity.of("sandbox", "tameable_data"), DataSerializers.BYTE);
    private static final SyncedData<UUID> OWNER = DataManager.register(Identity.of("sandbox", "owner"), DataSerializers.UUID);
    private static final DataHolder<?>[] DATA_HOLDERS = new DataHolder<?>[]{new DataHolder<>(TAMEABLE_DATA, (byte) 0), new DataHolder<>(OWNER, null)};

    private static final int TAMED = 1;
    private static final int SITTING = 2;

    @Override
    public DataHolder<?>[] getDataHolders() {
        return DATA_HOLDERS;
    }

    public boolean isTamed(Entity entity) {
        return (entity.getDataManager().get(TAMEABLE_DATA) & TAMED) != 0;
    }

    public void setTamed(Entity entity, boolean tamed) {
        byte b = entity.getDataManager().get(TAMEABLE_DATA);
        entity.getDataManager().set(TAMEABLE_DATA, tamed ? (byte) (b | TAMED) : (byte) (b & ~TAMED));
    }

    public boolean isSitting(Entity entity) {
        return (entity.getDataManager().get(TAMEABLE_DATA) & SITTING) != 0;
    }

    public void setIsSitting(Entity entity, boolean inSittingPose) {
        byte b = entity.getDataManager().get(TAMEABLE_DATA);
        entity.getDataManager().set(TAMEABLE_DATA, inSittingPose ? (byte) (b | SITTING) : (byte) (b & ~SITTING));
    }

    public Optional<UUID> getOwnerID(Entity entity) {
        return entity.getDataManager().getOptional(OWNER);
    }

    public void setOwnerID(Entity entity, @Nullable UUID uuid) {
        entity.getDataManager().set(OWNER, uuid);
    }

    public void setOwner(Entity entity, PlayerEntity player) {
        this.setTamed(entity, true);
        this.setOwnerID(entity, player.getPersistentID());
        //Advancement?
    }

    public Optional<Entity> getOwner(Entity entity) {
        return getOwnerID(entity).map(uuid -> entity.getWorld().getEntityByUUID(uuid));
    }
}
