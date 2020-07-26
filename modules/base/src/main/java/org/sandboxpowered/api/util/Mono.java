package org.sandboxpowered.api.util;

import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

@SuppressWarnings("unchecked")
public class Mono<T> {
    private static final Mono<?> EMPTY = new Mono<>();
    private final T value;

    private Mono(T value) {
        this.value = Objects.requireNonNull(value);
    }

    private Mono() {
        this.value = null;
    }

    public static <X> Mono<X> empty() {
        return (Mono<X>) EMPTY;
    }

    public static <T> Mono<T> of(@NotNull T value) {
        return new Mono<>(value);
    }

    public static <T> Mono<T> ofNullable(@Nullable T value) {
        return value == null ? empty() : new Mono<>(value);
    }

    public boolean isPresent() {
        return value != null;
    }

    public T get() {
        if (!isPresent())
            throw new NoSuchElementException("No value present");
        return value;
    }

    public Mono<T> filter(Predicate<T> filter) {
        return isPresent() && filter.test(get()) ? this : empty();
    }

    public <X> Mono<X> map(Function<T, X> mapper) {
        if (!isPresent())
            return empty();
        return Mono.of(mapper.apply(get()));
    }

    public <X> Mono<X> flatMap(Function<T, Mono<X>> mapper) {
        if (!isPresent())
            return empty();
        return mapper.apply(get());
    }

    public void ifPresent(Consumer<T> consumer) {
        if (isPresent())
            consumer.accept(get());
    }

    public void ifPresentOrElse(Consumer<T> consumer, Runnable runnable) {
        if (isPresent())
            consumer.accept(get());
        else
            runnable.run();
    }

    public <X> Mono<X> cast() {
        return (Mono<X>) this;
    }

    public T orElseGet(Supplier<T> tSupplier) {
        if (isPresent())
            return get();
        return tSupplier.get();
    }

    public T orElse(T t) {
        if (isPresent())
            return get();
        return t;
    }

    public <E extends Throwable> T orElseThrow(Supplier<E> throwableSupplier) throws E {
        if (isPresent())
            return get();
        throw throwableSupplier.get();
    }
}
