package org.sandboxpowered.api.client.rendering.manager;

import org.sandboxpowered.api.client.rendering.model.Model;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.PreAlpha;

import java.util.Collection;

@PreAlpha
public interface ModelManager {
    /**
     * Registers a model to be manually loaded
     *
     * @param model Identity of the model to load
     */
    void register(Identity.Variant model);

    void registerLoader(ModelLoader loader);

    Model getModel(Identity.Variant model);

    Collection<Identity> getSupportedModelFormats();

    default boolean isSupportedFormat(Identity modelType) {
        return getSupportedModelFormats().contains(modelType);
    }

    interface DefaultFormats {
        Identity MOJANGSON = Identity.of("minecraft", "json");
        Identity OBJ = Identity.of("sandbox", "obj");
        Identity GLTF = Identity.of("sandbox", "gltf");
    }
}