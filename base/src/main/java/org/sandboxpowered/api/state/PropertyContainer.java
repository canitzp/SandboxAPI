package org.sandboxpowered.api.state;

public interface PropertyContainer<C> {

    <T extends Comparable<T>> T get(Property<T> property);

    <T extends Comparable<T>, V extends T> C with(Property<T> property, V value);

    <T extends Comparable<T>> boolean contains(Property<T> property);

}