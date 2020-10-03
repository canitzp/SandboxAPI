package org.sandboxpowered.api.client.rendering.shader;

import org.sandboxpowered.api.util.annotation.PreAlpha;
import org.sandboxpowered.api.util.math.Color;
import org.sandboxpowered.api.util.math.Matrix4f;
import org.sandboxpowered.api.util.math.Vec2f;
import org.sandboxpowered.api.util.math.Vec3f;

@PreAlpha
public interface Shader {
    void bind();

    void attach(String samplerName, Object sampler);

    Uniform getUniform(String uniform);

    void unbind();

    interface Uniform {
        void set(float value);

        void set(Vec2f vec);

        void set(Vec3f vec);

        void set(Color color);

        void set(Matrix4f matrix);
    }
}