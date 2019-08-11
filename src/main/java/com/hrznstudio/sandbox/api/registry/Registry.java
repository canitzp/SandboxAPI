package com.hrznstudio.sandbox.api.registry;

import com.hrznstudio.sandbox.api.util.Identity;

public interface Registry<T> {
    Identity getIdentity(T registryObject);

    T get(Identity identity);
}