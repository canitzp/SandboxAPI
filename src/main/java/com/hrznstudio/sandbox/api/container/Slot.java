package com.hrznstudio.sandbox.api.container;

import com.hrznstudio.sandbox.api.component.Inventory;
import com.hrznstudio.sandbox.api.entity.player.Player;
import com.hrznstudio.sandbox.api.item.ItemStack;
import com.hrznstudio.sandbox.api.util.Mono;

public class Slot implements ISlot {
    private Inventory inventory;
    private int index, x, y;

    public Slot(Inventory inventory, int index, int x, int y) {
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
    public boolean canExtract(Player player) {
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
