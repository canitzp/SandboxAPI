package org.sandboxpowered.api.util;

import org.jetbrains.annotations.Nullable;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.player.PlayerEntity;
import org.sandboxpowered.api.util.annotation.Alpha;
import org.sandboxpowered.internal.InternalService;

@Alpha
public interface DamageSource {
    DamageSource IN_FIRE = get("inFire");
    DamageSource LIGHTNING_BOLT = get("lightningBolt");
    DamageSource ON_FIRE = get("onFire");
    DamageSource LAVA = get("lava");
    DamageSource HOT_FLOOR = get("hotFloor");
    DamageSource IN_WALL = get("inWall");
    DamageSource CRAMMING = get("cramming");
    DamageSource DROWN = get("drown");
    DamageSource STARVE = get("starve");
    DamageSource CACTUS = get("cactus");
    DamageSource FALL = get("fall");
    DamageSource FLY_INTO_WALL = get("flyIntoWall");
    DamageSource OUT_OF_WORLD = get("outOfWorld");
    DamageSource GENERIC = get("generic");
    DamageSource MAGIC = get("magic");
    DamageSource WITHER = get("wither");
    DamageSource ANVIL = get("anvil");
    DamageSource FALLING_BLOCK = get("fallingBlock");
    DamageSource DRAGON_BREATH = get("dragonBreath");
    DamageSource FIREWORKS = get("fireworks");
    DamageSource DRYOUT = get("dryout");
    DamageSource SWEET_BERRY_BUSH = get("sweetBerryBush");

    @Nullable
    default Entity getCause() {
        return getAttacker();
    }

    @Nullable
    default Entity getAttacker() {
        return null;
    }

    default boolean isCreativePlayer() {
        Entity entity = getAttacker();
        return entity instanceof PlayerEntity && ((PlayerEntity) entity).isCreativeMode();
    }

    static DamageSource get(String name) {
        return InternalService.getInstance().getDamageSource(name);
    }
}
