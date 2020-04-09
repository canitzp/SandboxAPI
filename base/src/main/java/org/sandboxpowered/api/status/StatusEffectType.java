package org.sandboxpowered.api.status;

import org.sandboxpowered.api.util.Functions;

public interface StatusEffectType {
	//TODO: need text formatting implemented to properly mirror vanilla status effect type
	StatusEffectType BENEFICIAL = getEffectType("beneficial");
	StatusEffectType NEUTRAL = getEffectType("neutral");
	StatusEffectType HARMFUL = getEffectType("harmful");


	static StatusEffectType getEffectType(String type) {
		return Functions.getInstance().createStatusEffectType(type);
	}
}
