package org.sandboxpowered.api.addon;

public enum LoadingSide {
    SERVER,
    CLIENT,
    COMMON;

    public boolean isClient() {
        return this != SERVER;
    }

    public boolean isServer() {
        return this != CLIENT;
    }
}
