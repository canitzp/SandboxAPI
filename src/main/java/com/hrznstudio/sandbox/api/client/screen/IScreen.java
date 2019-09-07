package com.hrznstudio.sandbox.api.client.screen;

import com.hrznstudio.sandbox.api.client.Client;

public interface IScreen {

    void init(Client client, int width, int height);

    void draw(int mouseX, int mouseY, float partialTicks);
}