package com.hrznstudio.sandbox.api.container;

import com.google.common.annotations.Beta;

import java.util.Collection;

@Beta
public interface IContainer {
    Collection<ISlot> getSlots();
}