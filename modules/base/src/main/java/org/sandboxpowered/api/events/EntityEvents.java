package org.sandboxpowered.api.events;

import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.eventhandler.EventHandler;
import org.sandboxpowered.eventhandler.ResettableEventHandler;

public class EntityEvents {
    public static final EventHandler<EntityEvent.Cancellable> SPAWN = new ResettableEventHandler<>();

    public interface EntityEvent {
        void onEvent(Entity entity);

        interface Cancellable {
            void onEvent(Entity entity, org.sandboxpowered.eventhandler.Cancellable cancellable);
        }
    }
}