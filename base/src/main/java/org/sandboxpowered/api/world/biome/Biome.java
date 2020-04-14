package org.sandboxpowered.api.world.biome;

import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Functions;

public interface Biome extends Content<Biome> {
    Registry<Biome> REGISTRY = Functions.getInstance().registryFunction(Biome.class);

    @Override
    default Class<Biome> getContentType() {
        return Biome.class;
    }
}
