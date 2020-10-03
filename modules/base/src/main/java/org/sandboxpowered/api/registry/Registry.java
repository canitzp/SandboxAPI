package org.sandboxpowered.api.registry;

import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.internal.InternalService;

import java.util.Collection;
import java.util.Optional;
import java.util.function.Consumer;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.stream.Stream;

public interface Registry<T extends Content<T>> {
    static <T extends Content<T>> Registry<T> getRegistryFromType(Class<T> tClass) {
        return InternalService.getInstance().registryFunction(tClass);
    }

    Identity getIdentity(T val);

    Entry<T> get(Identity identity);

    Entry<T> register(Identity identity, T val);

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

    Identity getIdentity();

    interface Entry<T extends Content<T>> extends Supplier<T>, Predicate<T> {
        @Override
        T get();

        Optional<T> getAsOptional();

        T orElse(T other);

        T orElseGet(Supplier<T> other);

        boolean isPresent();

        @Override
        default boolean test(T t) {
            return matches(t);
        }

        boolean matches(T other);

        void ifPresent(Consumer<T> tConsumer);

        void ifPresentOrElse(Consumer<T> tConsumer, Runnable notPresent);
    }
}
