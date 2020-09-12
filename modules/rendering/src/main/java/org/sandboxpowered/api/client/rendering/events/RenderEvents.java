package org.sandboxpowered.api.client.rendering.events;

import org.sandboxpowered.api.client.rendering.VertexConsumer;
import org.sandboxpowered.api.util.math.MatrixStack;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.eventhandler.EventHandler;
import org.sandboxpowered.eventhandler.ResettableEventHandler;

public final class RenderEvents {
    public static final EventHandler<RenderInWorld> RENDER_IN_WORLD = new ResettableEventHandler<>();

    public interface RenderInWorld {
        void onEvent(World world, MatrixStack stack, VertexConsumer.Provider provider);
    }
}
