package org.sandboxpowered.sandbox.api.content.resource;

import org.sandboxpowered.sandbox.api.block.Block;
import org.sandboxpowered.sandbox.api.item.BaseItem;
import org.sandboxpowered.sandbox.api.item.Item;

import java.util.*;
import java.util.function.Supplier;

public class ResourceBuilder {
	private final String resourceName;
	private Set<String> items = new HashSet<>();
	private Set<String> blocks = new HashSet<>();
	private Set<String> ores = new HashSet<>();
	private List<String> tools = new ArrayList<>(); //TODO: name to type
	private List<String> armor = new ArrayList<>(); //TODO: name to type
	private Map<String, Supplier<Item>> customItems = new HashMap<>();
	private Map<String, Supplier<Block>> customBlocks = new HashMap<>();
	// By default, assume this is a stone tier ore.
	private Supplier<Block> oreSupplier = BlockSuppliers.STONE_TIER_ORE;
	private Supplier<Block> blockSupplier = BlockSuppliers.METAL_BLOCK;

	public ResourceBuilder(String resourceName) {
		this.resourceName = resourceName;
	}

	public ResourceBuilder ofMetal() {
		return this.withIngot().withIngredients().withBlock();
	}

	public ResourceBuilder ofMachiningMetal() {
		return this.ofMetal().withMachineParts();
	}

	public ResourceBuilder ofGem() {
		return this.withBase().withBlock();
	}

	public ResourceBuilder blockSupplier(Supplier<Block> supplier) {
		blockSupplier = supplier;
		return this;
	}

	public ResourceBuilder oreSupplier(Supplier<Block> supplier) {
		oreSupplier = supplier;
		return this;
	}

	public ResourceBuilder withMachineParts() {
		return this.withGear().withPlate();
	}

	public ResourceBuilder withIngredients() {
		return this.withDust().withNugget();
	}
	public ResourceBuilder withAllOres() {
		return this.withOverworldOre().withNetherOre().withEndOre();
	}

	public ResourceBuilder withBase() {
		items.add("");
		return this;
	}

	public ResourceBuilder withIngot() {
		items.add("ingot");
		return this;
	}

	public ResourceBuilder withDust() {
		items.add("dust");
		return this;
	}

	public ResourceBuilder withNugget() {
		items.add("nugget");
		return this;
	}

	public ResourceBuilder withGear() {
		items.add("gear");
		return this;
	}

	public ResourceBuilder withPlate() {
		items.add("plate");
		return this;
	}

	//TODO: tools, armor

	public ResourceBuilder withCustomItem(String affix, Supplier<Item> supplier) {
		customItems.put(affix, supplier);
		return this;
	}

	public ResourceBuilder withBlock() {
		blocks.add("block");
		return this;
	}

	public ResourceBuilder withOverworldOre() {
		ores.add("_ore");
		return this;
	}

	public ResourceBuilder withNetherOre() {
		ores.add("_nether_ore");
		return this;
	}

	public ResourceBuilder withEndOre() {
		ores.add("_end_ore");
		return this;
	}

	public ResourceBuilder withCustomBlock(String affix, Supplier<Block> supplier) {
		customBlocks.put(affix, supplier);
		return this;
	}

	public ResourceBuilder withCustomBlock(String affix) {
		blocks.add(affix);
		return this;
	}

	public ResourceBuilder withCustomOre(String affix) {
		ores.add(affix);
		return this;
	}

	public ResourceRequest build() {
		Map<String, Supplier<Item>> itemSuppliers = new HashMap<>();
		Map<String, Supplier<Block>> blockSuppliers = new HashMap<>();
		for (String item : items) {
			itemSuppliers.put(item, () -> new BaseItem(new Item.Settings())); //TODO: item group
		}
		for (String block : blocks) {
			blockSuppliers.put(block, blockSupplier);
		}
		for (String ore : ores) {
			blockSuppliers.put(ore, oreSupplier);
		}
		itemSuppliers.putAll(customItems);
		blockSuppliers.putAll(customBlocks);
		return new ResourceRequest(resourceName, itemSuppliers, blockSuppliers);
	}

}
