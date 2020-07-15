package org.sandboxpowered.api.events.args;

import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.eventhandler.priority.Cancellable;

import java.util.List;

public interface DropsArgs extends Cancellable {
    List<ItemStack> getItems();
}
