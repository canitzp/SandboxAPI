package org.sandboxpowered.api.world.dimension;

import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.math.Vec3d;
import org.sandboxpowered.api.util.math.Vec3i;
import org.sandboxpowered.api.world.World;
import org.sandboxpowered.api.world.border.WorldBorder;
import org.sandboxpowered.api.world.gen.chunk.ChunkGenerator;

import javax.annotation.Nullable;
import java.io.File;

public interface Dimension {
    World getWorld();

    default int getMoonPhase(long time) {
        return (int) (time / 24000L % 8L + 8L) % 8;
    }

    default float[] getBackgroundColor(float skyAngle, float tickDelta) {
        float f = 0.4F;
        float g = (float) Math.cos(skyAngle * 6.2831855F) - 0.0F;
        float h = -0.0F;
        if (g >= -0.4F && g <= 0.4F) {
            float i = (g - -0.0F) / 0.4F * 0.5F + 0.5F;
            float j = 1.0F - (1.0F - (float) Math.sin(i * 3.1415927F)) * 0.99F;
            j *= j;
            float[] backgroundColor = new float[4];
            backgroundColor[0] = i * 0.3F + 0.7F;
            backgroundColor[1] = i * i * 0.7F + 0.2F;
            backgroundColor[2] = i * i * 0.0F + 0.2F;
            backgroundColor[3] = j;
            return backgroundColor;
        } else {
            return null;
        }
    }

    default float getCloudHeight() {
        return 128.0F;
    }

    default boolean hasGround() {
        return true;
    }

    @Nullable
    default Position getForcedSpawnPoint() {
        return null;
    }

    double getHorizonShadingRatio();

    boolean doesWaterVaporize();

    default boolean hasSkyLight() {
        return getType().hasSkyLight();
    }

    float getBrightness(int lightLevel);

    WorldBorder createWorldBorder();

    default void saveWorldData() {
    }

    default void update() {
    }

    ChunkGenerator<?> createChunkGenerator();

    @Nullable
    Position getSpawningBlockInChunk(/*Replace with Chunk once possible*/ Vec3i chunk, boolean checkMobSpawnValidity);

    @Nullable
    Position getTopSpawningBlockPosition(int x, int z, boolean checkMobSpawnValidity);

    float getSkyAngle(long timeOfDay, float tickDelta);

    boolean hasVisibleSky();

    Vec3d getFogColor(float skyAngle, float tickDelta);

    boolean canPlayersSleep();

    boolean isFogThick(int x, int z);

    Type getType();

    interface Type extends Content<Type> {
        Registry<Type> REGISTRY = Registry.getRegistryFromType(Type.class);

        String getSuffix();

        String getSaveDirectory();

        default File getSaveDirectory(File root) {
            return getSaveDirectory().isEmpty() ? root : new File(root, getSaveDirectory());
        }

        boolean hasSkyLight();

        //Commented out as biomes aren't done yet
        //BiomeProvider.Type getBiomeProvider.Type();

        @Override
        default Class<Type> getContentType() {
            return Type.class;
        }
    }
}
