package com.rizvi.immutable;

public final class ImmutableWithoutCollection {
    private final int id;
    private final String name;

    public ImmutableWithoutCollection(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId(){
        return id;
    }

    public String getName() {
        return name;
    }
}
