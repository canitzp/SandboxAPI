package com.hrznstudio.sandbox.api.container;

import java.util.Collection;
import java.util.LinkedList;
import java.util.List;

public class Container implements IContainer {
    private List<ISlot> slots = new LinkedList<>();

    public void addSlot(ISlot slot) {
        slots.add(slot);
    }

    @Override
    public Collection<ISlot> getSlots() {
        return slots;
    }
}
