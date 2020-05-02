package org.sandboxpowered.api.registry;

import org.sandboxpowered.api.addon.AddonInfo;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.util.Identity;

import java.util.Optional;

public interface Registrar {
    AddonInfo getSourceAddon();

    <T extends Content<T>> Registry.Entry<T> getEntry(Identity identity, Class<T> tClass);

    <T extends Content<T>> Registry.Entry<T> getEntry(Identity identity, Registry<T> registry);

    <T extends Content<T>> Registry.Entry<T> register(Identity identity, T content);

    default <T extends Content<T>> Registry.Entry<T> register(String name, T content) {
        return register(Identity.of(getSourceAddon().getId(), name), content);
    }

    <T extends Service> Optional<T> getRegistrarService(Class<T> tClass);

    interface Service {
    }
}
