package com.hrznstudio.sandbox.api.event;

import com.hrznstudio.sandbox.api.enchant.IEnchantment;
import com.hrznstudio.sandbox.api.item.ItemStack;
import com.hrznstudio.sandbox.api.util.InteractionResult;

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
}