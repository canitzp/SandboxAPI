package com.hrznstudio.sandbox.api.util;

public interface Registry<T extends IRegistryObject<T>> {
    Identity getIdentity(T registryObject);

    T get(Identity identity);
}