package org.sandboxpowered.api.client.rendering.model;

import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.annotation.PreAlpha;

import java.util.Collection;

@PreAlpha
public interface Model {

    Collection<Quad> getQuads(Direction direction);

    Collection<Quad> getAllQuads();

    interface Quad {
    }
}
