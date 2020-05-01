package org.sandboxpowered.api.resources;

import java.util.Objects;

public final class ResourceType {
    public static final ResourceType BASE = new ResourceType("");
    //item affixes
    public static final ResourceType INGOT = new ResourceType("ingot");
    public static final ResourceType NUGGET = new ResourceType("nugget");
    public static final ResourceType DUST = new ResourceType("dust");
    public static final ResourceType GEAR = new ResourceType("gear");
    public static final ResourceType PLATE = new ResourceType("plate");
    public static final ResourceType PICKAXE = new ResourceType("pickaxe");
    public static final ResourceType AXE = new ResourceType("axe");
    public static final ResourceType SHOVEL = new ResourceType("shovel");
    public static final ResourceType HOE = new ResourceType("hoe");
    public static final ResourceType SWORD = new ResourceType("sword");
    public static final ResourceType HELMET = new ResourceType("helmet");
    public static final ResourceType CHESTPLATE = new ResourceType("chestplate");
    public static final ResourceType LEGGINGS = new ResourceType("leggings");
    public static final ResourceType BOOTS = new ResourceType("boots");
    public static final ResourceType HORSE_ARMOR = new ResourceType("horse_armor");
    //block affixes
    public static final ResourceType BLOCK = new ResourceType("block");
    public static final ResourceType ORE = new ResourceType("ore");
    public static final ResourceType NETHER_ORE = new ResourceType("nether", "ore");
    public static final ResourceType END_ORE = new ResourceType("end", "ore");
    //fluid affixes
    public static final ResourceType MOLTEN = new ResourceType("molten", "");
    public static final ResourceType MOLTEN_FLOWING = new ResourceType("molten_flowing", "");

    private final String prefix;
    private final String suffix;

    public ResourceType(String prefix, String suffix) {
        this.prefix = prefix;
        this.suffix = suffix;
    }

    public ResourceType(String suffix) {
        this.prefix = "";
        this.suffix = suffix;
    }

    public String getPrefix() {
        return prefix;
    }

    public String getSuffix() {
        return suffix;
    }

    public String getFullName(String baseName) {
        StringBuilder builder = new StringBuilder();
        if (!getPrefix().equals("")) builder.append(getPrefix()).append("_");
        builder.append(baseName);
        if (!getSuffix().equals("")) builder.append("_").append(getSuffix());
        return builder.toString();
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ResourceType that = (ResourceType) o;
        return Objects.equals(prefix, that.prefix) &&
                Objects.equals(suffix, that.suffix);
    }

    @Override
    public int hashCode() {
        return Objects.hash(prefix, suffix);
    }

    @Override
    public String toString() {
        return "ResourceType{" +
                "prefix='" + prefix + '\'' +
                ", suffix='" + suffix + '\'' +
                '}';
    }
}
