package org.sandboxpowered.api.item;

public class BaseItem implements Item {
    private final Settings settings;

    public BaseItem(Settings settings) {
        this.settings = settings;
    }

    @Override
    public Settings getSettings() {
        return settings;
    }

}
