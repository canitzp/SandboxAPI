package org.sandboxpowered.api.world.biome.source;

import org.sandboxpowered.api.util.Functions;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.biome.Biome;

public interface BiomeAccess {
    default BiomeAccess create(Storage storage, long seed, Type type) {
        return Functions.getInstance().createBiomeAccess(storage, seed, type);
    }

    Storage getStorage();

    long getSeed();

    Type getType();

    default BiomeAccess withSource(BiomeSource source) {
        return create(source, getSeed(), getType());
    }

    default Biome getBiome(Position pos) {
        return getType().getBiome(getSeed(), pos.getX(), pos.getY(), pos.getZ(), getStorage());
    }

    interface Storage {
        Biome getBiomeForNoiseGen(int biomeX, int biomeY, int biomeZ);
    }

    interface Type {
        Biome getBiome(long seed, int x, int y, int z, BiomeAccess.Storage storage);
    }
}
