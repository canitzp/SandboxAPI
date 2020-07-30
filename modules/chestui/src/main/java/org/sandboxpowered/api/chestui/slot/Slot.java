package org.sandboxpowered.api.chestui.slot;

import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.item.ItemStack;

import java.util.function.Function;

public interface Slot {
    int getIndex();

    ItemStack getItem(PlayerEntity player);

    void setItem(ItemStack stack);

    void setItem(Function<PlayerEntity, ItemStack> stackFunction);
}