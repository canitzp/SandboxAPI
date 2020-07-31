package org.sandboxpowered.api.world;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.block.multipart.Slot;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.math.Position;

public interface WorldWriter {
    boolean setBlockState(Position position, Slot slot, BlockState state, BlockFlag... flags);

    default boolean setBlockState(Position position, Slot slot, Registry.Entry<Block> block) {
        return block.isPresent() && setBlockState(position, slot, block.get().getBaseState());
    }

    default boolean setBlockState(Position position, BlockState state, BlockFlag... flags) {
        return setBlockState(position, Slot.BLOCK, state, flags);
    }

    default boolean setBlockState(Position position, Registry.Entry<Block> block) {
        return setBlockState(position, Slot.BLOCK, block);
    }

    default boolean setBlockState(Position position, Slot slot, Block block) {
        return setBlockState(position, slot, block, BlockFlag.DEFAULT);
    }

    default boolean setBlockState(Position position, Slot slot, Block block, BlockFlag... flags) {
        return setBlockState(position, slot, block.getBaseState(), flags);
    }

    default boolean setBlockState(Position position, Slot slot, BlockState state) {
        return setBlockState(position, slot, state, BlockFlag.DEFAULT);
    }

    default boolean breakBlock(Position position, boolean drop) {
        return breakBlock(position, drop, null);
    }

    boolean breakBlock(Position position, boolean drop, @Nullable Entity entity);

    void dropItem(Position position, ItemStack stack);
}