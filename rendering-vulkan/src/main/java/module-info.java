module sandbox.rendering.vulkan {
    requires transitive sandbox.rendering.universal;

    uses org.sandboxpowered.api.client.render.RenderPipeline;

    exports org.sandboxpowered.api.client.render.vulkan;
}