package org.sandboxpowered.sandbox.api.content;

import org.sandboxpowered.sandbox.api.registry.Registry;
import org.sandboxpowered.sandbox.api.util.Identity;

public interface Content<T extends Content<T>> {
    Class<T> getContentType();

    default Identity getIdentity() {
        return Registry.getRegistryFromType(getContentType()).getIdentity((T) this);
    }
}
