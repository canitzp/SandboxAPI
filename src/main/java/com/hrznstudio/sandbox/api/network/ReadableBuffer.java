package com.hrznstudio.sandbox.api.network;

import com.google.common.annotations.Beta;
import com.hrznstudio.sandbox.api.util.Identity;
import com.hrznstudio.sandbox.api.util.math.Position;

@Beta
public interface ReadableBuffer {

    Identity readIdentity();

    Position readPosition();
}
