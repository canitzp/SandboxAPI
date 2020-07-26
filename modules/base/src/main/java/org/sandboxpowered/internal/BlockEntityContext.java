package org.sandboxpowered.internal;

import org.sandboxpowered.api.util.annotation.Internal;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.World;

@Internal
public interface BlockEntityContext {
    World getWorld();

    Position getPosition();

    void save();
}
