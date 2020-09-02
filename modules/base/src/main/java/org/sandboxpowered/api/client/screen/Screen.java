package org.sandboxpowered.api.client.screen;

import org.sandboxpowered.api.client.Client;
import org.sandboxpowered.api.util.math.MatrixStack;
import org.sandboxpowered.api.util.text.Text;

public interface Screen {
    void init(Client client, int screenWidth, int screenHeight);

    void render(Client client, MatrixStack matrixStack, int mouseX, int mouseY, float delta);

    default boolean shouldPauseGame() {
        return true;
    }

    default void onClose() {

    }

    default boolean shouldCloseOnEsc() {
        return true;
    }

    Text getTitle();

    default Text getNarratorText() {
        return getTitle();
    }
}
