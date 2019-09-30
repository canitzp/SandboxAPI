package org.sandboxpowered.sandbox.api.container;

import org.sandboxpowered.sandbox.api.component.Inventory;
import org.sandboxpowered.sandbox.api.entity.player.PlayerEntity;
import org.sandboxpowered.sandbox.api.item.ItemStack;
import org.sandboxpowered.sandbox.api.util.Mono;
import org.sandboxpowered.sandbox.api.util.annotation.Alpha;

@Alpha
public class BaseSlot implements Slot {
    private Inventory inventory;
    private int index, x, y;

    public BaseSlot(Inventory inventory, int index, int x, int y) {
        this.inventory = inventory;
        this.index = index;
        this.x = x;
        this.y = y;
    }

    @Override
    public Inventory getInventory() {
        return inventory;
    }

    @Override
    public int getXPosition() {
        return x;
    }

    @Override
    public int getYPosition() {
        return y;
    }

    @Override
    public boolean canInsert(ItemStack stack) {
        return true;
    }

    @Override
    public boolean canExtract(PlayerEntity player) {
        return true;
    }

    @Override
    public int getMaxCount() {
        return inventory.getMaxStackSize(index);
    }

    @Override
    public boolean drawHovering() {
        return true;
    }

    @Override
    public ItemStack getStack() {
        return inventory.get(index);
    }

    @Override
    public void setStack(ItemStack stack) {
        inventory.setStack(index, stack);
    }

    @Override
    public boolean hasStack() {
        return !getStack().isEmpty();
    }

    @Override
    public ItemStack takeStack(int amount) {
        return inventory.extract(index, amount);
    }

    @Override
    public Mono<String> getBackgroundSprite() {
        return Mono.empty();
    }
}
