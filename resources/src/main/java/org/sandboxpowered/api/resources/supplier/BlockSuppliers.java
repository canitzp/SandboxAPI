package org.sandboxpowered.api.resources.supplier;

import org.sandboxpowered.api.block.BaseBlock;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.block.Blocks;
import org.sandboxpowered.api.block.Material;

import java.util.function.Supplier;

//TODO: mining levels/tools, sounds, etc.
public final class BlockSuppliers {
    /**
     * A generic metal ore supplier, similar to the properties of coal or iron ore.
     */
    public static final Supplier<Block> STONE_TIER_ORE = () -> new BaseBlock(Block.Settings.builder(Material.STONE)
            .setHardness(3.0f)
            .setResistance(3.0f)
            .build());
    /**
     * A resilient metal ore supplier, requires an iron like tool level to collect.
     */
    public static final Supplier<Block> IRON_TIER_ORE = () -> new BaseBlock(Block.Settings.builder(Blocks.DIAMOND_ORE)
            .setHardness(3.0f)
            .setResistance(3.0f)
            /*.breakByTool(FabricToolTags.PICKAXES, 2)*/
            .build());
    /**
     * A resilient metal ore supplier, similar to the properties of redstone ore where it has a glowing state.
     *
     * <p>May be used in future for other ores.</p>
     * TODO: glowing effect
     */
    public static final Supplier<Block> LIGHTABLE_IRON_TIER_ORE = () -> new BaseBlock(Block.Settings.builder(Blocks.REDSTONE_ORE)
            .setHardness(3.0f)
            .setResistance(3.0f)
            /*.breakByTool(FabricToolTags.PICKAXES, 2)*/
            .build());
    /**
     * An extremely resilient metal ore supplier, only harvestable by diamond or better pickaxes.
     */
    public static final Supplier<Block> DIAMOND_TIER_ORE = () -> new BaseBlock(Block.Settings.builder(Material.STONE)
            .setHardness(3.0f)
            .setResistance(3.0f)
            /*.breakByTool(FabricToolTags.PICKAXES, 3)*/
            .build());
    /**
     * An extremely resilient metal ore supplier, only harvestable by diamond or better pickaxes.
     * TODO: glowing effect
     */
    public static final Supplier<Block> RADIOACTIVE_DIAMOND_TIER_ORE = () -> new BaseBlock(Block.Settings.builder(Blocks.REDSTONE_ORE)
            .setHardness(3.0f)
            .setResistance(3.0f)
            /*.breakByTool(FabricToolTags.PICKAXES, 3)*/
            .build());
    /**
     * A generic metal block supplier, based on the properties from iron_block.
     */
    public static final Supplier<Block> METAL_BLOCK = () -> new BaseBlock(Block.Settings.builder(Material.METAL)
            /*.sounds(CottonResources.METAL_SOUND_GROUP)*/
            .setHardness(5.0f)
            .setResistance(6.0f)
            .build());
    /**
     * A block supplier based on coal_block.
     */
    public static final Supplier<Block> COAL_BLOCK = () -> new BaseBlock(Block.Settings.builder(Material.STONE)
            .setHardness(5.0f)
            .setResistance(6.0f)
            .build());

    private BlockSuppliers() {
    }
}
