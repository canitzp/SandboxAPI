package org.sandboxpowered.api.world.biome;

import org.sandboxpowered.api.block.FluidBlock;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.MobCategory;
import org.sandboxpowered.api.fluid.Fluids;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.state.FluidState;
import org.sandboxpowered.api.util.Color;
import org.sandboxpowered.api.util.Functions;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.text.Text;
import org.sandboxpowered.api.world.WorldReader;
import org.sandboxpowered.api.world.gen.chunk.Chunk;

import javax.annotation.Nullable;
import java.util.List;
import java.util.Random;

public interface Biome extends Content<Biome> {
    Registry<Biome> REGISTRY = Functions.getInstance().registryFunction(Biome.class);

    default boolean hasParent() {
        return false;
    }

    private Color calculateSkyColor() {
        float f = getTemperature();;
        f /= 3.0F;
        f = f < -1 ? -1 : f > 1 ? 1 : f;
        return Color.fromHsv(0.62222224F - f * 0.05F, 0.5F + f * 0.1F, 1.0F);
    }

    default Color getSkyColor() {
        return calculateSkyColor();
    }

    default void addSpawn(MobCategory type, Biome.SpawnEntry spawnEntry) {
        getSpawns(type).add(spawnEntry);
    }

    List<Biome.SpawnEntry> getSpawns(MobCategory type);

    Biome.Precipitation getPrecipitation();

    default boolean hasHighHumidity() {
        return this.getRainfall() > 0.85F;
    }

    default float getMaxSpawnLimit() {
        return 0.1F;
    }

    float getTemperature(Position blockPos);

    default boolean canSetIce(WorldReader world, Position blockPos) {
        return this.canSetIce(world, blockPos, true);
    }

    default boolean canSetIce(WorldReader world, Position pos, boolean doWaterCheck) {
        if (this.getTemperature(pos) >= 0.15F) {
            return false;
        } else {
            if (pos.getY() >= 0 && pos.getY() < 256/* && world.getLightLevel(LightType.BLOCK, pos) < 10*/) {
                BlockState blockState = world.getBlockState(pos);
                FluidState fluidState = world.getFluidState(pos);
                if (fluidState.getFluid() == Fluids.WATER.get() && blockState.getBlock() instanceof FluidBlock) {
                    if (!doWaterCheck) {
                        return true;
                    }

                    return world.getFluidState(pos.west()).getFluid() != Fluids.WATER.get() || world.getFluidState(pos.east()).getFluid() != Fluids.WATER.get() || world.getFluidState(pos.north()).getFluid() != Fluids.WATER.get() || world.getFluidState(pos.south()).getFluid() != Fluids.WATER.get();
                }
            }

            return false;
        }
    }

    default boolean canSetSnow(WorldReader worldView, Position blockPos) {
        if (this.getTemperature(blockPos) >= 0.15F) {
            return false;
        } else {
            if (blockPos.getY() >= 0 && blockPos.getY() < 256/* && worldView.getLightLevel(LightType.BLOCK, blockPos) < 10*/) {
                BlockState blockState = worldView.getBlockState(blockPos);
                /* && Blocks.SNOW.get().getBaseState().canPlaceAt(worldView, blockPos)*/
                return blockState.isAir();
            }

            return false;
        }
    }

    /*
    //Default implementations could be used here
    void addFeature(GenerationStep.Feature step, ConfiguredFeature<?, ?> configuredFeature);
    <C extends CarverConfig> void addCarver(GenerationStep.Carver step, ConfiguredCarver<C> configuredCarver);
    List<ConfiguredCarver<?>> getCarversForStep(GenerationStep.Carver carver);
    <C extends FeatureConfig> void addStructureFeature(ConfiguredFeature<C, ? extends StructureFeature<C>> configuredFeature);
    <C extends FeatureConfig> boolean hasStructureFeature(StructureFeature<C> structureFeature);
    @Nullable
    <C extends FeatureConfig> C getStructureFeatureConfig(StructureFeature<C> structureFeature);
    List<ConfiguredFeature<?, ?>> getFlowerFeatures();
    List<ConfiguredFeature<?, ?>> getFeaturesForStep(GenerationStep.Feature feature);
    void generateFeatureStep(GenerationStep.Feature step, ChunkGenerator<? extends ChunkGeneratorConfig> chunkGenerator, World world, long seed, Random random, Position pos);*/

    int getGrassColorAt(double x, double z);

    int getFoliageColor();

    void buildSurface(Random random, Chunk chunk, int x, int z, int worldHeight, double noise, BlockState defaultBlock, BlockState defaultFluid, int seaLevel, long seed);

    default TemperatureGroup getTemperatureGroup() {
        if (getCategory() == BiomeCategories.OCEAN.get()) {
            return Biome.TemperatureGroup.OCEAN;
        } else if (this.getTemperature() < 0.2) {
            return Biome.TemperatureGroup.COLD;
        } else {
            return this.getTemperature() < 1.0 ? Biome.TemperatureGroup.MEDIUM : Biome.TemperatureGroup.WARM;
        }
    }

    float getDepth();

    float getRainfall();

    Text getName();

    float getScale();

    float getTemperature();

    int getWaterColor();

    int getWaterFogColor();

    @Nullable
    Biome.Category getCategory();

    //Needs structure generation features
    /*ConfiguredSurfaceBuilder<?> getSurfaceBuilder();

    SurfaceConfig getSurfaceConfig();

    Map<StructureFeature<?>, FeatureConfig> getStructureFeatures();

    default  <C extends FeatureConfig> void addStructureFeature(ConfiguredFeature<C, ? extends StructureFeature<C>> configuredFeature) {
        getStructureFeatures().put(configuredFeature.getFeature(), configuredFeature.getConfig());
    }

    default  <C extends FeatureConfig> boolean hasStructureFeature(StructureFeature<C> structureFeature) {
        return getStructureFeatures().containsKey(structureFeature);
    }

    @Nullable
    default  <C extends FeatureConfig> C getStructureFeatureConfig(StructureFeature<C> structureFeature) {
        return getStructureFeatures().get(structureFeature);
    }*/

    @Override
    default Class<Biome> getContentType() {
        return Biome.class;
    }

    interface Settings {
        /*<SC extends SurfaceConfig> Biome.Settings configureSurfaceBuilder(SurfaceBuilder<SC> surfaceBuilder, SC surfaceConfig);

        Biome.Settings surfaceBuilder(ConfiguredSurfaceBuilder<?> surfaceBuilder);*/

        Biome.Settings precipitation(Biome.Precipitation precipitation);

        Biome.Settings category(Biome.Category category);

        Biome.Settings depth(float depth);

        Biome.Settings scale(float scale);

        Biome.Settings temperature(float temperature) ;

        Biome.Settings downfall(float downfall);

        Biome.Settings waterColor(int waterColor);

        Biome.Settings waterFogColor(int waterFogColor);

        Biome.Settings parent(@Nullable String parent);
    }

    interface SpawnEntry {
        Entity.Type getType();

        int getMinGroupSize();

        int getMaxGroupSize();

        int getWeight();
    }

    enum Precipitation {
        NONE,
        RAIN,
        SNOW;
    }

    interface Category extends Content<Category> {
        Registry<Category> REGISTRY = Functions.getInstance().registryFunction(Category.class);

        @Override
        default Class<Category> getContentType() {
            return Category.class;
        }
    }

    enum TemperatureGroup {
        OCEAN,
        COLD,
        MEDIUM,
        WARM
    }
}
