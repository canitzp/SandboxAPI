package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.block.entity.IBlockEntity;
import com.hrznstudio.sandbox.api.block.state.BlockState;
import com.hrznstudio.sandbox.api.entity.Entity;
import com.hrznstudio.sandbox.api.entity.player.Hand;
import com.hrznstudio.sandbox.api.entity.player.Player;
import com.hrznstudio.sandbox.api.item.Item;
import com.hrznstudio.sandbox.api.item.ItemProvider;
import com.hrznstudio.sandbox.api.item.Stack;
import com.hrznstudio.sandbox.api.util.Direction;
import com.hrznstudio.sandbox.api.util.InteractionResult;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.util.math.Vec3f;
import com.hrznstudio.sandbox.api.world.World;
import com.hrznstudio.sandbox.api.world.WorldReader;

import javax.annotation.Nonnull;

public interface IBlock extends ItemProvider {

    Properties createProperties();

    @Override
    Item asItem();

    @Nonnull
    InteractionResult onBlockUsed(World world, Position pos, BlockState state, Player player, Hand hand, Direction side, Vec3f hit);

    @Nonnull
    InteractionResult onBlockClicked(World world, Position pos, BlockState state, Entity player, Direction side);

    BlockState getBaseState();

    default void onBlockPlaced(World world, Position position, BlockState state, Entity entity, Stack stack) {
    }

    void onBlockDestroyed(World world, Position position, BlockState state);

    boolean hasBlockEntity();

    IBlockEntity createBlockEntity(WorldReader reader);

    boolean isAir(BlockState state);

    class Properties {
        private final Material material;

        public Properties(Material material) {
            this.material = material;
        }

        public Material getMaterial() {
            return material;
        }
    }
}