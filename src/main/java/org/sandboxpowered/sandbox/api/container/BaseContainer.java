package org.sandboxpowered.sandbox.api.container;

import org.sandboxpowered.sandbox.api.util.annotation.Alpha;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

@Alpha
public class BaseContainer implements Container {
    private List<Slot> slots = new LinkedList<>();

    public void addSlot(Slot slot) {
        slots.add(slot);
    }

    @Override
    public Collection<Slot> getSlots() {
        return slots;
    }
}
