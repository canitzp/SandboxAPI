package org.sandboxpowered.api.world.gen.chunk;

import org.sandboxpowered.api.block.Blocks;
import org.sandboxpowered.api.state.BlockState;

public interface ChunkGeneratorConfig {
   default int getVillageDistance() {
      return 32;
   }

   default int getVillageSeparation() {
      return 8;
   }

   default int getOceanMonumentSpacing() {
      return 32;
   }

   default int getOceanMonumentSeparation() {
      return 5;
   }

   default int getStrongholdDistance() {
      return 32;
   }

   default int getStrongholdCount() {
      return 128;
   }

   default int getStrongholdSpread() {
      return 3;
   }

   default int getTempleDistance() {
      return 32;
   }

   default int getTempleSeparation() {
      return 8;
   }

   default int getShipwreckSpacing() {
      return 16;
   }

   default int getShipwreckSeparation() {
      return 8;
   }

   default int getOceanRuinSpacing() {
      return 16;
   }

   default int getOceanRuinSeparation() {
      return 8;
   }

   default int getEndCityDistance() {
      return 20;
   }

   default int getEndCitySeparation() {
      return 11;
   }

   default int getMansionDistance() {
      return 80;
   }

   default int getMansionSeparation() {
      return 20;
   }

   default BlockState getDefaultBlock() {
      return Blocks.STONE.get().getBaseState();
   }

   default BlockState getDefaultFluid() {
      return Blocks.WATER.get().getBaseState();
   }

   void setDefaultBlock(BlockState state);

   void setDefaultFluid(BlockState state);

   default int getMaxY() {
      return 0;
   }

   default int getMinY() {
      return 256;
   }
}
