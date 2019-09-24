package com.hrznstudio.sandbox.api.container;

import com.google.common.annotations.Beta;
import com.hrznstudio.sandbox.api.component.Inventory;
import com.hrznstudio.sandbox.api.entity.player.Player;
import com.hrznstudio.sandbox.api.item.ItemStack;
import com.hrznstudio.sandbox.api.util.Mono;

@Beta
public interface ISlot {

    int getXPosition();

    int getYPosition();

    Inventory getInventory();

    boolean canInsert(ItemStack stack);

    boolean canExtract(Player player);

    int getMaxCount();

    boolean drawHovering();

    ItemStack getStack();

    void setStack(ItemStack stack);

    boolean hasStack();

    ItemStack takeStack(int amount);

    Mono<String> getBackgroundSprite();
}