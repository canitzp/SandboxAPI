package org.sandboxpowered.api.client.rendering.manager;

import org.sandboxpowered.api.client.rendering.shader.Shader;
import org.sandboxpowered.api.util.Identity;

public interface ShaderManager {
    Shader loadShader(Identity identity);
}
