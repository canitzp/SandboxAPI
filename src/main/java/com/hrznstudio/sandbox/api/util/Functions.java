package com.hrznstudio.sandbox.api.util;

import java.util.function.Function;

public class Functions {
    public static final Function<String, Identity> identityFunction = s -> {
        throw new RuntimeException("fuck it broke");
    };


}
