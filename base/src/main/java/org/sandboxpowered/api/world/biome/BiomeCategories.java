package org.sandboxpowered.api.world.biome;

import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Identity;

public class BiomeCategories {
   public static final Registry.Entry<Biome.Category> TAIGA = get("taiga");
   public static final Registry.Entry<Biome.Category> EXTREME_HILLS = get("extreme_hills");
   public static final Registry.Entry<Biome.Category> JUNGLE = get("jungle");
   public static final Registry.Entry<Biome.Category> MESA = get("mesa");
   public static final Registry.Entry<Biome.Category> PLAINS = get("plains");
   public static final Registry.Entry<Biome.Category> SAVANNA = get("savanna");
   public static final Registry.Entry<Biome.Category> ICY = get("icy");
   public static final Registry.Entry<Biome.Category> THEEND = get("the_end");
   public static final Registry.Entry<Biome.Category> BEACH = get("beach");
   public static final Registry.Entry<Biome.Category> FOREST = get("forest");
   public static final Registry.Entry<Biome.Category> OCEAN = get("ocean");
   public static final Registry.Entry<Biome.Category> DESERT = get("desert");
   public static final Registry.Entry<Biome.Category> RIVER = get("river");
   public static final Registry.Entry<Biome.Category> SWAMP = get("swamp");
   public static final Registry.Entry<Biome.Category> MUSHROOM = get("mushroom");
   public static final Registry.Entry<Biome.Category> NETHER = get("nether");

   private static Registry.Entry<Biome.Category> get(String name) {
       return Biome.Category.REGISTRY.get(Identity.of("minecraft", name));
   }
}
