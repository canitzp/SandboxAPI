package org.sandboxpowered.internal;

import com.google.common.collect.Iterators;
import org.jetbrains.annotations.NotNull;

import java.util.Arrays;
import java.util.ServiceLoader;

@org.sandboxpowered.api.util.annotation.Internal
public class Internal {
    private static Functions FUNCTION;

    @NotNull
    static Functions loadFunctions() {
        if (FUNCTION == null) {
            ServiceLoader<Functions> functionsServiceLoader = ServiceLoader.load(Functions.class);
            Functions[] functions = Iterators.toArray(functionsServiceLoader.iterator(), Functions.class);
            if (functions.length == 0)
                throw new IllegalStateException("No functions defined, require 1");
            if (functions.length > 1)
                throw new IllegalStateException(String.format("Cannot have more than 2 functions defined, all functions [%s]", Arrays.toString(functions)));
            FUNCTION = functions[0];
        }
        if (FUNCTION == null)
            throw new NullPointerException("Function is null unexpectedly");
        return FUNCTION;
    }
}