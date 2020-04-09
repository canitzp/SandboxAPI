package org.sandboxpowered.api.content.resource;

import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.content.resource.supplier.BlockSuppliers;
import org.sandboxpowered.api.content.resource.supplier.FluidSuppliers;
import org.sandboxpowered.api.fluid.Fluid;
import org.sandboxpowered.api.item.BaseItem;
import org.sandboxpowered.api.item.Item;

import java.util.*;
import java.util.function.Supplier;

public final class ResourceBuilder {
	private String resourceName;
	private Set<ResourceType> items = new HashSet<>();
	private Set<ResourceType> blocks = new HashSet<>();
	private Set<ResourceType> ores = new HashSet<>();
	private Set<ResourceType> fluids = new HashSet<>();
	private List<ResourceType> tools = new ArrayList<>(); //TODO: name to type
	private List<ResourceType> armor = new ArrayList<>(); //TODO: name to type
	private Map<ResourceType, Supplier<Item>> customItems = new HashMap<>();
	private Map<ResourceType, Supplier<Block>> customBlocks = new HashMap<>();
	private Map<ResourceType, Supplier<Fluid>> customFluids = new HashMap<>();
	// By default, assume this is a stone tier ore.
	private Supplier<Block> blockSupplier = BlockSuppliers.METAL_BLOCK;
	private Supplier<Block> oreSupplier = BlockSuppliers.STONE_TIER_ORE;
	private Supplier<Fluid> fluidSupplier = FluidSuppliers.VIRTUAL_FLUID;

	private ResourceBuilder(String resourceName) {
		this.resourceName = resourceName;
	}

	public static ResourceBuilder of(String resourceName) {
		return new ResourceBuilder(resourceName);
	}

	public static ResourceBuilder ofMetal(String resourceName) {
		return new ResourceBuilder(resourceName).withIngot().withIngredients().withBlock();
	}

	public static ResourceBuilder ofMachiningMetal(String resourceName) {
		return ofMetal(resourceName).withMachineParts();
	}

	public static ResourceBuilder ofGem(String resourceName) {
		return new ResourceBuilder(resourceName).withBaseItem().withBlock();
	}

	public static ResourceBuilder ofBlock(String resourceName, Supplier<Block> supplier) {
		return new ResourceBuilder(resourceName).withBlockSupplier(supplier).withBlock();
	}

	public static ResourceBuilder ofFluid(String resourceName, Supplier<Fluid> supplier) {
		return new ResourceBuilder(resourceName).withFluidSupplier(supplier).withBaseFluid();
	}

	public ResourceBuilder withBlockSupplier(Supplier<Block> supplier) {
		blockSupplier = supplier;
		return this;
	}

	public ResourceBuilder withOreSupplier(Supplier<Block> supplier) {
		oreSupplier = supplier;
		return this;
	}

	public ResourceBuilder withFluidSupplier(Supplier<Fluid> supplier) {
		fluidSupplier = supplier;
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

	public ResourceBuilder withBaseItem() {
		items.add(ResourceType.BASE);
		return this;
	}

	public ResourceBuilder withIngot() {
		items.add(ResourceType.INGOT);
		return this;
	}

	public ResourceBuilder withDust() {
		items.add(ResourceType.DUST);
		return this;
	}

	public ResourceBuilder withNugget() {
		items.add(ResourceType.NUGGET);
		return this;
	}

	public ResourceBuilder withGear() {
		items.add(ResourceType.GEAR);
		return this;
	}

	public ResourceBuilder withPlate() {
		items.add(ResourceType.PLATE);
		return this;
	}

	//TODO: tools, armor

	public ResourceBuilder withCustomItem(ResourceType type, Supplier<Item> supplier) {
		customItems.put(type, supplier);
		return this;
	}

	public ResourceBuilder withBaseBlock() {
		blocks.add(ResourceType.BASE);
		return this;
	}

	public ResourceBuilder withBlock() {
		blocks.add(ResourceType.BLOCK);
		return this;
	}

	public ResourceBuilder withOverworldOre() {
		ores.add(ResourceType.ORE);
		return this;
	}

	public ResourceBuilder withNetherOre() {
		ores.add(ResourceType.NETHER_ORE);
		return this;
	}

	public ResourceBuilder withEndOre() {
		ores.add(ResourceType.END_ORE);
		return this;
	}

	public ResourceBuilder withCustomBlock(ResourceType type, Supplier<Block> supplier) {
		customBlocks.put(type, supplier);
		return this;
	}

	public ResourceBuilder withCustomBlock(ResourceType type) {
		blocks.add(type);
		return this;
	}

	public ResourceBuilder withCustomOre(ResourceType type) {
		ores.add(type);
		return this;
	}

	public ResourceBuilder withBaseFluid() {
		fluids.add(ResourceType.BASE);
		return this;
	}

	public ResourceBuilder withCustomFluid(ResourceType type, Supplier<Fluid> supplier) {
		customFluids.put(type, supplier);
		return this;
	}

	public ResourceRequest build() {
		Map<ResourceType, Supplier<Item>> itemSuppliers = new HashMap<>();
		Map<ResourceType, Supplier<Block>> blockSuppliers = new HashMap<>();
		Map<ResourceType, Supplier<Fluid>> fluidSuppliers = new HashMap<>();
		for (ResourceType item : items) {
			itemSuppliers.put(item, () -> new BaseItem(new Item.Settings())); //TODO: item group
		}
		for (ResourceType block : blocks) {
			blockSuppliers.put(block, blockSupplier);
		}
		for (ResourceType ore : ores) {
			blockSuppliers.put(ore, oreSupplier);
		}
		for (ResourceType fluid : fluids) {
			fluidSuppliers.put(fluid, fluidSupplier);
		}
		itemSuppliers.putAll(customItems);
		blockSuppliers.putAll(customBlocks);
		fluidSuppliers.putAll(customFluids);
		return new ResourceRequest(resourceName, itemSuppliers, blockSuppliers, fluidSuppliers);
	}

}
