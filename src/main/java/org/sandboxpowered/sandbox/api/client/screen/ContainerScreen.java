package org.sandboxpowered.sandbox.api.client.screen;

import org.sandboxpowered.sandbox.api.container.Container;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.annotation.Alpha;

@Alpha
public abstract class ContainerScreen extends BaseScreen {
    private final Container container;

    public ContainerScreen(Identity identity, Container container) {
        super(identity);
        this.container = container;
    }

    public Container getContainer() {
        return container;
    }

    @Override
    public void init() {

    }

    @Override
    public void draw(int mouseX, int mouseY, float partialTicks) {
    }
}
