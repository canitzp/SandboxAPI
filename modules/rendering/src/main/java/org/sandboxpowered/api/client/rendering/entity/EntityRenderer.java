package org.sandboxpowered.api.client.rendering.entity;

import org.sandboxpowered.api.client.rendering.VertexConsumer;
import org.sandboxpowered.api.util.annotation.PreAlpha;
import org.sandboxpowered.api.util.math.MatrixStack;

@PreAlpha
public interface EntityRenderer<T> {
    void render(T entity, float yaw, float delta, MatrixStack stack, VertexConsumer.Provider provider, int light);
}
