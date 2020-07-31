package org.sandboxpowered.internal;

import org.jetbrains.annotations.NotNull;
import org.sandboxpowered.api.block.Block;
import org.sandboxpowered.api.block.Material;
import org.sandboxpowered.api.block.entity.BlockEntity;
import org.sandboxpowered.api.client.Client;
import org.sandboxpowered.api.component.Component;
import org.sandboxpowered.api.content.Content;
import org.sandboxpowered.api.entity.Entity;
import org.sandboxpowered.api.entity.MobCategory;
import org.sandboxpowered.api.entity.data.SyncedData;
import org.sandboxpowered.api.fluid.Fluid;
import org.sandboxpowered.api.fluid.FluidStack;
import org.sandboxpowered.api.item.Item;
import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.registry.Registry;
import org.sandboxpowered.api.server.Server;
import org.sandboxpowered.api.shape.Shape;
import org.sandboxpowered.api.state.Property;
import org.sandboxpowered.api.util.Identity;
import org.sandboxpowered.api.util.annotation.Internal;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.math.Vec2i;
import org.sandboxpowered.api.util.math.Vec3i;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.api.util.nbt.ReadableCompoundTag;
import org.sandboxpowered.api.util.text.Text;

import java.util.function.Supplier;

@Internal
public interface InternalService {

    @NotNull
    static InternalService getInstance() {
        return SandboxServiceLoader.loadService(InternalService.class);
    }

    Identity createIdentityFromString(String identity);

    Identity createIdentityFromString(String name, String path);

    Text createLiteralText(String text);

    Text createTranslatedText(String translation);

    Material getMaterial(String material);

    BlockEntity.Type blockEntityTypeFunction(Supplier<? extends BlockEntity> supplier, Block[] blocks);

    ItemStack createItemStack(Item item, int amount);

    ItemStack createItemStackFromTag(ReadableCompoundTag tag);

    <T extends Content<T>> Registry<T> registryFunction(Class<T> c);

    CompoundTag createCompoundTag();

    <T extends Comparable<T>> Property<T> getProperty(String property);

    Server serverInstance();

    Vec3i createVec3i(int x, int y, int z);

    Position createPosition(int x, int y, int z);

    Position.Mutable createMutablePosition(int x, int y, int z);

    <T> Component<T> componentFunction(Class<T> c);

    Entity.Type entityTypeEntityFunction(Entity e);

    FluidStack fluidStackFunction(Fluid fluid, int amount);

    FluidStack fluidStackFromTagFunction(ReadableCompoundTag tag);

    Identity.Variant createVariantIdentity(Identity identity, String variant);

    Client clientInstance();

    Vec2i createVec2i(int x, int y);

    MobCategory getEntityCategory(String name);

    <T> SyncedData<T> registerSyncedData(Identity id, SyncedData.SyncedDataSerializer<T> serializer, boolean saveToWorld);

    Shape shape_cube(double minX, double minY, double minZ, double maxX, double maxY, double maxZ);

    Shape shape_fullCube();

    Shape shape_empty();
}
