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
		return new ResourceBuilder(resourceName).withItem(ResourceType.INGOT).withIngredients().withBlock(ResourceType.BLOCK);
	}

	public static ResourceBuilder ofMetal(String resourceName, Supplier<Block> blockSupplier, Supplier<Block> oreSupplier) {
		return ofMetal(resourceName).withBlockSupplier(blockSupplier).withOreSupplier(oreSupplier);
	}

	public static ResourceBuilder ofMachiningMetal(String resourceName) {
		return ofMetal(resourceName).withMachineParts();
	}

	public static ResourceBuilder ofMachiningMetal(String resourceName, Supplier<Block> blockSupplier, Supplier<Block> oreSupplier) {
		return ofMachiningMetal(resourceName).withBlockSupplier(blockSupplier).withOreSupplier(oreSupplier);
	}

	public static ResourceBuilder ofGem(String resourceName) {
		return new ResourceBuilder(resourceName).withItem(ResourceType.BASE).withBlock(ResourceType.BLOCK);
	}

	public static ResourceBuilder ofGem(String resourceName, Supplier<Block> blockSupplier, Supplier<Block> oreSupplier) {
		return ofGem(resourceName).withBlock(ResourceType.BLOCK).withBlockSupplier(blockSupplier).withOreSupplier(oreSupplier);
	}

	public static ResourceBuilder ofBlock(String resourceName, Supplier<Block> supplier) {
		return new ResourceBuilder(resourceName).withBlockSupplier(supplier).withBlock(ResourceType.BLOCK);
	}

	public static ResourceBuilder ofFluid(String resourceName, Supplier<Fluid> supplier) {
		return new ResourceBuilder(resourceName).withFluidSupplier(supplier).withFluid(ResourceType.BASE);
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
		return this.withItem(ResourceType.GEAR).withItem(ResourceType.PLATE);
	}

	public ResourceBuilder withIngredients() {
		return this.withItem(ResourceType.DUST).withItem(ResourceType.NUGGET);
	}

	public ResourceBuilder withAllOres() {
		return this.withOre(ResourceType.ORE).withOre(ResourceType.NETHER_ORE).withOre(ResourceType.END_ORE);
	}

	//TODO: tools, armor

	public ResourceBuilder withItem(ResourceType type) {
		items.add(type);
		return this;
	}

	public ResourceBuilder withItem(ResourceType type, Supplier<Item> supplier) {
		customItems.put(type, supplier);
		return this;
	}


	public ResourceBuilder withBlock(ResourceType type) {
		blocks.add(type);
		return this;
	}

	public ResourceBuilder withOre(ResourceType type) {
		ores.add(type);
		return this;
	}

	public ResourceBuilder withBlock(ResourceType type, Supplier<Block> supplier) {
		customBlocks.put(type, supplier);
		return this;
	}

	public ResourceBuilder withFluid(ResourceType type) {
		fluids.add(type);
		return this;
	}

	public ResourceBuilder withFluid(ResourceType type, Supplier<Fluid> supplier) {
		customFluids.put(type, supplier);
		return this;
	}

	public ResourceRequest build() {
		Map<ResourceType, Supplier<Item>> itemSuppliers = new HashMap<>();
		Map<ResourceType, Supplier<Block>> blockSuppliers = new HashMap<>();
		Map<ResourceType, Supplier<Fluid>> fluidSuppliers = new HashMap<>();
		for (ResourceType item : items) {
			itemSuppliers.put(item, () -> new BaseItem(new Item.Settings())); //TODO: item group?
		}
		for (ResourceType block : blocks) {
			blockSuppliers.put(block, blockSupplier); //TODO: block items?
		}
		for (ResourceType ore : ores) {
			blockSuppliers.put(ore, oreSupplier); //TODO: block items?
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