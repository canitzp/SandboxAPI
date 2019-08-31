package com.hrznstudio.sandbox.api.block.entity;

import com.hrznstudio.sandbox.api.block.IBlock;
import com.hrznstudio.sandbox.api.util.Functions;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.util.nbt.CompoundTag;
import com.hrznstudio.sandbox.api.util.nbt.ReadableCompoundTag;
import com.hrznstudio.sandbox.api.util.nbt.WritableCompoundTag;
import com.hrznstudio.sandbox.api.world.World;

import java.util.function.Supplier;

public interface IBlockEntity {
    /**
     * The {@link World} the BlockEntity is currently located in
     */
    World getWorld();

    /**
     * The {@link Position} of the BlockEntity
     */
    Position getPosition();

    /**
     * The {@link Type} the BlockEntity belongs too
     */
    Type<?> getType();

    /**
     * Read the {@link CompoundTag} for data belonging to the BlockEntity
     */
    default void read(ReadableCompoundTag tag) {
    }

    /**
     * Write data that needs saving for the BlockEntity to the {@link CompoundTag}
     */
    default void write(WritableCompoundTag tag) {
    }

    /**
     * Marks the BlockEntity for saving to world
     */
    default void save() {
    }

    interface Tickable extends IBlockEntity {
        /**
         * Gets called every game tick and on both sides
         * <p>
         * If interacting this world make sure to check {@code getWorld().isServer()}
         */
        void onTick();
    }

    interface Type<T extends IBlockEntity> {
        static <T extends IBlockEntity> Type<T> of(Supplier<T> entityCreator, IBlock... validBlocks) {
            return (Type<T>) Functions.blockEntityTypeFunction.apply(entityCreator, validBlocks);
        }
    }
}