package org.sandboxpowered.sandbox.api.block.entity;

import com.google.common.annotations.Beta;
import org.sandboxpowered.sandbox.api.util.math.Position;
import org.sandboxpowered.sandbox.api.world.World;

@Beta
public interface BlockEntityContext {
    World getWorld();

    Position getPosition();

    void save();
}
