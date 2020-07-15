package org.sandboxpowered.api.events.args;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.eventhandler.priority.Cancellable;

public interface EntityArgs<T extends Entity> extends Cancellable {
    T getEntity();
}
