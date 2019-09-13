package com.hrznstudio.sandbox.api.world;

import com.hrznstudio.sandbox.api.entity.IEntity;
import com.hrznstudio.sandbox.api.util.Side;

import java.util.Collections;
import java.util.List;

public interface World extends WorldReader, WorldWriter {

    Side getSide();

    default boolean isServer() {
        return getSide().isServer();
    }

    default boolean isClient() {
        return getSide().isClient();
    }

    default List<IEntity> getEntities() {
        return Collections.emptyList();
    }
}
