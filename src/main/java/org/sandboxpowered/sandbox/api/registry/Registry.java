package org.sandboxpowered.sandbox.api.registry;

import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.util.Identity;
import org.sandboxpowered.sandbox.api.util.Mono;

import java.util.Collection;

public interface Registry<T extends Content> {
    Identity getIdentity(T val);

    Mono<T> get(Identity identity);

    void register(Identity identity, T val);

    Collection<T> values();

    Collection<Identity> keys();

    Class<T> getType();
}