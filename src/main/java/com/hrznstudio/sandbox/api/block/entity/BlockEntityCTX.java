package com.hrznstudio.sandbox.api.block.entity;

import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.world.World;

public interface BlockEntityCTX {
    World getWorld();

    Position getPosition();
}
