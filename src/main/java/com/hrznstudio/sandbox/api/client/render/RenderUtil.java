package com.hrznstudio.sandbox.api.client.render;

import com.google.common.annotations.Beta;
import com.hrznstudio.sandbox.api.util.Functions;
import com.hrznstudio.sandbox.api.util.Identity;

@Beta
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