package org.sandboxpowered.api.state;

import java.util.Collection;
import java.util.Optional;

public interface Property<T extends Comparable<T>> {
    String getName();

    String getName(T value);

    Collection<T> getValues();

    Class<T> getValueType();

    Optional<T> getValue(String name);
}