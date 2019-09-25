package org.sandboxpowered.sandbox.api.client.screen;

import com.google.common.annotations.Beta;
import org.sandboxpowered.sandbox.api.client.Client;
import org.sandboxpowered.sandbox.api.util.Identity;

@Beta
public interface Screen {

    Identity getId();

    void init(Client client, int width, int height);

    void draw(int mouseX, int mouseY, float partialTicks);
}