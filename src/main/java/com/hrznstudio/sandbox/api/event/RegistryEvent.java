package com.hrznstudio.sandbox.api.event;

import com.hrznstudio.sandbox.api.block.Block;
import com.hrznstudio.sandbox.api.item.Item;
import com.hrznstudio.sandbox.api.registry.Registry;

public class RegistryEvent<T> extends Event {
    private final Registry<T> registry;

    public RegistryEvent(Registry<T> registry) {
        this.registry = registry;
    }

    public Registry<T> getRegistry() {
        return registry;
    }

    public Class<T> getRegistryType() {
        return getRegistry().getType();
    }

    public static class Blocks extends RegistryEvent<Block> {
        public Blocks(Registry<Block> registry) {
            super(registry);
        }
    }

    public static class Items extends RegistryEvent<Item> {
        public Items(Registry<Item> registry) {
            super(registry);
        }
    }
}