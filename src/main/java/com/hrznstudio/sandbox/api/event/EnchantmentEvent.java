package com.hrznstudio.sandbox.api.event;

import com.hrznstudio.sandbox.api.enchant.IEnchantment;
import com.hrznstudio.sandbox.api.item.ItemStack;
import com.hrznstudio.sandbox.api.util.InteractionResult;

import java.util.function.BiPredicate;

public class EnchantmentEvent extends Event {
    private final IEnchantment enchantment;

    public EnchantmentEvent(IEnchantment enchantment) {
        this.enchantment = enchantment;
    }

    public IEnchantment getEnchantment() {
        return enchantment;
    }

    public static class AcceptableItem extends EnchantmentEvent {
        private final ItemStack stack;
        private InteractionResult result = InteractionResult.IGNORE;

        public AcceptableItem(IEnchantment enchantment, ItemStack stack) {
            super(enchantment);
            this.stack = stack;
        }

        public ItemStack getStack() {
            return stack;
        }

        public InteractionResult getResult() {
            return result;
        }

        public void setResult(InteractionResult result) {
            checkState();
            this.result = result;
        }
    }

    public static class Compatible extends EnchantmentEvent {
        private final IEnchantment other;
        private InteractionResult result = InteractionResult.IGNORE;

        public Compatible(IEnchantment enchantment, IEnchantment other) {
            super(enchantment);
            this.other = other;
        }

        public IEnchantment getOther() {
            return other;
        }

        public InteractionResult getResult() {
            return result;
        }

        public boolean matches(BiPredicate<IEnchantment, IEnchantment> predicate) {
            return predicate.test(getEnchantment(), getOther()) || predicate.test(getOther(), getEnchantment());
        }

        public boolean matches(IEnchantment enchant1, IEnchantment enchant2) {
            return (getEnchantment() == enchant1 && getOther() == enchant2) || (getEnchantment() == enchant2 && getOther() == enchant1);
        }

        public void setResult(InteractionResult result) {
            checkState();
            this.result = result;
        }
    }
}