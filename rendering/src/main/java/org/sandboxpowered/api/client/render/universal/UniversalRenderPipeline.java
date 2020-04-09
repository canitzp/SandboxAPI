package org.sandboxpowered.api.client.render.universal;

import org.sandboxpowered.api.client.render.RenderPipeline;

public interface UniversalRenderPipeline extends RenderPipeline {
    static boolean isSupported() {
        return false;
    }

}