package org.sandboxpowered.api.status.potion;

import org.sandboxpowered.api.status.StatusEffectInstance;
import org.sandboxpowered.api.util.Mono;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class BasePotion implements Potion {
	private Mono<String> name;
	private List<StatusEffectInstance> effects;

	public BasePotion(StatusEffectInstance... effects) {
		this(Mono.empty(), effects);
	}

	public BasePotion(Mono<String> name, StatusEffectInstance... effects) {
		this(name, Arrays.asList(effects));
	}

	public BasePotion(Mono<String> name, List<StatusEffectInstance> effects) {
		this.name = name;
		this.effects = effects;
	}

	@Override
	public String getName(String itemName) {
		return itemName + (this.name.isPresent() ? this.name : Potion.REGISTRY.getIdentity(this).getPath());
	}

	@Override
	public List<StatusEffectInstance> getEffects() {
		return new ArrayList<>(effects);
	}

	@Override
	public boolean hasInstantEffect() {
		if (!this.effects.isEmpty()) {
			for (StatusEffectInstance effect : effects) {
				if (effect.getEffect().isInstant()) return true;
			}
		}

		return false;
	}
}
