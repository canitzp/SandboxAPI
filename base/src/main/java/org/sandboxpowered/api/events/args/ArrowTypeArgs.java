package org.sandboxpowered.api.events.args;

import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.eventhandler.priority.Cancellable;

public interface ArrowTypeArgs extends Cancellable {
    ItemStack getWeapon();

    ItemStack getArrow();

    void setArrow(ItemStack stack);
}