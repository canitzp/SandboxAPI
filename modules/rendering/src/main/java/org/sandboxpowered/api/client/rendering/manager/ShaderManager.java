package org.sandboxpowered.api.client.rendering.manager;

import org.sandboxpowered.api.client.rendering.shader.Shader;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.PreAlpha;

@PreAlpha
public interface ShaderManager {
    Shader loadShader(Identity identity);
}
