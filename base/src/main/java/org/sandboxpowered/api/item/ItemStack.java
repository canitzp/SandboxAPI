package org.sandboxpowered.api.item;

import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.enchantment.Enchantment;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.LivingEntity;
import org.sandboxpowered.api.entity.player.Hand;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.Functions;
import org.sandboxpowered.api.util.InteractionResult;
import org.sandboxpowered.api.util.ItemUse;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.ObjectInteractionResult;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.api.util.nbt.ReadableCompoundTag;
import org.sandboxpowered.api.world.World;

import javax.annotation.Nullable;

public interface ItemStack {

    static ItemStack of(Registry.Entry<Item> entry) {
        return of(entry, 1);
    }

    static ItemStack of(Registry.Entry<Item> entry, int amount) {
        return entry.getAsOptional().map(i -> of(i, amount)).orElse(empty());
    }

    static ItemStack of(ItemProvider item) {
        return of(item, 1);
    }

    static ItemStack of(ItemProvider item, int amount) {
        return item.asItem().map(i -> of(i, amount)).orElse(empty());
    }

    static ItemStack of(Item item) {
        return of(item, 1);
    }

    static ItemStack of(Item item, int amount) {
        return Functions.getInstance().createItemStack(item, amount);
    }

    static ItemStack empty() {
        return of(Items.AIR.get(), 0);
    }

    static ItemStack read(ReadableCompoundTag tag) {
        return Functions.getInstance().createItemStackFromTag(tag);
    }

    //interaction methods
    default ObjectInteractionResult<ItemStack> onUse(World world, PlayerEntity player, Hand hand) {
        return getItem().onUse(world, player, hand);
    }

    default InteractionResult onBlockInteract(ItemUse use) {
        //TODO: construct use here?
        return getItem().onBlockInteract(use);
    }

    default ItemStack onFinishedUsing(World world, LivingEntity user) {
        return getItem().onFinishedUsing(this, world, user);
    }

    default boolean afterHit(LivingEntity target, LivingEntity attacker) {
        return getItem().afterHit(this, target, attacker);
    }

    default boolean afterMine(BlockState state, World world, Position pos, LivingEntity miner) {
        return getItem().afterMine(this, state, world, pos, miner);
    }

    default void onInventoryTick(World world, Entity entity, int slot, boolean selected) {
        getItem().onInventoryTick(this, world, entity, slot, selected);
    }

    default void onCraft(World world, PlayerEntity crafter) {
        getItem().onCraft(this, world, crafter);
    }

    default void onStoppedUsing(World world, LivingEntity user, int remainingTicks) {
        getItem().onStoppedUsing(this, world, user, remainingTicks);
    }

    default void onUseTick(World world, LivingEntity user, int remainingTicks) {
        getItem().onUseTick(world, user, this, remainingTicks);
    }

    boolean isEmpty();

    Item getItem();

    int getCount();

    ItemStack setCount(int amount);

    ItemStack copy();

    default ItemStack shrink() {
        return shrink(1);
    }

    ItemStack shrink(int amount);

    default ItemStack grow() {
        return shrink(1);
    }

    ItemStack grow(int amount);

    int getLevel(Enchantment enchantment);

    boolean hasTag();

    @Nullable
    CompoundTag getTag();

    void setTag(CompoundTag tag);

    CompoundTag getOrCreateTag();

    @Nullable
    CompoundTag getChildTag(String key);

    CompoundTag getOrCreateChildTag(String key);

    CompoundTag asTag();

    default <X> Mono<X> getComponent(Component<X> component) {
        return getItem().getComponent(component, this);
    }

    int getMaxCount();

    boolean isEqualTo(ItemStack stack);

    boolean isEqualToIgnoreDurability(ItemStack stack);

    boolean areTagsEqual(ItemStack stack);

    boolean isDamaged();

    boolean isDamageable();

    int getMaxDamage();

    int getDamage();
}