package org.sandboxpowered.sandbox.api.registry;

import org.sandboxpowered.sandbox.api.content.Content;
import org.sandboxpowered.sandbox.api.util.Identity;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.stream.Stream;

public interface Registry<T extends Content> {
    Identity getIdentity(T val);

    Entry<T> get(Identity identity);

    void register(Identity identity, T val);

    Collection<T> values();

    Stream<T> stream();

    default void forEach(Consumer<T> consumer, Predicate<T> filter) {
        stream().filter(filter).forEach(consumer);
    }

    default void forEach(Consumer<T> consumer) {
        stream().forEach(consumer);
    }

    Collection<Identity> keys();

    Class<T> getType();

    interface Entry<T extends Content> {
        T get();

        Optional<T> asOptional();
    }
}