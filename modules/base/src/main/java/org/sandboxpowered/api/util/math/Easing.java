package org.sandboxpowered.api.util.math;

import static java.lang.Math.cos;
import static java.lang.Math.sin;

public enum Easing {
    SINE_IN(progress -> 1f - Math.cos((progress * Math.PI) / 2f)),
    SINE_OUT(progress -> sin((progress * Math.PI) / 2)),
    SINE_IN_OUT(progress -> -(cos(Math.PI * progress) - 1) / 2);
    private final DFunc func;

    Easing(DFunc func) {
        this.func = func;
    }

    public double ease(double progress) {
        return func.apply(progress);
    }

    public float ease(float progress) {
        return (float) func.apply(progress);
    }

    @FunctionalInterface
    private interface DFunc {
        double apply(double progress);
    }
}