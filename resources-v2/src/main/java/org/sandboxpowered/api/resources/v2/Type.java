package org.sandboxpowered.api.resources.v2;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public final class Type {
    private static final Map<String, Type> TYPES = new TreeMap<>();

    public static Type of(String id) {
        if (!id.toLowerCase().equals(id)) {
            throw new IllegalArgumentException(String.format("Type id must be lowercase got '%s'", id));
        }
        return TYPES.computeIfAbsent(id, Type::new);
    }
    private final String id;

    public Type(@NotNull String id) {
        this.id = Objects.requireNonNull(id);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Type && id.equals(((Type) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}