package org.sandboxpowered.api.client.rendering.ui;

import org.sandboxpowered.api.util.math.MatrixStack;
import org.sandboxpowered.api.util.text.Text;

public interface TextRenderer {
    void renderText(MatrixStack stack, Text text, Alignment alignment, int posX, int posY, int color);

    default void renderText(MatrixStack stack, Text text, int posX, int posY, int color) {
        renderText(stack, text, Alignment.LEFT, posX, posY, color);
    }

    public enum Alignment {
        LEFT,
        CENTER,
        RIGHT;
    }
}
