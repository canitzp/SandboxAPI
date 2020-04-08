package org.sandboxpowered.sandbox.api.content.resource;

import org.sandboxpowered.sandbox.api.block.Block;
import org.sandboxpowered.sandbox.api.item.Item;

import java.util.Map;
import java.util.function.Supplier;

public class ResourceRequest {
	private String resourceName;
	private Map<String, Supplier<Item>> items;
	private Map<String, Supplier<Block>> blocks;

	public ResourceRequest(String resourceName, Map<String, Supplier<Item>> items, Map<String, Supplier<Block>> blocks) {
		this.resourceName = resourceName;
		this.items = items;
		this.blocks = blocks;
	}

	public String getName() {
		return resourceName;
	}

	public Map<String, Supplier<Item>> getItems() {
		return items;
	}

	public Map<String, Supplier<Block>> getBlocks() {
		return blocks;
	}
}
