package org.sandboxpowered.api.util;

//TODO: methods for obtaining
public interface ObjectInteractionResult<T> {
	static <T> ObjectInteractionResult<T> of(T object, InteractionResult result) {
		throw new UnsupportedOperationException("Not yet implemented!");
	}
	T getObject();
	InteractionResult getResult();
}
