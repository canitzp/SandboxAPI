package com.hrznstudio.sandbox.api.util;

public interface Identity {

    static Identity of(String test, String test1) {
        return Functions.identityFunction.apply(test + ":" + test1);
    }

    String getNamespace();

    String getPath();
}