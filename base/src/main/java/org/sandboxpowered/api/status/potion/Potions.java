package org.sandboxpowered.api.status.potion;

import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Identity;

public class Potions {

	public static final Registry.Entry<Potion> EMPTY = get("empty");
	public static final Registry.Entry<Potion> WATER = get("water");
	public static final Registry.Entry<Potion> MUNDANE = get("mundane");
	public static final Registry.Entry<Potion> THICK = get("thick");
	public static final Registry.Entry<Potion> AWKWARD = get("awkward");
	//TODO: should we provide these as <POTION_NAME>_SET and have access to the individual objects too?
	public static final PotionSet NIGHT_VISION = getSet("night_vision");
	public static final PotionSet INVISIBILITY = getSet("invisibility");
	public static final PotionSet LEAPING = getSet("leaping");
	public static final PotionSet FIRE_RESISTANCE = getSet("fire_resistance");
	public static final PotionSet SWIFTNESS = getSet("swiftness");
	public static final PotionSet SLOWNESS = getSet("slowness");
	public static final PotionSet TURTLE_MASTER = getSet("turtle_master");
	public static final PotionSet WATER_BREATHING = getSet("water_breathing");
	public static final PotionSet HEALING = getSet("healing");
	public static final PotionSet HARMING = getSet("harming");
	public static final PotionSet POISON = getSet("poison");
	public static final PotionSet REGENERATION = getSet("regeneration");
	public static final PotionSet STRENGTH = getSet("strength");
	public static final PotionSet WEAKNESS = getSet("weakness");
	public static final Registry.Entry<Potion> LUCK = get("luck"); //TODO: should be this be a Registry.Entry<Potion> or a PotionSet? There's no long/strong variants...
	public static final PotionSet SLOW_FALLING = getSet("slow_falling");

	private static Registry.Entry<Potion> get(String name) {
		return Potion.REGISTRY.get(Identity.of("minecraft", name));
	}

	private static PotionSet getSet(String name) {
		return PotionSet.ofVanilla(Potion.REGISTRY.get(Identity.of("minecraft", name)).get());
	}

}