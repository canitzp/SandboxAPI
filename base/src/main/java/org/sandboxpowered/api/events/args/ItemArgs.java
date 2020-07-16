package org.sandboxpowered.api.events.args;

import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.eventhandler.priority.Cancellable;

public interface ItemArgs extends Cancellable {

    ItemStack getStack();

    default Item getItem() {
        return getStack().getItem();
    }
}