package org.sandboxpowered.api.events;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.shape.Shape;
import org.sandboxpowered.api.util.math.Vec3d;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.eventhandler.EventHandler;
import org.sandboxpowered.internal.InternalService;

import java.util.List;

public final class WorldEvents {
    public static final EventHandler<LightningStrikeEvent> LIGHTNING_STRIKE = InternalService.getInstance().createEventHandler();
    public static final EventHandler<AddCollisionBoxes> ADD_COLLISION_BOXES = InternalService.getInstance().createEventHandler();

    public interface LightningStrikeEvent {
        void onEvent(World world, Vec3d position, List<Entity> hitEntities);
    }

    public interface AddCollisionBoxes {
        List<Shape> getShapes(Entity collidingEntity, List<Shape> shapes);
    }
}