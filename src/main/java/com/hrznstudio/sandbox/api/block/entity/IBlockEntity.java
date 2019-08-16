package com.hrznstudio.sandbox.api.block.entity;

import com.hrznstudio.sandbox.api.block.IBlock;
import com.hrznstudio.sandbox.api.util.Functions;
import com.hrznstudio.sandbox.api.util.math.Position;
import com.hrznstudio.sandbox.api.world.World;

import java.util.function.Supplier;

public interface IBlockEntity {
    World getWorld();

    Position getPosition();

    Type<?> getType();

    interface Tickable extends IBlockEntity {
        void onTick();
    }

    interface Type<T extends IBlockEntity> {
        static <T extends IBlockEntity> Type<T> of(Supplier<T> entityCreator, IBlock... validBlocks) {
            return (Type<T>) Functions.blockEntityTypeFunction.apply(entityCreator, validBlocks);
        }
    }
}