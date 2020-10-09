package org.sandboxpowered.api.entity.module;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.player.Hand;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.internal.InternalService;

import java.util.Collections;
import java.util.HashSet;
import java.util.Set;
import java.util.UUID;

/**
 * Entity Module that covers Breeding Logic
 */
public class BreedingEntityModule extends BaseEntityModule {
    private final Set<Item> foodItems = new HashSet<>();

    @Nullable
    private UUID breeder;
    private int inLove;

    protected BreedingEntityModule(Type<?> type) {
        super(type);
    }

    @Override
    public void serialize(Entity entity, CompoundTag tag) {
        InternalService.getInstance().serializeEntityModule(this, entity, tag);
    }

    @Override
    public void deserialize(Entity entity, CompoundTag tag) {
        InternalService.getInstance().deserializeEntityModule(this, entity, tag);
    }

    @Override
    public boolean interact(Entity entity, PlayerEntity player, Hand hand) {
        ItemStack stack = player.getHeldItem(hand);

        if (isFoodItem(stack)) {
            if (canBreed(entity)) {
                stack.shrink();
                setInLove(player);
                // player arm swing animations?
                return true;
            }
        }

        return false;
    }

    public void setInLove(@Nullable PlayerEntity player) {
        this.inLove = 600;
        this.breeder = player == null ? null : player.getPersistentID();
        // particles?
    }

    public void setInLove(int ticks) {
        this.inLove = ticks;
    }

    public void addFoodItems(Item... items) {
        Collections.addAll(foodItems, items);
    }

    public boolean isFoodItem(ItemStack stack) {
        return foodItems.contains(stack.getItem());
    }

    public boolean canBreed(Entity entity) {
        return inLove <= 0 && !entity.getOptionalModule(EntityModules.AGING)
                .map(module -> module.isChild(entity))
                .orElse(false);
    }

    public PlayerEntity getBreeder(Entity entity) {
        return (PlayerEntity) entity.getWorld().getEntityByUUID(breeder);
    }
}
