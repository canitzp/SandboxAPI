package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.block.entity.IBlockEntity;
import com.hrznstudio.sandbox.api.block.state.BlockState;
import com.hrznstudio.sandbox.api.block.state.StateFactory;
import com.hrznstudio.sandbox.api.entity.Entity;
import com.hrznstudio.sandbox.api.entity.player.Hand;
import com.hrznstudio.sandbox.api.entity.player.Player;
import com.hrznstudio.sandbox.api.item.IItem;
import com.hrznstudio.sandbox.api.item.ItemProvider;
import com.hrznstudio.sandbox.api.item.ItemStack;
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
    IItem asItem();

    @Nonnull
    default InteractionResult onBlockUsed(World world, Position pos, BlockState state, Player player, Hand hand, Direction side, Vec3f hit) {
        return InteractionResult.IGNORE;
    }

    @Nonnull
    default InteractionResult onBlockClicked(World world, Position pos, BlockState state, Entity player, Direction side) {
        return InteractionResult.IGNORE;
    }

    BlockState getBaseState();

    StateFactory<IBlock, BlockState> getStateFactory();

    default void onBlockPlaced(World world, Position position, BlockState state, Entity entity, ItemStack itemStack) {
    }

    default void onBlockDestroyed(World world, Position position, BlockState state) {
    }

    default BlockState updateOnNeighborChanged(BlockState state, Direction direction, BlockState otherState, World world, Position position, Position otherPosition) {
        return state;
    }

    default boolean hasBlockEntity() {
        return false;
    }

    default IBlockEntity createBlockEntity(WorldReader reader) {
        return null;
    }

    default boolean isAir(BlockState state) {
        return false;
    }

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