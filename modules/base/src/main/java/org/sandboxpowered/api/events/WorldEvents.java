package org.sandboxpowered.api.events;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.shape.Shape;
import org.sandboxpowered.api.util.math.Vec3d;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.eventhandler.EventHandler;
import org.sandboxpowered.eventhandler.ResettableEventHandler;

import java.util.List;

public final class WorldEvents {
    public static final EventHandler<LightningStrikeEvent> LIGHTNING_STRIKE = new ResettableEventHandler<>();
    public static final EventHandler<AddCollisionBoxes> ADD_COLLISION_BOXES = new ResettableEventHandler<>();

    public interface LightningStrikeEvent {
        void onEvent(World world, Vec3d position, List<Entity> hitEntities);
    }

    public interface AddCollisionBoxes {
        List<Shape> getShapes(Entity collidingEntity, List<Shape> shapes);
    }
}