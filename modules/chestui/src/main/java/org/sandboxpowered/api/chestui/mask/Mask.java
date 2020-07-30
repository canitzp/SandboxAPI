package org.sandboxpowered.api.chestui.mask;

import org.sandboxpowered.api.chestui.Menu;

public interface Mask {
    boolean contains(int index);

    boolean contains(int row, int column);

    void apply(Menu menu);
}