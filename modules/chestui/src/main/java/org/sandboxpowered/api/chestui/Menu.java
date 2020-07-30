package org.sandboxpowered.api.chestui;

import org.sandboxpowered.api.chestui.slot.Slot;
import org.sandboxpowered.api.entity.player.PlayerEntity;

import java.util.Optional;

public interface Menu {
    Optional<Menu> getParent();

    Slot getSlot(int index);

    Slot getSlot(int row, int column);

    boolean isOpen(PlayerEntity player);

    void open(PlayerEntity player);

    void close(PlayerEntity player);
}