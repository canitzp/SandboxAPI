package org.sandboxpowered.sandbox.api.util;

public interface Identity {

    static Identity of(String namespace, String path) {
        return Functions.identityFunction.apply(namespace + ":" + path);
    }

    String getNamespace();

    String getPath();
}