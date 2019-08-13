package com.hrznstudio.sandbox.api.block;

import com.hrznstudio.sandbox.api.block.state.BlockState;
import com.hrznstudio.sandbox.api.entity.Entity;
import com.hrznstudio.sandbox.api.entity.player.Hand;
import com.hrznstudio.sandbox.api.util.Activation;
import com.hrznstudio.sandbox.api.util.Direction;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.util.math.Vec3f;
import com.hrznstudio.sandbox.api.world.World;

public interface Block {

    Properties createProperties();

    default Activation onBlockUsed(World world, Position pos, BlockState state, Entity player, Hand hand, Direction side, Vec3f hit) {
        return Activation.IGNORE;
    }

    default Activation onBlockClicked(World world, Position pos, BlockState state, Entity player, Direction side) {
        return Activation.IGNORE;
    }

    default void onBlockPlaced(World world, Position position, BlockState state) {
    }

    default void onBlockDestroyed(World world, Position position, BlockState state) {

    }

    class Properties {
        private final Material material;

        public Properties(Material material) {
            this.material = material;
        }
    }
}