package org.sandboxpowered.api.addon;

/**
 * Defines the side to load an addon on. Refers to physical client/server, not logical client/server.
 */
public enum LoadingSide {
    /**
     * The loading side for a physical dedicated server.
     */
    SERVER,
    /**
     * The loading side for a physical client.
     */
    CLIENT,
    /**
     * Both server and client.
     */
    COMMON;

    public boolean isClient() {
        return this != SERVER;
    }

    public boolean isServer() {
        return this != CLIENT;
    }
}
