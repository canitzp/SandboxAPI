package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.block.entity.BlockEntity;
import com.hrznstudio.sandbox.api.block.state.BlockState;
import com.hrznstudio.sandbox.api.entity.Entity;
import com.hrznstudio.sandbox.api.entity.player.Hand;
import com.hrznstudio.sandbox.api.entity.player.Player;
import com.hrznstudio.sandbox.api.item.Item;
import com.hrznstudio.sandbox.api.item.ItemProvider;
import com.hrznstudio.sandbox.api.item.Stack;
import com.hrznstudio.sandbox.api.util.InteractionResult;
import com.hrznstudio.sandbox.api.util.Direction;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.util.math.Vec3f;
import com.hrznstudio.sandbox.api.world.World;
import com.hrznstudio.sandbox.api.world.WorldReader;

public interface Block extends ItemProvider {

    Properties createProperties();

    @Override
    default Item asItem() {
        return null;
    }

    default InteractionResult onBlockUsed(World world, Position pos, BlockState state, Player player, Hand hand, Direction side, Vec3f hit) {
        return InteractionResult.IGNORE;
    }

    default InteractionResult onBlockClicked(World world, Position pos, BlockState state, Entity player, Direction side) {
        return InteractionResult.IGNORE;
    }

    default void onBlockPlaced(World world, Position position, BlockState state, Entity entity, Stack stack) {
    }

    default void onBlockDestroyed(World world, Position position, BlockState state) {

    }

    default boolean hasBlockEntity() {
        return false;
    }

    default BlockEntity createBlockEntity(WorldReader reader) {
        return null;
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