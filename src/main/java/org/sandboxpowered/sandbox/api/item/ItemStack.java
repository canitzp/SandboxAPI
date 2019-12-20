package org.sandboxpowered.sandbox.api.item;

import org.sandboxpowered.sandbox.api.component.Component;
import org.sandboxpowered.sandbox.api.enchant.Enchantment;
import org.sandboxpowered.sandbox.api.registry.Registry;
import org.sandboxpowered.sandbox.api.util.Functions;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.nbt.CompoundTag;
import org.sandboxpowered.sandbox.api.util.nbt.ReadableCompoundTag;

import javax.annotation.Nullable;

public interface ItemStack {

    static ItemStack of(ItemProvider item) {
        return of(item, 1);
    }

    static ItemStack of(ItemProvider item, int amount) {
        return of(item.asItem(), amount);
    }

    static ItemStack of(Mono<Item> mono) {
        return of(mono, 1);
    }

    static ItemStack of(Mono<Item> mono, int amount) {
        return mono.isPresent() ? of(mono.get(), amount) : empty();
    }

    static ItemStack of(Item item) {
        return of(item, 1);
    }

    static ItemStack of(Item item, int amount) {
        return Functions.getInstance().createItemStack(item, amount);
    }

    static ItemStack empty() {
        return of(Items.AIR, 0);
    }

    static ItemStack read(ReadableCompoundTag tag) {
        return Functions.getInstance().createItemStackFromTag(tag);
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