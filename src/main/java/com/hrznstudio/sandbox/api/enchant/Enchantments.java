package com.hrznstudio.sandbox.api.enchant;

import com.hrznstudio.sandbox.api.util.Functions;

public class Enchantments {
    public static final IEnchantment PROTECTION = get("protection");
    public static final IEnchantment FIRE_PROTECTION = get("fire_protection");
    public static final IEnchantment FEATHER_FALLING = get("feather_falling");
    public static final IEnchantment BLAST_PROTECTION = get("blast_protection");
    public static final IEnchantment PROJECTILE_PROTECTION = get("projectile_protection");
    public static final IEnchantment RESPIRATION = get("respiration");
    public static final IEnchantment AQUA_AFFINITY = get("aqua_affinity");
    public static final IEnchantment THORNS = get("thorns");
    public static final IEnchantment DEPTH_STRIDER = get("depth_strider");
    public static final IEnchantment FROST_WALKER = get("frost_walker");
    public static final IEnchantment BINDING_CURSE = get("binding_curse");
    public static final IEnchantment SHARPNESS = get("sharpness");
    public static final IEnchantment SMITE = get("smite");
    public static final IEnchantment BANE_OF_ARTHROPODS = get("bane_of_arthropods");
    public static final IEnchantment KNOCKBACK = get("knockback");
    public static final IEnchantment FIRE_ASPECT = get("fire_aspect");
    public static final IEnchantment LOOTING = get("looting");
    public static final IEnchantment SWEEPING = get("sweeping");
    public static final IEnchantment EFFICIENCY = get("efficiency");
    public static final IEnchantment SILK_TOUCH = get("silk_touch");
    public static final IEnchantment UNBREAKING = get("unbreaking");
    public static final IEnchantment FORTUNE = get("fortune");
    public static final IEnchantment POWER = get("power");
    public static final IEnchantment PUNCH = get("punch");
    public static final IEnchantment FLAME = get("flame");
    public static final IEnchantment INFINITY = get("infinity");
    public static final IEnchantment LUCK_OF_THE_SEA = get("luck_of_the_sea");
    public static final IEnchantment LURE = get("lure");
    public static final IEnchantment LOYALTY = get("loyalty");
    public static final IEnchantment IMPALING = get("impaling");
    public static final IEnchantment RIPTIDE = get("riptide");
    public static final IEnchantment CHANNELING = get("channeling");
    public static final IEnchantment MULTISHOT = get("multishot");
    public static final IEnchantment QUICK_CHARGE = get("quick_charge");
    public static final IEnchantment PIERCING = get("piercing");
    public static final IEnchantment MENDING = get("mending");
    public static final IEnchantment VANISHING_CURSE = get("vanishing_curse");

    public static IEnchantment get(String s) {
        IEnchantment e = Functions.enchantmentFunction.apply(s);
        if(e ==null)
            throw new RuntimeException("Unknown IEnchantment " + s);
            return e;
    }
}
