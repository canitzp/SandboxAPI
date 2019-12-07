package org.sandboxpowered.sandbox.api.util;

public interface Identity {

    static Identity of(String namespace, String path) {
        return Functions.getInstance().createIdentityFromString(namespace, path);
    }

    String getNamespace();

    String getPath();
}