package org.sandboxpowered.api.client.rendering.manager;

import org.sandboxpowered.api.client.rendering.model.Model;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.PreAlpha;

import java.util.Collection;

@PreAlpha
public interface ModelLoader {
    Model loadModel(Identity model);

    Collection<Identity> getSupportedModelFormats();

    default boolean isSupportedFormat(Identity modelType) {
        return getSupportedModelFormats().contains(modelType);
    }
}
