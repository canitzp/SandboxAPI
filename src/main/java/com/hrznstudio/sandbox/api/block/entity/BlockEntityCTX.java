package com.hrznstudio.sandbox.api.block.entity;

import com.google.common.annotations.Beta;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.world.World;

@Beta
public interface BlockEntityCTX {
    World getWorld();

    Position getPosition();

    void save();
}
