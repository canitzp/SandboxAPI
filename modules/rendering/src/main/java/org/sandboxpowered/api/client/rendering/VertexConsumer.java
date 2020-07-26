package org.sandboxpowered.api.client.rendering;

import org.sandboxpowered.api.client.rendering.model.Model;
import org.sandboxpowered.api.util.annotation.PreAlpha;
import org.sandboxpowered.api.util.math.*;

@PreAlpha
public interface VertexConsumer {

    void quad(MatrixStack.Entry entry, Model.Quad quad, Color color, int light, int overlay);

    void vertex(Vec3f position, Color color, Vec2f texture, int overlay, int light, Vec3f normal);

    void vertex(Matrix4f matrix, float x, float y, float z);

    void vertex(Matrix4f matrix, Vec3f vec);

    VertexConsumer vertex(float x, float y, float z);

    VertexConsumer vertex(Vec3f vec);

    VertexConsumer color(int red, int green, int blue, int alpha);

    VertexConsumer color(int red, int green, int blue);

    VertexConsumer color(Color color);

    VertexConsumer color(float red, float green, float blue, float alpha);

    VertexConsumer color(float red, float green, float blue);

    VertexConsumer texture(float u, float v);

    VertexConsumer texture(Vec2f vec);

    VertexConsumer overlay(int uv);

    VertexConsumer overlay(int u, int v);

    VertexConsumer overlay(Vec2i vec);

    VertexConsumer light(int uv);

    VertexConsumer light(int u, int v);

    VertexConsumer light(Vec2i vec);

    VertexConsumer normal(float x, float y, float z);

    VertexConsumer normal(Vec3f vec);

    void next();

    interface Provider {
        VertexConsumer getVertexConsumer(RenderLayer layer);
    }

    interface Builder extends VertexConsumer {
        void end();
    }
}