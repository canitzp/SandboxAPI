package org.sandboxpowered.api.client.rendering.model.entity;

import org.sandboxpowered.api.client.rendering.RenderLayer;
import org.sandboxpowered.api.client.rendering.VertexConsumer;
import org.sandboxpowered.api.util.annotation.PreAlpha;
import org.sandboxpowered.api.util.math.MatrixStack;

@PreAlpha
public interface EntityModel {
    int getTextureWidth();

    int getTextureHeight();

    void render(MatrixStack matrixStack, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha);

    //TODO default implementations
    ModelPart addPart(String name, ModelPart part);

    default RenderLayer getLayer() {
        return null;
    }
}
