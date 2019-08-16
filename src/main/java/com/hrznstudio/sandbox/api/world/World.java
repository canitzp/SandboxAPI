package com.hrznstudio.sandbox.api.world;

import com.hrznstudio.sandbox.api.util.Side;

public interface World extends WorldReader, WorldWriter {

    Side getSide();

    default boolean isServer() {
        return getSide().isServer();
    }

    default boolean isClient() {
        return getSide().isClient();
    }
}
