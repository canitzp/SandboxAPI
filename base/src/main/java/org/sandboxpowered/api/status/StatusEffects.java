package org.sandboxpowered.api.status;

import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Functions;
import org.sandboxpowered.api.util.Identity;

public class StatusEffects {
	public static final Registry.Entry<StatusEffect> SPEED = get("speed");
	public static final Registry.Entry<StatusEffect> SLOWNESS = get("slowness");
	public static final Registry.Entry<StatusEffect> HASTE = get("haste");
	public static final Registry.Entry<StatusEffect> MINING_FATIGUE = get("mining_fatigue");
	public static final Registry.Entry<StatusEffect> STRENGTH = get("strength");
	public static final Registry.Entry<StatusEffect> INSTANT_HEALTH = get("instant_health");
	public static final Registry.Entry<StatusEffect> INSTANT_DAMAGE = get("instant_damage");
	public static final Registry.Entry<StatusEffect> JUMP_BOOST = get("jump_boost");
	public static final Registry.Entry<StatusEffect> NAUSEA = get("nausea");
	public static final Registry.Entry<StatusEffect> REGENERATION = get("regeneration");
	public static final Registry.Entry<StatusEffect> RESISTANCE = get("resistance");
	public static final Registry.Entry<StatusEffect> FIRE_RESISTANCE = get("fire_resistance");
	public static final Registry.Entry<StatusEffect> WATER_BREATHING = get("water_breathing");
	public static final Registry.Entry<StatusEffect> INVISIBILITY = get("invisibility");
	public static final Registry.Entry<StatusEffect> BLINDNESS = get("blindness");
	public static final Registry.Entry<StatusEffect> NIGHT_VISION = get("night_vision");
	public static final Registry.Entry<StatusEffect> HUNGER = get("hunger");
	public static final Registry.Entry<StatusEffect> WEAKNESS = get("weakness");
	public static final Registry.Entry<StatusEffect> POISON = get("poison");
	public static final Registry.Entry<StatusEffect> WITHER = get("wither");
	public static final Registry.Entry<StatusEffect> HEALTH_BOOST = get("health_boost");
	public static final Registry.Entry<StatusEffect> ABSORPTION = get("absorption");
	public static final Registry.Entry<StatusEffect> SATURATION = get("saturation");
	public static final Registry.Entry<StatusEffect> GLOWING = get("glowing");
	public static final Registry.Entry<StatusEffect> LEVITATION = get("levitation");
	public static final Registry.Entry<StatusEffect> LUCK = get("luck");
	public static final Registry.Entry<StatusEffect> UNLUCK = get("unluck");
	public static final Registry.Entry<StatusEffect> SLOW_FALLING = get("slow_falling");
	public static final Registry.Entry<StatusEffect> CONDUIT_POWER = get("conduit_power");
	public static final Registry.Entry<StatusEffect> DOLPHINS_GRACE = get("dolphins_grace");
	public static final Registry.Entry<StatusEffect> BAD_OMEN = get("bad_omen");
	public static final Registry.Entry<StatusEffect> HERO_OF_THE_VILLAGE = get("hero_of_the_village");

	private static Registry.Entry<StatusEffect> get(String name) {
		return StatusEffect.REGISTRY.get(Identity.of("minecraft", name));
	}
}
