package org.sandboxpowered.api.util;

import org.sandboxpowered.internal.InternalService;

public interface Identity {
    static Identity of(String namespace, String path) {
        return InternalService.getInstance().createIdentityFromString(namespace, path);
    }

    static Identity of(String identity) {
        return InternalService.getInstance().createIdentityFromString(identity);
    }

    String getNamespace();

    String getPath();

    interface Variant extends Identity {
        static Variant of(Identity identity, String variant) {
            return InternalService.getInstance().createVariantIdentity(identity, variant);
        }

        static Variant of(String identity, String variant) {
            return InternalService.getInstance().createVariantIdentity(Identity.of(identity), variant);
        }

        static Variant of(String namespace, String path, String variant) {
            return InternalService.getInstance().createVariantIdentity(Identity.of(namespace, path), variant);
        }

        String getVariant();
    }
}