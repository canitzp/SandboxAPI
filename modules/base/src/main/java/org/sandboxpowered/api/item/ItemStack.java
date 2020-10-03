package org.sandboxpowered.api.item;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.enchantment.Enchantment;
import org.sandboxpowered.api.entity.LivingEntity;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.api.util.nbt.ReadableCompoundTag;
import org.sandboxpowered.internal.InternalService;

import java.util.Set;

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
        return InternalService.getInstance().createItemStack(item, amount);
    }

    static ItemStack empty() {
        return of(Items.AIR.get(), 0);
    }

    static ItemStack read(ReadableCompoundTag tag) {
        return InternalService.getInstance().createItemStackFromTag(tag);
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

    default boolean has(Registry.Entry<Enchantment> enchantment) {
        return enchantment.isPresent() && has(enchantment.get());
    }

    boolean has(Enchantment enchantment);

    default int getLevel(Registry.Entry<Enchantment> enchantment) {
        return enchantment.isPresent() ? getLevel(enchantment.get()) : 0;
    }

    int getLevel(Enchantment enchantment);

    Set<Enchantment> getEnchantments();

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

    void damage(int damage, LivingEntity entity);
}