package org.sandboxpowered.sandbox.api.content;

import org.sandboxpowered.sandbox.api.util.Identity;

public interface Content<T extends Content<T>> {
    Class<T> getContentType();

    default Identity getIdentity() {
        return Registries.getRegistry(getContentType()).getIdentity((T) this);
    }
}
