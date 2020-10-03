package org.sandboxpowered.api.block;

import org.sandboxpowered.internal.InternalService;

public interface Material {
    Material AIR = getMaterial("AIR");
    Material STRUCTURE_VOID = getMaterial("STRUCTURE_VOID");
    Material PORTAL = getMaterial("PORTAL");
    Material CARPET = getMaterial("CARPET");
    Material PLANT = getMaterial("PLANT");
    Material UNDERWATER_PLANT = getMaterial("UNDERWATER_PLANT");
    Material REPLACEABLE_PLANT = getMaterial("REPLACEABLE_PLANT");
    Material SEAGRASS = getMaterial("SEAGRASS");
    Material WATER = getMaterial("WATER");
    Material BUBBLE_COLUMN = getMaterial("BUBBLE_COLUMN");
    Material LAVA = getMaterial("LAVA");
    Material SNOW = getMaterial("SNOW");
    Material FIRE = getMaterial("FIRE");
    Material PART = getMaterial("PART");
    Material COBWEB = getMaterial("COBWEB");
    Material REDSTONE_LAMP = getMaterial("REDSTONE_LAMP");
    Material CLAY = getMaterial("CLAY");
    Material EARTH = getMaterial("EARTH");
    Material ORGANIC = getMaterial("ORGANIC");
    Material PACKED_ICE = getMaterial("PACKED_ICE");
    Material SAND = getMaterial("SAND");
    Material SPONGE = getMaterial("SPONGE");
    Material SHULKER_BOX = getMaterial("SHULKER_BOX");
    Material WOOD = getMaterial("WOOD");
    Material BAMBOO_SAPLING = getMaterial("BAMBOO_SAPLING");
    Material BAMBOO = getMaterial("BAMBOO");
    Material WOOL = getMaterial("WOOL");
    Material TNT = getMaterial("TNT");
    Material LEAVES = getMaterial("LEAVES");
    Material GLASS = getMaterial("GLASS");
    Material ICE = getMaterial("ICE");
    Material CACTUS = getMaterial("CACTUS");
    Material STONE = getMaterial("STONE");
    Material METAL = getMaterial("METAL");
    Material SNOW_BLOCK = getMaterial("SNOW_BLOCK");
    Material ANVIL = getMaterial("ANVIL");
    Material BARRIER = getMaterial("BARRIER");
    Material PISTON = getMaterial("PISTON");
    Material UNUSED_PLANT = getMaterial("UNUSED_PLANT");
    Material PUMPKIN = getMaterial("PUMPKIN");
    Material EGG = getMaterial("EGG");
    Material CAKE = getMaterial("CAKE");

    static Material getMaterial(String mat) {
        return InternalService.getInstance().getMaterial(mat);
    }

    PistonInteraction getPistonInteraction();

    boolean doesBlockMovement();

    boolean isBurnable();

    boolean isBreakByHand();

    boolean isLiquid();

    boolean doesBlockLight();

    boolean isReplaceable();

    boolean isSolid();

    enum PistonInteraction {
        NORMAL,
        DESTROY,
        BLOCK,
        IGNORE,
        PUSH_ONLY
    }
}