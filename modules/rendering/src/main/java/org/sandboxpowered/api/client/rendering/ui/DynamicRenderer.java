package org.sandboxpowered.api.client.rendering.ui;

import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.math.MatrixStack;

public interface DynamicRenderer {
    void renderBox(MatrixStack stack, int color, int posX, int posY, int sizeX, int sizeY);

    void renderSprite(MatrixStack stack, Identity identity, int posX, int posY, int sizeX, int sizeY);

    void renderSprite(MatrixStack stack, Sprite sprite, int posX, int posY, int sizeX, int sizeY);
}