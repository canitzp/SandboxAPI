package org.sandboxpowered.api.client.rendering.model.entity;

import org.sandboxpowered.api.client.rendering.VertexConsumer;
import org.sandboxpowered.api.util.annotation.PreAlpha;
import org.sandboxpowered.api.util.math.MatrixStack;
import org.sandboxpowered.api.util.math.Vec3f;
import org.sandboxpowered.internal.InternalService;

@PreAlpha
public interface ModelPart {
    static ModelPart make(EntityModel model, int i, int j) {
        return make(model.getTextureWidth(), model.getTextureHeight(), i, j);
    }

    static ModelPart make(int textureWidth, int textureHeight, int textureU, int textureV) {
        return (ModelPart) InternalService.getInstance().makeModelPart(textureWidth, textureHeight, textureU, textureV);
    }

    ModelPart addCube(float offsetX, float offsetY, float offsetZ, float width, float height, float depth);

    ModelPart setPivot(float x, float y, float z);

    Vec3f getPivot();

    default ModelPart addPivot(float x, float y, float z) {
        Vec3f pivot = getPivot();
        return setPivot(pivot.getX() + x, pivot.getY() + y, pivot.getZ() + z);
    }

    void render(MatrixStack matrixStack, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha);

    default void render(MatrixStack matrixStack, VertexConsumer vertexConsumer, int light, int overlay) {
        render(matrixStack, vertexConsumer, light, overlay, 1, 1, 1, 1);
    }
}
