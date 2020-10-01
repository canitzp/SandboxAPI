package org.sandboxpowered.api.events;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.eventhandler.EventHandler;
import org.sandboxpowered.internal.InternalService;

import java.util.List;

public final class EntityEvents {
    public static final EventHandler<SpawnEvent> SPAWN = InternalService.getInstance().createEventHandler();
    public static final EventHandler<AnvilFallEvent> ANVIL_FALL = InternalService.getInstance().createEventHandler();

    public interface AnvilFallEvent {
        void onEvent(World world, Position pos, BlockState fallingState, BlockState hitState, Entity entity, List<Entity> hitEntities);
    }

    interface SpawnEvent {
        boolean onEvent(Entity entity);
    }
}