package com.hrznstudio.sandbox.api.item;

public abstract class Item implements IItem {
    private final Settings settings;

    public Item(Settings settings) {
        this.settings = settings;
    }

    @Override
    public Settings getSettings() {
        return settings;
    }
}
