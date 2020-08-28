package org.sandboxpowered.api.client.rendering.ui;

import org.sandboxpowered.api.util.text.Text;

public interface TextRenderer {
    void renderText(Text text, int posX, int posY, int color);
}
