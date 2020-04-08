package org.sandboxpowered.sandbox.api.content.resource;


import org.sandboxpowered.sandbox.api.block.Block;
import org.sandboxpowered.sandbox.api.item.Item;

import java.util.*;
import java.util.function.Supplier;

public class ResourceType {
	private String baseName;
	private Map<String, Item> items = new HashMap<>();
	private Map<String, Block> blocks = new HashMap<>();
	private Map<String, Set<String>> addedItems = new HashMap<>();
	private Map<String, Set<String>> addedBlocks = new HashMap<>();

	public ResourceType(String baseName) {
		this.baseName = baseName;
	}

	/**
	 * Gets the base resource name. For example, "copper".
	 */
	String getBaseName() {
		return baseName;
	}

	/**
	 * Finds out whether this object takes responsibility for creating and registering the given block or item name.
	 * For instance, a resource with the domain "copper" will contain "copper_ingot" and "copper_block"; and a
	 * resource with the domain "mercury" will govern an item named "mercury".
	 */
	public boolean containsAny(String affix) {
		return items.containsKey(affix) || blocks.containsKey(affix);
	}

	public boolean containsItem(String affix) {
		return items.containsKey(affix);
	}

	public boolean containsBlock(String affix) {
		return blocks.containsKey(affix);
	}

	/**
	 * Returns the full name of the block/item for the given affix. For example, given "ore", returns "copper_ore",
	 * if this is a copper resource. If the affix is empty, only the base resource name is returned.
	 */
	public String getFullNameForAffix(String affix) {
		return affix.equals("") ? getBaseName() : getBaseName() + "_" + affix;
	}

	/**
	 * Gets the item (or BlockItem!) corresponding to this item name. If it's already defined, returns the
	 * already-defined one. If one is not registered, it returns Optional.empty();
	 * For example, if you want to get sandbox:copper_ingot, and baseResource is copper,
	 * you pass "ingot" in, since that is the affix.
	 */
	public Optional<Item> getItem(String itemName) {
		return Optional.ofNullable(items.get(itemName));
	}

	//TODO: should we do this better somehow? The mergability is the main reason we have to put everything here

	public Optional<Item> getBase() {
		 return getItem("Base");
	}

	public Optional<Item> getIngot() {
		 return getItem("Ingot");
	}

	public Optional<Item> getGear() {
		 return getItem("Gear");
	}

	public Optional<Item> getDust() {
		 return getItem("Dust");
	}

	public Optional<Item> getNugget() {
		 return getItem("Nugget");
	}

	public Optional<Item> getPlate() {
		 return getItem("Plate");
	}

	public Optional<Item> getPickaxe() {
		 return getItem("pickaxe");
	}

	public Optional<Item> getAxe() {
		 return getItem("axe");
	}

	public Optional<Item> getShovel() {
		 return getItem("shovel");
	}

	public Optional<Item> getHoe() {
		 return getItem("hoe");
	}

	public Optional<Item> getSword() {
		 return getItem("sword");
	}

	public Optional<Item> getHelmet() {
		 return getItem("helmet");
	}

	public Optional<Item> getChestplate() {
		 return getItem("chestplate");
	}

	public Optional<Item> getLeggings() {
		 return getItem("leggings");
	}

	public Optional<Item> getBoots() {
		 return getItem("boots");
	}

	/**
	 * Gets the block corresponding to this block name. If it's already defined, returns the already-defined one. If
	 * it's a builtin, registers and returns the builtin. Only if it's neither registered nor builtin is null returned.
	 * For example, if you want to get cotton:copper_ore, and baseResource is copper,
	 * * you pass "ore" in, since that is the affix.
	 */
	Optional<Block> getBlock(String blockName) {
		return Optional.ofNullable(blocks.get(blockName));
	}

	public Optional<Block> getBlock() {
		return getBlock("block");
	}

	public Optional<Block> getOre() {
		return getBlock("ore");
	}

	public Optional<Block> getNetherOre() {
		return getBlock("nether_ore");
	}

	public Optional<Block> getEndOre() {
		return getBlock("end_ore");
	}
	
	public Collection<String> getAllNames() {
		Set<String> ret = new HashSet<>();
		ret.addAll(items.keySet());
		ret.addAll(blocks.keySet());
		return ret;
	}

	/**
	 * Gets the affixes of all currently registered items for this resource.
	 *
	 * @return a collection of item name affixes which are guaranteed to be known for the purposes of contains and getItem
	 */
	public Collection<String> getItemNames() {
		return items.keySet();
	}

	/**
	 * Gets the affixes of all currently registered items for this resource.
	 *
	 * @return a collection of block name affixes which are guaranteed to be known for the purposes of contains and getBlock
	 */
	public Collection<String> getBlockNames() {
		return blocks.keySet();
	}

	/**
	 * Processes a request for new resource types, registering any that don't yet exist.
	 * @param request The requested resources to add.
	 * TODO: preference config to select a specific mod register
	 */
	public void append(String source, ResourceRequest request) {
		Map<String, Supplier<Item>> requestedItems = request.getItems();
		Map<String, Supplier<Block>> requestedBlocks = request.getBlocks();
		Set<String> registeredItems = new HashSet<>();
		Set<String> registeredBlocks = new HashSet<>();
		for (String key : request.getItems().keySet()) {
			if (!containsItem(key)) {
				items.put(key, requestedItems.get(key).get());
				registeredItems.add(key);
			}
		}
		for (String key : request.getBlocks().keySet()) {
			if (!containsBlock(key)) {
				blocks.put(key, requestedBlocks.get(key).get());
				registeredBlocks.add(key);
			}
		}
		addedItems.put(source, registeredItems);
		addedBlocks.put(source, registeredBlocks);
	}

	public String getItemSource(String affix) {
		for (String id : addedItems.keySet()) {
			if (addedItems.get(id).contains(affix)) return id;
		}
		return "";
	}

	public String getBlockSource(String affix) {
		for (String id : addedBlocks.keySet()) {
			if (addedBlocks.get(id).contains(affix)) return id;
		}
		return "";
	}
}
