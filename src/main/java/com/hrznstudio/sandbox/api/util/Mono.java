package com.hrznstudio.sandbox.api.util;

import javax.annotation.Nonnull;
import javax.annotation.Nullable;
import java.util.NoSuchElementException;
import java.util.Objects;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

public class Mono<T> {
    private static final Mono<?> EMPTY = new Mono<>();
    private final T value;

    public static <X> Mono<X> empty() {
        @SuppressWarnings("unchecked")
        Mono<X> mono = (Mono<X>) EMPTY;
        return mono;
    }

    public static <T> Mono<T> of(@Nonnull T value) {
        return new Mono<>(value);
    }

    public static <T> Mono<T> ofNullable(@Nullable T value) {
        return value == null ? empty() : new Mono<>(value);
    }

    private Mono(T value) {
        this.value = Objects.requireNonNull(value);
    }

    private Mono() {
        this.value = null;
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

    public void ifPresent(Consumer<T> consumer) {
        if (isPresent())
            consumer.accept(get());
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