package com.hrznstudio.sandbox.api.block.state;

public interface StateFactory<T, S extends PropertyContainer<S>> {
    S getBaseState();
    T getBaseObject();
}
