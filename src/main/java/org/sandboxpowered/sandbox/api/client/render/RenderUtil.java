package org.sandboxpowered.sandbox.api.client.render;

import org.sandboxpowered.sandbox.api.util.Functions;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.annotation.Alpha;

@Alpha
public interface RenderUtil {
    static RenderUtil instance() {
        return Functions.renderUtil.get();
    }

    default void draw(int x, int y, float u, float v, int width, int height) {
        draw(x, y, u, v, width, height, 256, 256);
    }

    void draw(int x, int y, float u, float v, int width, int height, int texWidth, int texHeight);

    default void drawRepeating(int x, int y, int u, int v, int width, int height, float repeatWidth, float repeatHeight) {
        drawRepeating(x, y, u, v, width, height, repeatWidth, repeatHeight, 256, 256);
    }

    void drawRepeating(int x, int y, int u, int v, int width, int height, float repeatWidth, float repeatHeight, int texWidth, int texHeight);

    void bind(Identity texture);

}