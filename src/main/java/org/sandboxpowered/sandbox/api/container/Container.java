package org.sandboxpowered.sandbox.api.container;

import org.sandboxpowered.sandbox.api.util.annotation.Alpha;

import java.util.Collection;

@Alpha
public interface Container {
    Collection<Slot> getSlots();
}