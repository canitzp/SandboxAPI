package org.sandboxpowered.api.client.rendering.entity;

import org.sandboxpowered.api.client.rendering.model.entity.EntityModel;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.PreAlpha;

//TODO this is currently only the very very basic to render only the simplest of entities with no custom rendering, not even transformation.
//Needless to say, that means it is a placeholder
@PreAlpha
public interface EntityRenderer {
    EntityModel getModel();

    Identity getTexture();
}
