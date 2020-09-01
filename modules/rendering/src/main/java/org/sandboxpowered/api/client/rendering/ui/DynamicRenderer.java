package org.sandboxpowered.api.client.rendering.ui;

import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.math.MatrixStack;

public interface DynamicRenderer {
    void renderBox(MatrixStack stack, int color, int posX, int posY, int sizeX, int sizeY);

    Sprite getSprite(Identity identity);

    default void renderSprite(MatrixStack stack, Identity identity, int posX, int posY, int sizeX, int sizeY) {
        renderSprite(stack, getSprite(identity), posX, posY, sizeX, sizeY);
    }

    default void renderSliceSprite(MatrixStack stack, Identity identity, int posX, int posY, SliceDirection direction, float percentage) {
        renderSliceSprite(stack, getSprite(identity), posX, posY, direction, percentage);
    }

    void renderSliceSprite(MatrixStack stack, Sprite sprite, int posX, int posY, SliceDirection direction, float percentage);

    default void renderSprite(MatrixStack stack, Identity identity, int posX, int posY) {
        renderSprite(stack, getSprite(identity), posX, posY);
    }

    default void renderSpriteArray(MatrixStack stack, Identity identity, int posX, int posY, int sizeX, int sizeY, int columns, int rows) {
        renderSpriteArray(stack, getSprite(identity), posX, posY, sizeX, sizeY, columns, rows);
    }

    default void renderSpriteArray(MatrixStack stack, Identity identity, int posX, int posY, int columns, int rows) {
        renderSpriteArray(stack, getSprite(identity), posX, posY, columns, rows);
    }

    void renderSprite(MatrixStack stack, Sprite sprite, int posX, int posY, int sizeX, int sizeY);

    default void renderSprite(MatrixStack stack, Sprite sprite, int posX, int posY) {
        renderSprite(stack, sprite, posX, posY, sprite.getSizeX(), sprite.getSizeY());
    }

    void renderSpriteArray(MatrixStack stack, Sprite sprite, int posX, int posY, int sizeX, int sizeY, int columns, int rows);

    default void renderSpriteArray(MatrixStack stack, Sprite sprite, int posX, int posY, int columns, int rows) {
        renderSpriteArray(stack, sprite, posX, posY, sprite.getSizeX(), sprite.getSizeY(), columns, rows);
    }

    enum SliceDirection {
        UP,
        DOWN,
        LEFT,
        RIGHT
    }
}