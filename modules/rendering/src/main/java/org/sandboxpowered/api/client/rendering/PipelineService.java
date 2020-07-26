package org.sandboxpowered.api.client.rendering;

import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.PreAlpha;

@PreAlpha
public interface PipelineService {
    RenderPipeline getPipeline(Identity identity) throws RenderPipeline.UnsupportedRenderPipelineException;
}
