package org.sandboxpowered.api.client.rendering.ui;

import org.sandboxpowered.api.util.Identity;

public interface Sprite {
    Identity getTexture();

    Identity getId();

    int getPositionX();

    int getPositionY();

    int getSizeX();

    int getSizeY();

    default boolean hasBorder() {
        return getBorderTop() + getBorderBottom() + getBorderLeft() + getBorderRight() != 0;
    }

    int getBorderTop();

    int getBorderBottom();

    int getBorderLeft();

    int getBorderRight();
}