package org.sandboxpowered.api.screen;

import org.sandboxpowered.api.client.Client;
import org.sandboxpowered.api.util.math.MatrixStack;

public interface Screen {
    void init(Client client, int screenWidth, int screenHeight);

    void render(Client client, MatrixStack matrixStack, int mouseX, int mouseY, float partial);

    boolean shouldPauseGame();

    void onClose();

    boolean shouldCloseOnEsc();

    String getNarratorText();
}
