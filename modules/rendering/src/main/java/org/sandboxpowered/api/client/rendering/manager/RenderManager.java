package org.sandboxpowered.api.client.rendering.manager;

import org.sandboxpowered.api.block.entity.BlockEntity;
import org.sandboxpowered.api.client.rendering.entity.BlockEntityRenderer;
import org.sandboxpowered.api.client.rendering.entity.EntityRenderer;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.util.annotation.PreAlpha;

import java.util.function.Supplier;

@PreAlpha
public interface RenderManager {
    void register(BlockEntity.Type type, Supplier<BlockEntityRenderer<?>> render);

    void register(Entity.Type type, Supplier<EntityRenderer<?>> render);
}
