package com.hrznstudio.sandbox.api.client.screen;

import com.hrznstudio.sandbox.api.container.IContainer;
import com.hrznstudio.sandbox.api.util.Identity;

public abstract class ContainerScreen extends Screen {
    private final IContainer container;

    public ContainerScreen(Identity identity, IContainer container) {
        super(identity);
        this.container = container;
    }

    public IContainer getContainer() {
        return container;
    }

    @Override
    public void init() {

    }

    @Override
    public void draw(int mouseX, int mouseY, float partialTicks) {
    }
}
