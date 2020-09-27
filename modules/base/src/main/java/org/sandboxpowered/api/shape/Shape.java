package org.sandboxpowered.api.shape;

import org.sandboxpowered.api.util.Direction;
import org.sandboxpowered.api.util.math.ShapeCombination;
import org.sandboxpowered.api.util.math.Vec3d;
import org.sandboxpowered.internal.InternalService;

import java.util.List;

public interface Shape {

    static Shape empty() {
        return InternalService.getInstance().shape_empty();
    }

    static Shape fullCube() {
        return InternalService.getInstance().shape_fullCube();
    }

    static Shape cuboid(int minX, int minY, int minZ, int maxX, int maxY, int maxZ) {
        return cube(minX / 16d, minY / 16d, minZ / 16d, maxX / 16d, maxY / 16d, maxZ / 16d);
    }

    static Shape cube(double minX, double minY, double minZ, double maxX, double maxY, double maxZ) {
        return InternalService.getInstance().shape_cube(minX, minY, minZ, maxX, maxY, maxZ);
    }

    static Shape cube(Vec3d min, Vec3d max) {
        return cube(min.getX(), min.getY(), min.getZ(), max.getX(), max.getY(), max.getZ());
    }

    Box getBoundingBox();

    boolean isEmpty();

    Shape offset(double x, double y, double z);

    Shape simplify();

    List<Box> getBoxes();

    Shape getFace(Direction direction);

    boolean contains(double x, double y, double z);

    default Shape combine(Shape shape) {
        return combine(shape, ShapeCombination.OR);
    }

    Shape combine(Shape shape, ShapeCombination function);
}