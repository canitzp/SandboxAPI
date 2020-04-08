package org.sandboxpowered.api.enchantment;

import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Identity;

public class Enchantments {
    public static final Registry.Entry<Enchantment> PROTECTION = get("protection");
    public static final Registry.Entry<Enchantment> FIRE_PROTECTION = get("fire_protection");
    public static final Registry.Entry<Enchantment> FEATHER_FALLING = get("feather_falling");
    public static final Registry.Entry<Enchantment> BLAST_PROTECTION = get("blast_protection");
    public static final Registry.Entry<Enchantment> PROJECTILE_PROTECTION = get("projectile_protection");
    public static final Registry.Entry<Enchantment> RESPIRATION = get("respiration");
    public static final Registry.Entry<Enchantment> AQUA_AFFINITY = get("aqua_affinity");
    public static final Registry.Entry<Enchantment> THORNS = get("thorns");
    public static final Registry.Entry<Enchantment> DEPTH_STRIDER = get("depth_strider");
    public static final Registry.Entry<Enchantment> FROST_WALKER = get("frost_walker");
    public static final Registry.Entry<Enchantment> BINDING_CURSE = get("binding_curse");
    public static final Registry.Entry<Enchantment> SHARPNESS = get("sharpness");
    public static final Registry.Entry<Enchantment> SMITE = get("smite");
    public static final Registry.Entry<Enchantment> BANE_OF_ARTHROPODS = get("bane_of_arthropods");
    public static final Registry.Entry<Enchantment> KNOCKBACK = get("knockback");
    public static final Registry.Entry<Enchantment> FIRE_ASPECT = get("fire_aspect");
    public static final Registry.Entry<Enchantment> LOOTING = get("looting");
    public static final Registry.Entry<Enchantment> SWEEPING = get("sweeping");
    public static final Registry.Entry<Enchantment> EFFICIENCY = get("efficiency");
    public static final Registry.Entry<Enchantment> SILK_TOUCH = get("silk_touch");
    public static final Registry.Entry<Enchantment> UNBREAKING = get("unbreaking");
    public static final Registry.Entry<Enchantment> FORTUNE = get("fortune");
    public static final Registry.Entry<Enchantment> POWER = get("power");
    public static final Registry.Entry<Enchantment> PUNCH = get("punch");
    public static final Registry.Entry<Enchantment> FLAME = get("flame");
    public static final Registry.Entry<Enchantment> INFINITY = get("infinity");
    public static final Registry.Entry<Enchantment> LUCK_OF_THE_SEA = get("luck_of_the_sea");
    public static final Registry.Entry<Enchantment> LURE = get("lure");
    public static final Registry.Entry<Enchantment> LOYALTY = get("loyalty");
    public static final Registry.Entry<Enchantment> IMPALING = get("impaling");
    public static final Registry.Entry<Enchantment> RIPTIDE = get("riptide");
    public static final Registry.Entry<Enchantment> CHANNELING = get("channeling");
    public static final Registry.Entry<Enchantment> MULTISHOT = get("multishot");
    public static final Registry.Entry<Enchantment> QUICK_CHARGE = get("quick_charge");
    public static final Registry.Entry<Enchantment> PIERCING = get("piercing");
    public static final Registry.Entry<Enchantment> MENDING = get("mending");
    public static final Registry.Entry<Enchantment> VANISHING_CURSE = get("vanishing_curse");

    private static Registry.Entry<Enchantment> get(String s) {
        return Enchantment.REGISTRY.get(Identity.of("minecraft", s));
    }
}
