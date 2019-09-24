package com.hrznstudio.sandbox.api.client.screen;

import com.google.common.annotations.Beta;
import com.hrznstudio.sandbox.api.client.Client;
import com.hrznstudio.sandbox.api.util.Identity;
import com.hrznstudio.sandbox.api.util.text.Text;

@Beta
public abstract class Screen implements IScreen {
    private final Text title;
    private final Identity identity;
    private Client client;
    private int width, height;

    public Screen(Identity identity) {
        this.identity = identity;
        this.title = Text.translatable(String.format("screen.%s.%s", identity.getNamespace(), identity.getPath()));
    }

    @Override
    public Identity getScreenId() {
        return identity;
    }

    @Override
    public final void init(Client client, int width, int height) {
        this.client = client;
        this.width = width;
        this.height = height;
        init();
    }

    public abstract void init();

    public Client getClient() {
        return client;
    }

    public int getWidth() {
        return width;
    }

    public int getHeight() {
        return height;
    }

    public Text getTitle() {
        return title;
    }
}