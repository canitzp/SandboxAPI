package org.sandboxpowered.api.events.args;

import org.sandboxpowered.eventhandler.priority.Cancellable;

public interface HealthArgs extends Cancellable {
    float getAmount();
    void setAmount(float amount);
}
