package org.sandboxpowered.api.resources.v2;

import org.jetbrains.annotations.NotNull;

import java.util.Map;
import java.util.Objects;
import java.util.TreeMap;

public final class Material {
    private static final Map<String, Material> MATERIALS = new TreeMap<>();

    public static Material of(String id) {
        if (!id.toLowerCase().equals(id)) {
            throw new IllegalArgumentException(String.format("Material id must be lowercase got '%s'", id));
        }
        return MATERIALS.computeIfAbsent(id, Material::new);
    }

    private final String id;

    private Material(@NotNull String id) {
        this.id = Objects.requireNonNull(id);
    }

    @Override
    public String toString() {
        return id;
    }

    @Override
    public boolean equals(Object o) {
        return o instanceof Material && id.equals(((Material) o).id);
    }

    @Override
    public int hashCode() {
        return id.hashCode();
    }
}