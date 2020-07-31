package org.sandboxpowered.api.entity;

import org.sandboxpowered.internal.InternalService;

public class MobCategory {
    public static final MobCategory MONSTER = get("MONSTER");
    public static final MobCategory CREATURE = get("CREATURE");
    public static final MobCategory AMBIENT = get("AMBIENT");
    public static final MobCategory WATER = get("WATER_CREATURE");
    public static final MobCategory MISCELLANEOUS = get("MISC");

    private final int spawnLimit;
    private final boolean isPeaceful;
    private final boolean isAnimal;
    private final String name;

    public MobCategory(String name, int spawnLimit, boolean isPeaceful, boolean isAnimal) {
        this.name = name;
        this.spawnLimit = spawnLimit;
        this.isPeaceful = isPeaceful;
        this.isAnimal = isAnimal;
    }

    public String getName() {
        return this.name;
    }

    public int getSpawnLimit() {
        return this.spawnLimit;
    }

    public boolean isPeaceful() {
        return this.isPeaceful;
    }

    public boolean isAnimal() {
        return this.isAnimal;
    }
    
    private static MobCategory get(String name) {
        return InternalService.getInstance().getEntityCategory(name);
    }
}
