package org.sandboxpowered.api.world;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.math.Position;

public interface WorldWriter {
    boolean setBlockState(Position position, BlockState state, BlockFlag... flags);

    default boolean setBlockState(Position position, Registry.Entry<Block> block) {
        return block.isPresent() && setBlockState(position, block.get().getBaseState());
    }

    default boolean setBlockState(Position position, Block block) {
        return setBlockState(position, block.getBaseState());
    }

    default boolean setBlockState(Position position, BlockState state) {
        return setBlockState(position, state, BlockFlag.DEFAULT);
    }

    default boolean breakBlock(Position position, boolean drop) {
        return breakBlock(position, drop, null);
    }

    boolean breakBlock(Position position, boolean drop, @Nullable Entity entity);

    void dropItem(Position position, ItemStack stack);
}