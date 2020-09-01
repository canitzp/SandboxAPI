package org.sandboxpowered.api.client.screen;

import org.sandboxpowered.api.client.Client;
import org.sandboxpowered.api.util.math.MatrixStack;

public interface Screen {
    void init(Client client, int screenWidth, int screenHeight);

    void render(Client client, MatrixStack matrixStack, int mouseX, int mouseY, float partial);

    default boolean shouldPauseGame() {
        return true;
    }

    default void onClose() {

    }

    default boolean shouldCloseOnEsc() {
        return true;
    }

    String getNarratorText();
}
