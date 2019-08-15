package com.hrznstudio.sandbox.api.item;

import com.hrznstudio.sandbox.api.util.InteractionResult;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.world.World;

public interface Item {

    InteractionResult onItemUsed(World world, Position position, Stack stack);
}
