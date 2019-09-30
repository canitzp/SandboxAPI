package org.sandboxpowered.sandbox.api.client.screen;

import org.sandboxpowered.sandbox.api.client.render.RenderUtil;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.annotation.PreAlpha;

@PreAlpha
public abstract class DynamicScreen extends BaseScreen {
    public static final Identity BACKGROUND_LOCATION = Identity.of("sandbox", "textures/gui/sheet.png");
    private int containerWidth, containerHeight;

    public DynamicScreen(Identity identity) {
        super(identity);
    }

    @Override
    public void init() {

    }

    @Override
    public void draw(int mouseX, int mouseY, float partialTicks) {
        RenderUtil render = RenderUtil.instance();
        render.bind(BACKGROUND_LOCATION);

        containerHeight = 136;
        containerWidth = 195;

        int x = (getWidth() / 2) - (containerWidth / 2);
        int y = (getHeight() / 2) - (containerHeight / 2);

        drawBackground();

        for (int hX = 0; hX < 9; hX++) {
            for (int hY = 0; hY < 3; hY++) {
                drawSlot(x + (hX * 22), y + (hY * 22), 20, 20);
            }
        }
    }

    public void drawSlot(int x, int y, int width, int height) {
        RenderUtil render = RenderUtil.instance();
        render.draw(x, y, 9, 0, 1, 1);
        render.draw(x + width - 1, y, 11, 0, 1, 1);
        render.draw(x, y + height - 1, 9, 2, 1, 1);
        render.draw(x + width - 1, y + height - 1, 11, 2, 1, 1);
        render.drawRepeating(x + 1, y + 1, 10, 1, width - 2, height - 2, 1, 1);
        render.drawRepeating(x, y + 1, 9, 1, 1, height - 2, 1, 1);
        render.drawRepeating(x + 1, y, 10, 0, width - 2, 1, 1, 1);
        render.drawRepeating(x + width - 1, y + 1, 11, 1, 1, height - 2, 1, 1);
        render.drawRepeating(x + 1, y + height - 1, 10, 2, width - 2, 1, 1, 1);
    }

    public void drawBackground() {
        int x = (getWidth() / 2) - (containerWidth / 2);
        int y = (getHeight() / 2) - (containerHeight / 2);

        RenderUtil render = RenderUtil.instance();
        render.drawRepeating(x + 4, y + 4, 4, 4, containerWidth - 8, containerHeight - 8, 1, 1);
        render.drawRepeating(x + 4, y, 4, 0, containerWidth - 8, 4, 1, 4);
        render.drawRepeating(x + 4, y + containerHeight - 4, 4, 5, containerWidth - 8, 4, 1, 4);
        render.drawRepeating(x, y + 4, 0, 4, 4, containerHeight - 8, 4, 1);
        render.drawRepeating(x + containerWidth - 4, y + 4, 5, 4, 4, containerHeight - 8, 4, 1);
        render.draw(x, y, 0, 0, 4, 4);
        render.draw(x + containerWidth - 4, y, 5, 0, 4, 4);
        render.draw(x, y + containerHeight - 4, 0, 5, 4, 4);
        render.draw(x + containerWidth - 4, y + containerHeight - 4, 5, 5, 4, 4);
    }
}