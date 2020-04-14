package org.sandboxpowered.api.world.biome.source;

import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.world.biome.Biome;
import org.sandboxpowered.api.world.biome.Biomes;

import javax.annotation.Nullable;
import java.util.*;
import java.util.stream.Collectors;

public interface BiomeSource extends BiomeAccess.Storage {
   List<Registry.Entry<Biome>> SPAWN_BIOMES = Arrays.asList(Biomes.FOREST, Biomes.PLAINS, Biomes.TAIGA, Biomes.TAIGA_HILLS, Biomes.WOODED_HILLS, Biomes.JUNGLE, Biomes.JUNGLE_HILLS);

   //This needs caching
   default List<Biome> getSpawnBiomes() {
      return SPAWN_BIOMES.stream().map(Registry.Entry::get).collect(Collectors.toList());
   }

   default Set<Biome> getBiomesInArea(int x, int y, int z, int radius) {
      int i = x - radius >> 2;
      int j = y - radius >> 2;
      int k = z - radius >> 2;
      int l = x + radius >> 2;
      int m = y + radius >> 2;
      int n = z + radius >> 2;
      int o = l - i + 1;
      int p = m - j + 1;
      int q = n - k + 1;
      Set<Biome> set = new HashSet<>();

      for (int r = 0; r < q; ++r) {
         for (int s = 0; s < o; ++s) {
            for (int t = 0; t < p; ++t) {
               int u = i + s;
               int v = j + t;
               int w = k + r;
               set.add(this.getBiomeForNoiseGen(u, v, w));
            }
         }
      }

      return set;
   }

   @Nullable
   default Position locateBiome(int x, int y, int z, int radius, List<Biome> list, Random random) {
      int i = x - radius >> 2;
      int j = z - radius >> 2;
      int k = x + radius >> 2;
      int l = z + radius >> 2;
      int m = k - i + 1;
      int n = l - j + 1;
      int o = y >> 2;
      Position blockPos = null;
      int p = 0;

      for (int q = 0; q < n; ++q) {
         for (int r = 0; r < m; ++r) {
            int s = i + r;
            int t = j + q;
            if (list.contains(this.getBiomeForNoiseGen(s, o, t))) {
               if (blockPos == null || random.nextInt(p + 1) == 0) {
                  blockPos = Position.create(s << 2, y, t << 2);
               }

               ++p;
            }
         }
      }

      return blockPos;
   }

   default float getNoiseRange(int i, int j) {
      return 0.0F;
   }

   //Map<StructureFeature<?>, Boolean> getStructureFeatures();

   //default boolean hasStructureFeature(StructureFeature<?> feature) { return getStructureFeatures().computeIfAbsent(feature, (structureFeature) -> getBiomes().stream().anyMatch((biome) -> biome.hasStructureFeature(structureFeature))); }

   Set<BlockState> getTopMaterials();

   Set<Biome> getBiomes();
}
