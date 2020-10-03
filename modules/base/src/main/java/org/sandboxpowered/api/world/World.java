package org.sandboxpowered.api.world;

import org.sandboxpowered.api.util.Side;

public interface World extends WorldReader, WorldWriter {

    Side getSide();

    default boolean isServer() {
        return getSide().isServer();
    }

    default boolean isClient() {
        return getSide().isClient();
    }
}