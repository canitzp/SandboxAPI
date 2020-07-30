package org.sandboxpowered.api.chestui.menu;

import org.sandboxpowered.api.chestui.Menu;
import org.sandboxpowered.api.chestui.slot.Slot;
import org.sandboxpowered.api.entity.player.PlayerEntity;

import java.util.Optional;

public abstract class BaseMenu implements Menu {
    private Menu parent;
    private boolean redraw;
    private Slot[] slots;

    protected String title;

    @Override
    public Optional<Menu> getParent() {
        return Optional.ofNullable(parent);
    }

    @Override
    public Slot getSlot(int index) {
        return slots[index];
    }

    @Override
    public Slot getSlot(int row, int column) {
        int columns = 9;
        return slots[(row * columns) + column];
    }

    @Override
    public boolean isOpen(PlayerEntity player) {
        return false;
    }

    @Override
    public void open(PlayerEntity player) {

    }

    @Override
    public void close(PlayerEntity player) {

    }
}