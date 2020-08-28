package org.sandboxpowered.api.client.rendering.ui;

import org.sandboxpowered.api.util.Identity;

public interface DynamicRenderer {
    void renderBox(int color, int posX, int posY, int sizeX, int sizeY);

    void renderSprite(Identity identity, int posX, int posY, int sizeX, int sizeY);

    void renderSprite(Sprite sprite, int posX, int posY, int sizeX, int sizeY);
}