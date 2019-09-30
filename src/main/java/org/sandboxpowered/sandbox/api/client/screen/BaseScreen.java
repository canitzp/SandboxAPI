package org.sandboxpowered.sandbox.api.client.screen;

import org.sandboxpowered.sandbox.api.client.Client;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.annotation.Alpha;
import org.sandboxpowered.sandbox.api.util.text.Text;

@Alpha
public abstract class BaseScreen implements Screen {
    private final Text title;
    private final Identity identity;
    private Client client;
    private int width, height;

    public BaseScreen(Identity identity) {
        this.identity = identity;
        this.title = Text.translatable(String.format("screen.%s.%s", identity.getNamespace(), identity.getPath()));
    }

    @Override
    public Identity getId() {
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