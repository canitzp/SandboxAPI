package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.Registries;
import com.hrznstudio.sandbox.api.block.entity.IBlockEntity;
import com.hrznstudio.sandbox.api.block.state.BlockState;
import com.hrznstudio.sandbox.api.entity.Entity;
import com.hrznstudio.sandbox.api.entity.player.Hand;
import com.hrznstudio.sandbox.api.entity.player.Player;
import com.hrznstudio.sandbox.api.item.Item;
import com.hrznstudio.sandbox.api.util.Direction;
import com.hrznstudio.sandbox.api.util.InteractionResult;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.util.math.Vec3f;
import com.hrznstudio.sandbox.api.world.World;
import com.hrznstudio.sandbox.api.world.WorldReader;

import javax.annotation.Nonnull;

public abstract class Block implements IBlock {

    Object wrapped;

    public Object getWrapped() {
        return wrapped;
    }

    public void setWrapped(Object wrapped) {
        this.wrapped = wrapped;
    }

    @Override
    public Item asItem() {
        return Registries.ITEM.get(Registries.BLOCK.getIdentity(this));
    }

    @Nonnull
    @Override
    public InteractionResult onBlockUsed(World world, Position pos, BlockState state, Player player, Hand hand, Direction side, Vec3f hit) {
        return InteractionResult.IGNORE;
    }

    @Nonnull
    @Override
    public InteractionResult onBlockClicked(World world, Position pos, BlockState state, Entity player, Direction side) {
        return InteractionResult.IGNORE;
    }

    @Override
    public BlockState getBaseState() {
        return null;
    }

    @Override
    public void onBlockDestroyed(World world, Position position, BlockState state) {

    }

    @Override
    public boolean hasBlockEntity() {
        return false;
    }

    @Override
    public IBlockEntity createBlockEntity(WorldReader reader) {
        return null;
    }
}