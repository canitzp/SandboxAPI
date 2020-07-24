package org.sandboxpowered.api.events.args;

import org.sandboxpowered.api.item.ItemStack;

public interface ArrowTypeArgs {
    ItemStack getWeapon();

    ItemStack getArrow();

    void setArrow(ItemStack stack);
}