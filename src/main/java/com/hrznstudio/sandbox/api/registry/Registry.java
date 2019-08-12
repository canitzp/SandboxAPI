package com.hrznstudio.sandbox.api.registry;

import com.hrznstudio.sandbox.api.util.Identity;

import java.util.Collection;

public interface Registry<T> {
    Identity getIdentity(T val);

    T get(Identity identity);

    void register(Identity identity, T val);

    Collection<T> values();

    Collection<Identity> keys();

    Class<T> getType();
}