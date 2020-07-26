package org.sandboxpowered.api.block.entity;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.api.util.nbt.ReadableCompoundTag;
import org.sandboxpowered.api.util.nbt.WritableCompoundTag;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.internal.InternalService;

import java.util.function.Supplier;

public interface BlockEntity {
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

    default <X> Mono<X> getComponent(Component<X> component) {
        return getComponent(component, null);
    }

    <X> Mono<X> getComponent(Component<X> component, @Nullable Direction side);

    interface Tickable extends BlockEntity {
        /**
         * Gets called every game tick and on both sides
         * <p>
         * If interacting this world make sure to check {@code getWorld().isServer()}
         */
        void onTick();
    }

    interface Type<T extends BlockEntity> extends Content<Type<T>> {
        static <T extends BlockEntity> Type<T> of(Supplier<T> entityCreator, Block... validBlocks) {
            return InternalService.getInstance().blockEntityTypeFunction(entityCreator, validBlocks);
        }

        @SuppressWarnings("unchecked")
        static <C> Class<C> getType() {
            return (Class<C>) Type.class;
        }

        @Override
        default Class<Type<T>> getContentType() {
            return getType();
        }
    }
}
