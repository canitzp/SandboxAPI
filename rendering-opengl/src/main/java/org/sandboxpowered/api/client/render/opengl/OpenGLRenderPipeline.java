package org.sandboxpowered.api.client.render.opengl;

import org.sandboxpowered.api.client.render.RenderPipeline;

public interface OpenGLRenderPipeline extends RenderPipeline {
    static boolean isSupported() {
        return false;
    }
}