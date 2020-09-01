package org.sandboxpowered.api.client.rendering;

import org.sandboxpowered.api.client.rendering.ui.DynamicRenderer;
import org.sandboxpowered.api.client.rendering.ui.TextRenderer;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.PreAlpha;
import org.sandboxpowered.internal.SandboxServiceLoader;

@PreAlpha
public interface RenderPipeline {
    static RenderPipeline getUniversalPipeline() {
        return SandboxServiceLoader.getOrLoadService(PipelineService.class).getPipeline(Identity.of("sandbox", "universal"));
    }

    static RenderPipeline getPipeline(Identity identity) throws UnsupportedRenderPipelineException {
        return SandboxServiceLoader.getOrLoadService(PipelineService.class).getPipeline(identity);
    }

    DynamicRenderer getDynamicRenderer();

    TextRenderer getTextRenderer();

    class UnsupportedRenderPipelineException extends RuntimeException {
        public UnsupportedRenderPipelineException(Identity identity) {
            super(String.format("Render Pipeline '%s' is unsupported.", identity.toString()));
        }
    }

    interface PipelineService {
        RenderPipeline getPipeline(Identity identity) throws UnsupportedRenderPipelineException;
    }
}