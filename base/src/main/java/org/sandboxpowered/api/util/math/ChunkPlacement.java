package org.sandboxpowered.api.util.math;

import org.sandboxpowered.api.util.Functions;

import java.util.Spliterator;
import java.util.Spliterators;
import java.util.function.Consumer;
import java.util.stream.Stream;
import java.util.stream.StreamSupport;

public interface ChunkPlacement {
    long MARKER = toLong(1875016, 1875016);

    static ChunkPlacement create(int x, int z) {
        return Functions.getInstance().createChunkPos(x, z);
    }

    static ChunkPlacement create(Position pos) {
        return create(pos.getX() >> 4, pos.getZ() >> 4);
    }

    static ChunkPlacement create(long pos) {
        return create((int)pos, (int)(pos >> 32));
    }

    int getX();

    int getZ();

    default long toLong() {
        return toLong(getX(), getZ());
    }

    static long toLong(int chunkX, int chunkZ) {
        return (long)chunkX & 4294967295L | ((long)chunkZ & 4294967295L) << 32;
    }

    static int getPackedX(long pos) {
        return (int)(pos & 4294967295L);
    }

    static int getPackedZ(long pos) {
        return (int)(pos >>> 32 & 4294967295L);
    }

    default int getStartX() {
        return getX() << 4;
    }

    default int getStartZ() {
        return getZ() << 4;
    }

    default int getEndX() {
        return (getX() << 4) + 15;
    }

    default int getEndZ() {
        return (getZ() << 4) + 15;
    }

    default int getRegionX() {
        return getX() >> 5;
    }

    default int getRegionZ() {
        return getZ() >> 5;
    }

    default int getRegionRelativeX() {
        return getX() & 31;
    }

    default int getRegionRelativeZ() {
        return getZ() & 31;
    }

    default Position toPosition(int chunkRelativeX, int chunkRelativeY, int chunkRelativeZ) {
        return Position.create((getX() << 4) + chunkRelativeX, chunkRelativeY, (getZ() << 4) + chunkRelativeZ);
    }

    default Position getCenterBlockPos() {
        return Position.create(getX() << 4, 0, getZ() << 4);
    }

    default int maxAxisDistance(ChunkPlacement chunkPos) {
        return Math.max(Math.abs(getX() - chunkPos.getX()), Math.abs(getZ() - chunkPos.getZ()));
    }

    static Stream<ChunkPlacement> stream(ChunkPlacement center, int radius) {
        return stream(create(center.getX() - radius, center.getZ() - radius), create(center.getX() + radius, center.getZ() + radius));
    }

    static Stream<ChunkPlacement> stream(final ChunkPlacement pos1, final ChunkPlacement pos2) {
        int i = Math.abs(pos1.getX() - pos2.getX()) + 1;
        int j = Math.abs(pos1.getZ() - pos2.getZ()) + 1;
        final int k = pos1.getX() < pos2.getX() ? 1 : -1;
        final int l = pos1.getZ() < pos2.getZ() ? 1 : -1;
        return StreamSupport.stream(new Spliterators.AbstractSpliterator<>(i * j, Spliterator.SIZED) {
            private ChunkPlacement position;

            public boolean tryAdvance(Consumer<? super ChunkPlacement> consumer) {
                if (this.position == null) {
                    this.position = pos1;
                } else {
                    int i = this.position.getX();
                    int j = this.position.getZ();
                    if (i == pos2.getX()) {
                        if (j == pos2.getZ()) {
                            return false;
                        }

                        this.position = create(pos1.getX(), j + l);
                    } else {
                        this.position = create(i + k, j);
                    }
                }

                consumer.accept(this.position);
                return true;
            }
        }, false);
    }
}
