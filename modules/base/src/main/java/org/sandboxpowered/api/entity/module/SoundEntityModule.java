package org.sandboxpowered.api.entity.module;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.data.DataHolder;
import org.sandboxpowered.api.entity.data.DataManager;
import org.sandboxpowered.api.entity.data.DataSerializers;
import org.sandboxpowered.api.entity.data.SyncedData;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.DamageSource;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.SoundCategory;
import org.sandboxpowered.api.util.SoundType;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.nbt.CompoundTag;

/**
 * Entity Module that covers Sound Logic
 */
public class SoundEntityModule extends BaseEntityModule {
    private static final SyncedData<Boolean> SILENT = DataManager.register(Identity.of("sandbox", "silent"), DataSerializers.BOOLEAN);
    private static final SyncedData<?>[] SYNCED_DATA = new SyncedData<?>[] {SILENT};
    private static final String SILENT_KEY = "Silent";

    private double ambientSoundChance;
    private int ambientSoundInterval = 80;
    private SoundType ambientSound, hurtSound, deathSound, stepSound, swimSound;
    private SoundCategory soundCategory;
    private float volume, pitch;

    protected SoundEntityModule(Type<?> type) {
        super(type);
    }

    @Override
    public void serialize(Entity entity, CompoundTag tag) {
        super.serialize(entity, tag);
        tag.setBoolean(SILENT_KEY, isSilent(entity));
    }

    @Override
    public void deserialize(Entity entity, CompoundTag tag) {
        super.deserialize(entity, tag);
        setSilent(entity, tag.getBoolean(SILENT_KEY));
    }

    @Override
    public SyncedData<?>[] getSyncedData() {
        return SYNCED_DATA;
    }

    @Override
    public Object getInitialValue(SyncedData<?> data) {
        return false;
    }

    @Override
    public void tick(Entity entity) {
        if (entity.isAlive() && entity.getRandom().nextDouble() * 1000 < ambientSoundChance++) {
            playAmbientSound(entity);
        }
    }

    @Override
    public void damage(Entity entity, DamageSource source, float amount) {
        playHurtSound(entity);
    }

    @Override
    public void onDeath(Entity entity, DamageSource cause) {
        playDeathSound(entity);
    }

    public int getAmbientSoundInterval() {
        return ambientSoundInterval;
    }

    public SoundEntityModule setAmbientSoundInterval(int ambientSoundInterval) {
        this.ambientSoundInterval = ambientSoundInterval;
        return this;
    }

    public SoundType getAmbientSound() {
        return ambientSound;
    }

    public SoundEntityModule setAmbientSound(SoundType ambientSound) {
        this.ambientSound = ambientSound;
        return this;
    }

    public void playAmbientSound(Entity entity) {
        resetSoundChance();
        playSound(entity, ambientSound);
    }

    public SoundType getHurtSound() {
        return hurtSound;
    }

    public SoundEntityModule setHurtSound(SoundType hurtSound) {
        this.hurtSound = hurtSound;
        return this;
    }

    public void playHurtSound(Entity entity) {
        resetSoundChance();
        playSound(entity, hurtSound);
    }

    public SoundType getDeathSound() {
        return deathSound;
    }

    public SoundEntityModule setDeathSound(SoundType deathSound) {
        this.deathSound = deathSound;
        return this;
    }

    public void playDeathSound(Entity entity) {
        playSound(entity, deathSound);
    }

    public SoundType getStepSound() {
        return stepSound;
    }

    public SoundEntityModule setStepSound(SoundType stepSound) {
        this.stepSound = stepSound;
        return this;
    }

    public void playStepSound(Entity entity, Position pos, BlockState state) {
        // todo: SoundTypes, so this will be a placeholder
        playSound(entity, stepSound, 0.15f, 1f);
    }

    public SoundType getSwimSound() {
        return swimSound;
    }

    public SoundEntityModule setSwimSound(SoundType swimSound) {
        this.swimSound = swimSound;
        return this;
    }

    public void playSwimSound(Entity entity, float volume) {
        playSound(entity, swimSound, volume, 1 + (entity.getRandom().nextFloat() - entity.getRandom().nextFloat()) * 0.4f);
    }

    public SoundEntityModule setStandardSounds(SoundType ambient, SoundType hurt, SoundType death) {
        this.ambientSound = ambient;
        this.hurtSound = hurt;
        this.deathSound = death;
        return this;
    }

    public SoundCategory getSoundCategory() {
        return soundCategory;
    }

    public SoundEntityModule setSoundCategory(SoundCategory soundCategory) {
        this.soundCategory = soundCategory;
        return this;
    }

    public float getVolume() {
        return volume;
    }

    public float getPitch() {
        return pitch;
    }

    public SoundEntityModule setVolumeAndPitch(float volume, float pitch) {
        this.volume = volume;
        this.pitch = pitch;
        return this;
    }

    public void playSound(Entity entity, SoundType sound, float volume, float pitch) {
        if (sound != null && !isSilent(entity)) {
            entity.getWorld().playSound(null, entity.getX(), entity.getY(), entity.getZ(), sound, soundCategory, volume, pitch);
        }
    }

    public void playSound(Entity entity, SoundType sound) {
        playSound(entity, sound, volume, pitch);
    }

    public void resetSoundChance() {
        this.ambientSoundChance = -ambientSoundInterval;
    }

    public boolean isSilent(Entity entity) {
        return entity.getDataManager().get(SILENT);
    }

    public void setSilent(Entity entity, boolean flag) {
        entity.getDataManager().set(SILENT, flag);
    }
}
