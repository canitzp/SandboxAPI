package com.hrznstudio.sandbox.api.event;

import com.hrznstudio.sandbox.api.registry.Registry;

public class RegistryEvent<T> extends GenericEvent<T> {
    private final Registry<T> registry;

    public RegistryEvent(Registry<T> registry) {
        super(registry.getType());
        this.registry = registry;
    }

    public Registry<T> getRegistry() {
        return registry;
    }
}