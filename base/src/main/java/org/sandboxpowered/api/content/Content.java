package org.sandboxpowered.api.content;

import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Identity;

public interface Content<T extends Content<T>> {
    Class<T> getContentType();

    default Identity getRegistryIdentity() {
        return Registry.getRegistryFromType(getContentType()).getIdentity();
    }

    @SuppressWarnings("unchecked")
    default Identity getIdentity() {
        return Registry.getRegistryFromType(getContentType()).getIdentity((T) this);
    }
}
