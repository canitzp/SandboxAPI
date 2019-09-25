package org.sandboxpowered.sandbox.api.state;

public interface StateFactory<T, S extends PropertyContainer<S>> {
    S getBaseState();

    T getBaseObject();

    interface Builder<T, S extends PropertyContainer<S>> {
        StateFactory.Builder<T, S> add(Property<?>... properties);
    }
}