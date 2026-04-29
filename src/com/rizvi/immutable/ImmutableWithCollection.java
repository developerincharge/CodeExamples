package com.rizvi.immutable;

import java.util.List;

public final class ImmutableWithCollection {
    private final int id;
    private final String name;
    private final List<String> listString;

    public ImmutableWithCollection(int id, String name, List<String> listString) {
        this.id = id;
        this.name = name;
       this.listString = List.copyOf(listString); // Adding List.copyOf() to prevent mutation
        //this.listString = new ArrayList<>(listString); // Add Deep Copy to prevent mutation
    }

    public int getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public List<String> getListString() {
        return listString; // Adding the deep copy in getter
    }

    @Override
    public String toString() {
        return "ImmutableWithCollection{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", listString=" + listString +
                '}';
    }
}
