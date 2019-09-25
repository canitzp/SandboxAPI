package org.sandboxpowered.sandbox.api.container;

import com.google.common.annotations.Beta;

import java.util.Collection;

@Beta
public interface Container {
    Collection<Slot> getSlots();
}