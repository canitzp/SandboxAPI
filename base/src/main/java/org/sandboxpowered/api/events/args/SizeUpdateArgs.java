package org.sandboxpowered.api.events.args;

import org.sandboxpowered.api.entity.EntitySize;
import org.sandboxpowered.eventhandler.priority.Cancellable;

public interface SizeUpdateArgs extends Cancellable {
    EntitySize getSize();
    void setSize(EntitySize size);
}
