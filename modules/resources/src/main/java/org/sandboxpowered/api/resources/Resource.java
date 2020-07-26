package org.sandboxpowered.api.resources;


import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.fluid.Fluid;
import org.sandboxpowered.api.item.Item;

import java.util.*;
import java.util.function.Consumer;
import java.util.function.Supplier;

public class Resource {
    private final String baseName;
    protected Map<ResourceType, Item> items = new HashMap<>();
    protected Map<ResourceType, Block> blocks = new HashMap<>();
    protected Map<ResourceType, Fluid> fluids = new HashMap<>();
    protected Map<String, Set<ResourceType>> addedItems = new HashMap<>();
    protected Map<String, Set<ResourceType>> addedBlocks = new HashMap<>();
    protected Map<String, Set<ResourceType>> addedFluids = new HashMap<>();

    public Resource(String baseName) {
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
    public boolean containsAny(ResourceType type) {
        return items.containsKey(type) || blocks.containsKey(type) || fluids.containsKey(type);
    }

    public boolean containsItem(ResourceType type) {
        return items.containsKey(type);
    }

    public boolean containsBlock(ResourceType type) {
        return blocks.containsKey(type);
    }

    public boolean containsFluid(ResourceType type) {
        return fluids.containsKey(type);
    }

    /**
     * Returns the full name of the block/item for the given affix. For example, given "ore", returns "copper_ore",
     * if this is a copper resource. If the affix is empty, only the base resource name is returned.
     */
    public String getFullNameFor(ResourceType type) {
        return type.getFullName(baseName);
    }

    /**
     * Gets the item (or BlockItem!) corresponding to this item name. If it's already defined, returns the
     * already-defined one. If one is not registered, it returns Optional.empty();
     * For example, if you want to get sandbox:copper_ingot, and baseResource is copper,
     * you pass "ingot" in, since that is the affix.
     */
    public Optional<Item> getItem(ResourceType type) {
        return Optional.ofNullable(items.get(type));
    }

    /**
     * Gets the block corresponding to this block name. If it's already defined, returns the already-defined one. If
     * it's a builtin, registers and returns the builtin. Only if it's neither registered nor builtin is null returned.
     * For example, if you want to get cotton:copper_ore, and baseResource is copper,
     * * you pass "ore" in, since that is the affix.
     */
    public Optional<Block> getBlock(ResourceType type) {
        return Optional.ofNullable(blocks.get(type));
    }

    public Optional<Fluid> getFluid(ResourceType type) {
        return Optional.ofNullable(fluids.get(type));
    }

    public Collection<ResourceType> getAllTypes() {
        Set<ResourceType> ret = new HashSet<>();
        ret.addAll(items.keySet());
        ret.addAll(blocks.keySet());
        ret.addAll(fluids.keySet());
        return ret;
    }

    /**
     * Gets the affixes of all currently registered items for this resource.
     *
     * @return a collection of item name affixes which are guaranteed to be known for the purposes of contains and getItem
     */
    public Collection<ResourceType> getItemTypes() {
        return items.keySet();
    }

    /**
     * Gets the affixes of all currently registered items for this resource.
     *
     * @return a collection of block name affixes which are guaranteed to be known for the purposes of contains and getBlock
     */
    public Collection<ResourceType> getBlockTypes() {
        return blocks.keySet();
    }

    public Collection<ResourceType> getFluidTypes() {
        return fluids.keySet();
    }

    /**
     * Processes a request for new resource types, registering any that don't yet exist.
     *
     * @param request The requested resources to add.
     *                TODO: preference config to select a specific mod register
     */
    public void append(String source, ResourceRequest request) {
        Map<ResourceType, Supplier<Item>> requestedItems = request.getItems();
        Map<ResourceType, Supplier<Block>> requestedBlocks = request.getBlocks();
        Map<ResourceType, Supplier<Fluid>> requestedFluids = request.getFluids();
        Set<ResourceType> registeredItems = new HashSet<>();
        Set<ResourceType> registeredBlocks = new HashSet<>();
        Set<ResourceType> registeredFluids = new HashSet<>();
        for (ResourceType key : request.getItems().keySet()) {
            if (!containsItem(key)) {
                items.put(key, requestedItems.get(key).get());
                registeredItems.add(key);
            }
        }
        for (ResourceType key : request.getBlocks().keySet()) {
            if (!containsBlock(key)) {
                blocks.put(key, requestedBlocks.get(key).get());
                registeredBlocks.add(key);
            }
        }
        for (ResourceType key : request.getFluids().keySet()) {
            if (!containsFluid(key)) {
                fluids.put(key, requestedFluids.get(key).get());
                registeredFluids.add(key);
            }
        }
        addedItems.put(source, registeredItems);
        addedBlocks.put(source, registeredBlocks);
        addedFluids.put(source, registeredFluids);
    }

    public String getItemSource(ResourceType type) {
        for (String id : addedItems.keySet()) {
            if (addedItems.get(id).contains(type)) return id;
        }
        return "";
    }

    public String getBlockSource(ResourceType type) {
        for (String id : addedBlocks.keySet()) {
            if (addedBlocks.get(id).contains(type)) return id;
        }
        return "";
    }

    public String getFluidScource(ResourceType type) {
        for (String id : addedFluids.keySet()) {
            if (addedFluids.get(id).contains(type)) return id;
        }
        return "";
    }

    public void forEachItem(Consumer<ResourceType> consumer) {
        getItemTypes().forEach(consumer);
    }

    public void forEachBlock(Consumer<ResourceType> consumer) {
        getBlockTypes().forEach(consumer);
    }

    public void forEachFluid(Consumer<ResourceType> consumer) {
        getFluidTypes().forEach(consumer);
    }
}
