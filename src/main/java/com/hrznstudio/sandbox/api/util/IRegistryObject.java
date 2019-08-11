package com.hrznstudio.sandbox.api.util;

public interface IRegistryObject<T extends IRegistryObject<T>> {
    default Identity getIdentity() {
        return getRegistry().getIdentity((T) this);
    }

    Registry<T> getRegistry();
}