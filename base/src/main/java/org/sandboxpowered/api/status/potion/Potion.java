package org.sandboxpowered.api.status.potion;

import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.status.StatusEffectInstance;

import java.util.List;

public interface Potion extends Content<Potion> {
	Registry<Potion> REGISTRY = Registry.getRegistryFromType(Potion.class);

	String getName(String itemName);

	List<StatusEffectInstance> getEffects();

	boolean hasInstantEffect();

	@Override
	default Class<Potion> getContentType() {
		return Potion.class;
	}
}
