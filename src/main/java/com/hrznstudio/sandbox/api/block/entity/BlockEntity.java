package com.hrznstudio.sandbox.api.block.entity;

import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.world.World;

public interface BlockEntity {

    World getWorld();

    Position getPosition();

    interface Tickable extends BlockEntity {
        void onTick();
    }
}
