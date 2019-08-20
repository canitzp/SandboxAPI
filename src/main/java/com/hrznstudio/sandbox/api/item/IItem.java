package com.hrznstudio.sandbox.api.item;

import com.hrznstudio.sandbox.api.util.InteractionResult;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.world.World;

public interface IItem {
    default InteractionResult onItemUsed(World world, Position position, ItemStack itemStack) {
        return InteractionResult.IGNORE;
    }
}
