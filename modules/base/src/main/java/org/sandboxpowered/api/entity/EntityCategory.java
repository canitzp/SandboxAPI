package org.sandboxpowered.api.entity;

import org.sandboxpowered.internal.InternalService;

public interface EntityCategory {
    EntityCategory MONSTER = get("MONSTER");
    EntityCategory CREATURE = get("CREATURE");
    EntityCategory AMBIENT = get("AMBIENT");
    EntityCategory WATER = get("WATER_CREATURE");
    EntityCategory MISCELLANEOUS = get("MISC");

    String getName();

    int getSpawnLimit();

    boolean isPeaceful();

    boolean isAnimal();

    int getRemoveRange();

    int getDespawnRange();
    
    static EntityCategory get(String name) {
        return InternalService.getInstance().getEntityCategory(name);
    }
}
