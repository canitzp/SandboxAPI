package org.sandboxpowered.api.client.rendering.manager;

import org.sandboxpowered.api.block.entity.BlockEntity;
import org.sandboxpowered.api.client.rendering.entity.BlockEntityRender;
import org.sandboxpowered.api.util.annotation.PreAlpha;

import java.util.function.Supplier;

@PreAlpha
public interface RenderManager {
    <T extends BlockEntity> void register(Class<T> beClass, Supplier<BlockEntityRender<T>> render);
}
