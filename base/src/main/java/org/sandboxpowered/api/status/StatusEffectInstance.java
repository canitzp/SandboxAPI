package org.sandboxpowered.api.status;

import org.sandboxpowered.api.entity.LivingEntity;
import org.sandboxpowered.api.util.Functions;

public interface StatusEffectInstance extends Comparable<StatusEffectInstance> {
	static StatusEffectInstance of(StatusEffect effect, int duration, int amplifier) {
		return Functions.getInstance().createStatusEffectInstance(effect, duration, amplifier);
	}

	StatusEffect getEffect();

	int getDuration();

	//TODO: zero-index to keep in-line with vanilla code, or one-index to keep in-line with vanilla display?
	int getAmplifier();

	boolean isAmbient();

	boolean showParticles();

	boolean showIcon();

	boolean update(LivingEntity entity);

	void applyUpdateEffect(LivingEntity entity);

	String getTranslationKey();

	//TODO: impl vanilla's toString, equals, hashCode, compareTo overrides?

	//TODO: impl vanilla's serialization?

	void setPermanent(boolean permanet);

	boolean isPermanent();

}
