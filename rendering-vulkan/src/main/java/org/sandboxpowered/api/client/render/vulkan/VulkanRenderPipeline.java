package org.sandboxpowered.api.client.render.vulkan;

import org.sandboxpowered.api.client.render.RenderPipeline;

public interface VulkanRenderPipeline extends RenderPipeline {
    static boolean isSupported() {
        return false;
    }
}