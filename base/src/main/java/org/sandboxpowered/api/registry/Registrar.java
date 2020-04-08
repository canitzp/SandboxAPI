package org.sandboxpowered.api.registry;

import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.util.Identity;

public interface Registrar {
    <T extends Content<T>> Registry.Entry<T> getEntry(Identity identity, Class<T> tClass);

    <T extends Content<T>> Registry.Entry<T> getEntry(Identity identity, Registry<T> registry);

    <T extends Content<T>> Registry.Entry<T> register(Identity identity, T content);
}