package org.sandboxpowered.api.entity;

public enum MobCategory {
    MONSTER("monster", 70, false, false),
    CREATURE("creature", 10, true, true),
    AMBIENT("ambient", 15, true, false),
    WATER_CREATURE("water_creature", 15, true, false),
    MISC("misc", 15, true, false);

    private final int spawnCap;
    private final boolean peaceful;
    private final boolean animal;
    private final String name;

    private MobCategory(String name, int spawnCap, boolean peaceful, boolean animal) {
        this.name = name;
        this.spawnCap = spawnCap;
        this.peaceful = peaceful;
        this.animal = animal;
    }

    public String getName() {
        return this.name;
    }

    public int getSpawnCap() {
        return this.spawnCap;
    }

    public boolean isPeaceful() {
        return this.peaceful;
    }

    public boolean isAnimal() {
        return this.animal;
    }
}
