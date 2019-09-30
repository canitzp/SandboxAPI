package org.sandboxpowered.sandbox.api.block.entity;

import org.sandboxpowered.sandbox.api.util.annotation.Internal;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.world.World;

@Internal
public interface BlockEntityContext {
    World getWorld();

    Position getPosition();

    void save();
}
