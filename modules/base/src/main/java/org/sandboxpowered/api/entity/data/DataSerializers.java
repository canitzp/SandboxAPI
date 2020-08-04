package org.sandboxpowered.api.entity.data;

import org.sandboxpowered.api.item.ItemStack;
import org.sandboxpowered.api.state.BlockState;
import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.math.Position;
import org.sandboxpowered.api.util.nbt.CompoundTag;
import org.sandboxpowered.api.util.text.Text;
import org.sandboxpowered.internal.InternalService;

import java.util.Optional;
import java.util.OptionalInt;
import java.util.UUID;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

public class DataSerializers {
    public static final SyncedData.SyncedDataSerializer<Byte> BYTE = get(0, (key, tag, value) -> tag.setByte(key, value), (key, tag) -> tag.getByte(key));
    //public static final SyncedData.SyncedDataSerializer<Short> SHORT =
    public static final SyncedData.SyncedDataSerializer<Integer> INTEGER = get(1, (key, tag, value) -> tag.setInt(key, value), (key, tag) -> tag.getInt(key));
    //public static final SyncedData.SyncedDataSerializer<Long> LONG =
    //public static final SyncedData.SyncedDataSerializer<Float> FLOAT = get(2, );
    //public static final SyncedData.SyncedDataSerializer<Double> DOUBLE =
    public static final SyncedData.SyncedDataSerializer<String> STRING = get(3, (key, tag, value) -> tag.setString(key, value), (key, tag) -> tag.getString(key));
    //public static final SyncedData.SyncedDataSerializer<Text> TEXT_COMPONENT = get(4, );
    //public static final SyncedData.SyncedDataSerializer<Optional<Text>> OPTIONAL_TEXT_COMPONENT = get(5, );
    public static final SyncedData.SyncedDataSerializer<ItemStack> ITEM_STACK = get(6, (key, tag, value) -> tag.setTag(key, value.asTag()), (key, tag) -> ItemStack.read(tag));
    public static final SyncedData.SyncedDataSerializer<Boolean> BOOLEAN = get(7, (key, tag, value) -> tag.setBoolean(key, value), (key, tag) -> tag.getBoolean(key));
    public static final SyncedData.SyncedDataSerializer<Position> POSITION = get(9, (key, tag, value) -> tag.setPosition(key, value), (key, tag) -> tag.getPosition(key));
    public static final SyncedData.SyncedDataSerializer<Optional<Position>> OPTIONAL_POSITION = get(10, (key, tag, value) -> value.ifPresent(it -> tag.setPosition(key, it)), (key, tag) -> tag.contains(key) ? Optional.of(tag.getPosition(key)) : Optional.empty());
    public static final SyncedData.SyncedDataSerializer<Direction> DIRECTION = get(11, (key, tag, value) -> tag.setInt(key, value.getId()), (key, tag) -> Direction.byId(tag.getInt(key)));
    public static final SyncedData.SyncedDataSerializer<Optional<UUID>> OPTIONAL_UUID = get(12, (key, tag, value) -> value.ifPresent(it -> tag.setUUID(key, it)), (key, tag) -> tag.contains(key) ? Optional.of(tag.getUUID(key)) : Optional.empty());
    //public static final SyncedData.SyncedDataSerializer<Optional<BlockState>> OPTIONAL_BLOCK_STATE = get(13, );
    public static final SyncedData.SyncedDataSerializer<CompoundTag> TAG_COMPOUND = get(14, (key, tag, value) -> tag.setTag(key, value), (key, tag) -> tag.getCompound(key));

    private static <T> SyncedData.SyncedDataSerializer<T> get(int id, Serializer<T> serializer, BiFunction<String, CompoundTag, T> deserializer) {
        return InternalService.getInstance().injectDataHandler(id, serializer, deserializer);
    }

    @FunctionalInterface
    public interface Serializer<T> {
        void serialize(String key, CompoundTag tag, T value);
    }
}
