package org.sandboxpowered.api.client.rendering;

import org.sandboxpowered.api.util.Identity;

public interface PipelineService {
    RenderPipeline getPipeline(Identity identity) throws RenderPipeline.UnsupportedRenderPipelineException;
}
