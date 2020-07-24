package org.sandboxpowered.api.events.args;

import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.eventhandler.core.EventArgs;

public interface ArrowTypeArgs extends EventArgs {
    ItemStack getWeapon();

    ItemStack getArrow();

    void setArrow(ItemStack stack);
}