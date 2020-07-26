package org.sandboxpowered.api.content;

import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Identity;

public interface Content<T extends Content<T>> {
    Class<T> getContentType();

    @SuppressWarnings("unchecked")
    default T asContentType() {
        return (T) this;
    }

    default Identity getRegistryIdentity() {
        return Registry.getRegistryFromType(getContentType()).getIdentity();
    }

    default Identity getIdentity() {
        return Registry.getRegistryFromType(getContentType()).getIdentity(asContentType());
    }
}
