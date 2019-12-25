package org.sandboxpowered.sandbox.api.event;

import org.sandboxpowered.sandbox.api.enchantment.Enchantment;
import org.sandboxpowered.sandbox.api.item.ItemStack;

import java.util.function.BiPredicate;

public class EnchantmentEvent extends Event {
    private final Enchantment enchantment;

    public EnchantmentEvent(Enchantment enchantment) {
        this.enchantment = enchantment;
    }

    public Enchantment getEnchantment() {
        return enchantment;
    }

    @HasResult
    public static class AcceptableItem extends EnchantmentEvent {
        private final ItemStack stack;

        public AcceptableItem(Enchantment enchantment, ItemStack stack) {
            super(enchantment);
            this.stack = stack;
        }

        public ItemStack getStack() {
            return stack;
        }
    }

    @HasResult
    public static class Compatible extends EnchantmentEvent {
        private final Enchantment other;

        public Compatible(Enchantment enchantment, Enchantment other) {
            super(enchantment);
            this.other = other;
        }

        public Enchantment getOther() {
            return other;
        }

        public boolean matches(BiPredicate<Enchantment, Enchantment> predicate) {
            return predicate.test(getEnchantment(), getOther()) || predicate.test(getOther(), getEnchantment());
        }

        public boolean matches(Enchantment enchant1, Enchantment enchant2) {
            return (getEnchantment() == enchant1 && getOther() == enchant2) || (getEnchantment() == enchant2 && getOther() == enchant1);
        }
    }
}