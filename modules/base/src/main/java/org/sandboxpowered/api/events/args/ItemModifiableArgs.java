package org.sandboxpowered.api.events.args;

import org.sandboxpowered.api.item.ItemStack;

public interface ItemModifiableArgs extends ItemArgs {
    void setStack(ItemStack stack);
}
