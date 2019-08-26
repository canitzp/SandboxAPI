package com.hrznstudio.sandbox.api.item;

import com.hrznstudio.sandbox.api.util.InteractionResult;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.util.text.Text;
import com.hrznstudio.sandbox.api.world.World;

import javax.annotation.Nullable;
import java.util.List;

public interface IItem {
    default InteractionResult onItemUsed(World world, Position position, ItemStack itemStack) {
        return InteractionResult.IGNORE;
    }

    default void appendTooltipText(ItemStack cast, @Nullable World world, List<Text> tooltip, boolean advanced) {

    }
}
