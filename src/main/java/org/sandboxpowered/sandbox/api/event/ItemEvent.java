package org.sandboxpowered.sandbox.api.event;

import org.sandboxpowered.sandbox.api.item.ItemStack;

public class ItemEvent extends Event {
    private final ItemStack stack;

    public ItemEvent(ItemStack stack) {
        this.stack = stack;
    }

    public ItemStack getStack() {
        return stack;
    }

    public static class GetArrowType extends ItemEvent {
        private ItemStack arrow;

        public GetArrowType(ItemStack stack, ItemStack arrow) {
            super(stack);
            this.arrow = arrow;
        }

        public ItemStack getWeapon() {
            return this.getStack();
        }

        public ItemStack getArrow() {
            return arrow;
        }

        public void setArrow(ItemStack arrow) {
            checkState();
            this.arrow = arrow;
        }
    }
}
