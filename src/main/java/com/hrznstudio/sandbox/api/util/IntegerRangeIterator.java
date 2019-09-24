package com.hrznstudio.sandbox.api.util;

import com.google.common.annotations.Beta;

import java.util.Iterator;

@Beta
public class IntegerRangeIterator implements Iterator<Integer> {
    private final int start, end;
    private int current;

    public IntegerRangeIterator(int start, int end) {
        this.start = start;
        this.current = start;
        this.end = end;
    }

    @Override
    public boolean hasNext() {
        return current < end;
    }

    @Override
    public Integer next() {
        return current++;
    }
}
