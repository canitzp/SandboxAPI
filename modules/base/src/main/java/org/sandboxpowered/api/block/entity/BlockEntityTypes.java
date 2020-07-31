package org.sandboxpowered.api.block.entity;

import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Identity;

public class BlockEntityTypes {
    public static final Registry.Entry<BlockEntity.Type> FURNACE = get("furnace");
    public static final Registry.Entry<BlockEntity.Type> CHEST = get("chest");
    public static final Registry.Entry<BlockEntity.Type> TRAPPED_CHEST = get("trapped_chest");
    public static final Registry.Entry<BlockEntity.Type> ENDER_CHEST = get("ender_chest");
    public static final Registry.Entry<BlockEntity.Type> JUKEBOX = get("jukebox");
    public static final Registry.Entry<BlockEntity.Type> DISPENSER = get("dispenser");
    public static final Registry.Entry<BlockEntity.Type> DROPPER = get("dropper");
    public static final Registry.Entry<BlockEntity.Type> SIGN = get("sign");
    public static final Registry.Entry<BlockEntity.Type> MOB_SPAWNER = get("mob_spawner");
    public static final Registry.Entry<BlockEntity.Type> PISTON = get("piston");
    public static final Registry.Entry<BlockEntity.Type> BREWING_STAND = get("brewing_stand");
    public static final Registry.Entry<BlockEntity.Type> ENCHANTING_TABLE = get("enchanting_table");
    public static final Registry.Entry<BlockEntity.Type> END_PORTAL = get("end_portal");
    public static final Registry.Entry<BlockEntity.Type> BEACON = get("beacon");
    public static final Registry.Entry<BlockEntity.Type> SKULL = get("skull");
    public static final Registry.Entry<BlockEntity.Type> DAYLIGHT_DETECTOR = get("daylight_detector");
    public static final Registry.Entry<BlockEntity.Type> HOPPER = get("hopper");
    public static final Registry.Entry<BlockEntity.Type> COMPARATOR = get("comparator");
    public static final Registry.Entry<BlockEntity.Type> BANNER = get("banner");
    public static final Registry.Entry<BlockEntity.Type> STRUCTURE_BLOCK = get("structure_block");
    public static final Registry.Entry<BlockEntity.Type> END_GATEWAY = get("end_gateway");
    public static final Registry.Entry<BlockEntity.Type> COMMAND_BLOCK = get("command_block");
    public static final Registry.Entry<BlockEntity.Type> SHULKER_BOX = get("shulker_box");
    public static final Registry.Entry<BlockEntity.Type> BED = get("bed");
    public static final Registry.Entry<BlockEntity.Type> CONDUIT = get("conduit");
    public static final Registry.Entry<BlockEntity.Type> BARREL = get("barrel");
    public static final Registry.Entry<BlockEntity.Type> SMOKER = get("smoker");
    public static final Registry.Entry<BlockEntity.Type> BLAST_FURNACE = get("blast_furnace");
    public static final Registry.Entry<BlockEntity.Type> LECTERN = get("lectern");
    public static final Registry.Entry<BlockEntity.Type> BELL = get("bell");
    public static final Registry.Entry<BlockEntity.Type> JIGSAW = get("jigsaw");
    public static final Registry.Entry<BlockEntity.Type> CAMPFIRE = get("campfire");
    public static final Registry.Entry<BlockEntity.Type> BEEHIVE = get("beehive");

    private static Registry.Entry<BlockEntity.Type> get(String type) {
        return BlockEntity.Type.REGISTRY.get(Identity.of("minecraft", type));
    }
}
