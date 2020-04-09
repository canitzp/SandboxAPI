package org.sandboxpowered.api.status;

import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.LivingEntity;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.util.Mono;
import org.sandboxpowered.api.util.text.Text;

public interface StatusEffect extends Content<StatusEffect> {
	Registry<StatusEffect> REGISTRY = Registry.getRegistryFromType(StatusEffect.class);

	StatusEffectType getType();

	void applyUpdateEffect(LivingEntity entity, int amplifier);

	//TODO: double-check damage source to make sure the thrower and the potion are named right
	void applyInstantEffect(Mono<Entity> thrower, Mono<Entity> potion, LivingEntity target, int amplifier, double distance);

	boolean shouldApplyUpdateEffect(int ticksLeft, int amplifier);

	boolean isInstant();

	String getTranslationKey();

	default Text getName() {
		return Text.translatable(getTranslationKey());
	}

	int getColor();

	//TODO: implement entity attributes/EAMs in Sandbox, probably with components
//    StatusEffect addAttributeModifiers(EntityAttribute attribute, String name, double amount, EntityAttributeModifier.Operation operation);

//    Map<EntityAttribute, EntityAttributeModifier> getAttributeModifiers();

//    void removeAttributeModifiers(LivingEntity entity, EntityAttributeContainer attribContainer, int amplifier);

//    void addAttributeModifiers(LivingEntity entity, EntityAttributeContainer attribContainer, int amplifier);

//    double getAttribModifierAmount(int amplifier, EntitiyAttributeModifier eam);

	boolean isBeneficial();

	@Override
	default Class<StatusEffect> getContentType() {
		return StatusEffect.class;
	}
}
