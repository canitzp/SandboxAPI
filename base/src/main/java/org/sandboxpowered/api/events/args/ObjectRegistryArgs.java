package org.sandboxpowered.api.events.args;

import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.eventhandler.priority.Cancellable;

public interface ObjectRegistryArgs extends Cancellable {
    Identity getIdentity();
    Content<?> getObject();
}
