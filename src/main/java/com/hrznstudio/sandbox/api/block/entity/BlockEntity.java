package com.hrznstudio.sandbox.api.block.entity;

import com.hrznstudio.sandbox.api.block.Block;
import com.hrznstudio.sandbox.api.util.Functions;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.world.World;

import java.util.Set;
import java.util.function.Supplier;

public interface BlockEntity {

    World getWorld();

    Position getPosition();

    Type<?> getType();

    interface Tickable extends BlockEntity {
        void onTick();
    }

    interface Type<T extends BlockEntity> {

        static <T extends BlockEntity> Type<T> of(Supplier<T> entityCreator, Block... validBlocks) {
            return (Type<T>) Functions.blockEntityTypeFunction.apply(entityCreator, validBlocks);
        }

        Supplier<T> getEntityCreator();

        Set<Block> getValidBlocks();
    }
}