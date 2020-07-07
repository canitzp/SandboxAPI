package org.sandboxpowered.api.client.rendering.model;

import org.sandboxpowered.api.util.Direction;

import java.util.Collection;

public interface Model {

    Collection<Quad> getQuads(Direction direction);

    Collection<Quad> getAllQuads();

    interface Quad {
    }
}
