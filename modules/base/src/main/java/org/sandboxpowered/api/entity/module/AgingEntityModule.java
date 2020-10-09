package org.sandboxpowered.api.entity.module;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.data.DataManager;
import org.sandboxpowered.api.entity.data.DataSerializers;
import org.sandboxpowered.api.entity.data.SyncedData;
import org.sandboxpowered.api.entity.player.Hand;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.internal.InternalService;

/**
 * Entity Module that covers Aging Logic
 */
public class AgingEntityModule extends BaseEntityModule {
    private static final SyncedData<Boolean> CHILD = DataManager.register(Identity.of("sandbox", "child"), DataSerializers.BOOLEAN, false);
    private static final SyncedData<?>[] SYNCED_DATA = new SyncedData<?>[] {CHILD};
    private int age;

    protected AgingEntityModule(Type<?> type) {
        super(type);
    }

    @Override
    public void serialize(Entity entity, CompoundTag tag) {
        super.serialize(entity, tag);
        InternalService.getInstance().serializeEntityModule(this, entity, tag);
    }

    @Override
    public void deserialize(Entity entity, CompoundTag tag) {
        super.deserialize(entity, tag);
        InternalService.getInstance().deserializeEntityModule(this, entity, tag);
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
        if (entity.isAlive()) {
            int age = getAge(entity);

            if (age < 0) {
                ageUp(entity, age + 1);
            }
        }
    }

    @Override
    public boolean interact(Entity entity, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);
        if (isChild(entity) && entity.getOptionalModule(EntityModules.BREEDING).map(m -> m.isFoodItem(stack)).orElse(false)) {
            stack.shrink();
            ageUp(entity, (int) (getAge(entity) / -20f * 0.1f));
            return true;
        }

        // babies from spawn eggs?

        return false;
    }

    public void setAge(Entity entity, int age) {
        int prev = this.age;
        this.age = age;
        if (prev < 0 != age < 0) entity.getDataManager().set(CHILD, age < 0);
    }

    public int getAge(Entity entity) {
        if (entity.getWorld().isClient()) return entity.getDataManager().get(CHILD) ? -1 : 1;
        else return this.age;
    }

    public void ageUp(Entity entity, int growthInSeconds) {
        setAge(entity, Math.min(getAge(entity) + (growthInSeconds * 20), 0));
    }

    public boolean isChild(Entity entity) {
        return getAge(entity) < 0;
    }

    public boolean isAdult(Entity entity) {
        return !isChild(entity);
    }
}
