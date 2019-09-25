package org.sandboxpowered.sandbox.api.event;

import org.sandboxpowered.sandbox.api.state.BlockState;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.world.World;

public class BlockEvent extends Event {
    @Cancellable
    public static class Place extends BlockEvent {
        private final World world;
        private final Position position;
        private BlockState state;

        public Place(World world, Position position, BlockState state) {
            this.world = world;
            this.position = position;
            this.state = state;
        }

        public World getWorld() {
            return world;
        }

        public Position getPosition() {
            return position;
        }

        public BlockState getState() {
            return state;
        }

        public void setState(BlockState state) {
            checkState();
            this.state = state;
        }
    }

    @Cancellable
    public static class Break extends BlockEvent {
        private final World world;
        private final Position position;
        private final BlockState state;

        public Break(World world, Position position, BlockState state) {
            this.world = world;
            this.position = position;
            this.state = state;
        }

        public World getWorld() {
            return world;
        }

        public Position getPosition() {
            return position;
        }

        public BlockState getState() {
            return state;
        }
    }
}
