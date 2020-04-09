package org.sandboxpowered.api.status.potion;

import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.status.StatusEffectInstance;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.Mono;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.function.Function;

public class PotionSet {
	private Identity baseId;
	private Potion base;
	private PotionTypes types;
	private Map<String, Potion> otherPotions = new HashMap<>();

	public PotionSet(Identity baseId, Potion base) {
		this(baseId, base, PotionTypes.NONE);
	}

	public PotionSet(Identity baseId, Potion base, PotionTypes types) {
		this.baseId = baseId;
		this.base = base;
		this.types = types;
		init();
	}

	public static PotionSet ofVanilla(Potion vanillaBase) {
		Identity id = Potion.REGISTRY.getIdentity(vanillaBase);
		return new PotionSet(vanillaBase,
				Potion.REGISTRY.get(Identity.of("minecraft", "long_" + id.getPath())),
				Potion.REGISTRY.get(Identity.of("minecraft", "long_" + id.getPath())));
	}

	private PotionSet(Potion base, Registry.Entry<Potion> longPot, Registry.Entry<Potion> strongPot) {
		this.base = base;
		Map<String, Potion> others = new HashMap<>();
		if (longPot.isPresent()) others.put("long", longPot.get());
		if (strongPot.isPresent()) others.put("strong", strongPot.get());
		this.otherPotions = others;
	}

	public Potion getBasePotion() {
		return base;
	}

	public Mono<Potion> getPotionFor(String modifier) {
		return Mono.ofNullable(otherPotions.get(modifier));
	}

	public List<Potion> getAllPotions() {
		List<Potion> all = new ArrayList<>();
		all.add(base);
		for (String key : otherPotions.keySet()) {
			all.add(otherPotions.get(key));
		}
		return all;
	}

	private void init() {
		//so that we don't need to hack potion brewing to bits
		for (String key : types.getTypes().keySet()) {
			Function<StatusEffectInstance, StatusEffectInstance> transformer = types.getTypes().get(key);
			Identity newId = Identity.of(baseId.getNamespace(), key + "_" + baseId.getPath());
			List<StatusEffectInstance> potEffects = new ArrayList<>();
			for (StatusEffectInstance effect : base.getEffects()) {
				potEffects.add(transformer.apply(effect));
			}
			Potion newPot = new BasePotion(Mono.of(base.getName("")), potEffects);
			Potion.REGISTRY.register(newId, newPot);
			otherPotions.put(key, newPot);
		}
	}

	@FunctionalInterface
	public interface PotionTypes {
		Map<String, Function<StatusEffectInstance, StatusEffectInstance>> getTypes();

		PotionTypes NONE = HashMap::new;
		PotionTypes LONG = () -> {
			Map<String, Function<StatusEffectInstance, StatusEffectInstance>> ret = new HashMap<>();
			ret.put("long", (effect) -> {
				if (effect.getEffect().isInstant()) throw new IllegalArgumentException("Cannot have a long form of an instant potion!");
				//TODO: try to figure out a way this can round to the nearest hundred, maybe?
				int newDur = (int)Math.ceil(effect.getDuration() * 2.667);
				return StatusEffectInstance.of(effect.getEffect(), newDur, effect.getAmplifier());
			});
			return ret;
		};
		PotionTypes STRONG = () -> {
			Map<String, Function<StatusEffectInstance, StatusEffectInstance>> ret = new HashMap<>();
			ret.put("strong", (effect) -> {
				//TODO: this isn't actually standard in vanilla, how should we deal with that?
				int newDur = effect.getDuration() / 2;
				return StatusEffectInstance.of(effect.getEffect(), newDur, effect.getAmplifier() + 1);
			});
			return ret;
		};
		PotionTypes LONG_AND_STRONG = () -> {
			Map<String, Function<StatusEffectInstance, StatusEffectInstance>> ret = new HashMap<>();
			ret.put("long", (effect) -> {
				if (effect.getEffect().isInstant()) throw new IllegalArgumentException("Cannot have a long form of an instant potion!");
				//TODO: try to figure out a way this can round to the nearest hundred, maybe?
				int newDur = (int)Math.floor(effect.getDuration() * 2.667);
				return StatusEffectInstance.of(effect.getEffect(), newDur, effect.getAmplifier());
			});
			ret.put("strong", (effect) -> {
				//TODO: this isn't actually standard in vanilla, how should we deal with that?
				int newDur = effect.getDuration() / 2;
				return StatusEffectInstance.of(effect.getEffect(), newDur, effect.getAmplifier() + 1);
			});
			return ret;
		};

	}
}
