package com.rizvi.immutable;

import java.util.List;

public record ImmutableRecord(int id, String name, List<String> stringList) {

    public ImmutableRecord{
        stringList = List.copyOf(stringList);
    }

    // After java 14 onwards by using this record class
    // easily  immutability can be achieved with boilerplate code.
}
