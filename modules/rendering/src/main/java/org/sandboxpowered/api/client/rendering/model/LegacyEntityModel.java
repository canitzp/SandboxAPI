package org.sandboxpowered.api.client.rendering.model;

import org.sandboxpowered.api.client.rendering.VertexConsumer;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.internal.SandboxInternalRenderingService;
import org.sandboxpowered.api.util.math.MatrixStack;

/**
 * Entity model that is designed to mimic the API most modelling programs will be able to export.
 * <p/>
 * <b>Should only be used if there is no other option.</b>
 */
public abstract class LegacyEntityModel<T extends Entity> {
    protected int textureWidth = 256, textureHeight = 256;

    public final Bone createBone() {
        return SandboxInternalRenderingService.getInstance().createBone(this);
    }

    public abstract void setRotationAngles(T entity, float swing, float swingAmount, float age, float headYaw, float headPitch);

    public abstract void render(MatrixStack matrixStack, VertexConsumer vertexConsumer, int light, int overlay, float red, float green, float blue, float alpha);

    public interface Bone {
        Bone setRotationPoint(float x, float y, float z);

        Bone setTextureOffset(int x, int y);

        Bone setRotationAngle(float x, float y, float z);

        Bone addChild(Bone bone);

        default Bone addCube(float x, float y, float z, float sizeX, float sizeY, float sizeZ) {
            return addCube(x, y, z, sizeX, sizeY, sizeZ, 0F, false);
        }

        default Bone addCube(float x, float y, float z, float sizeX, float sizeY, float sizeZ, float inflation) {
            return addCube(x, y, z, sizeX, sizeY, sizeZ, inflation, false);
        }

        default Bone addCube(float x, int y, float z, float sizeX, float sizeY, float sizeZ, boolean mirror) {
            return addCube(x, y, z, sizeX, sizeY, sizeZ, 0F, mirror);
        }

        Bone addCube(float x, float y, float z, float sizeX, float sizeY, float sizeZ, float inflation, boolean mirror);

        void render(MatrixStack stack, VertexConsumer consumer, int light, int overlay);

    }
}