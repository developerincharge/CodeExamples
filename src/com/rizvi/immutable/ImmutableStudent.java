package com.rizvi.immutable;

import java.util.List;

// Records are inherently immutable (Java 14+)
public record ImmutableStudent(
    String id,
    String name,
    int age,
    List<String> courses
) {
    // Compact constructor for validation/defensive copying
    public ImmutableStudent {
        // Validation
        if (age < 0) {
            throw new IllegalArgumentException("Age cannot be negative");
        }
        // Defensive copy for mutable field
        courses = List.copyOf(courses); // Returns unmodifiable list
    }
    
    // You can add methods
    public boolean isAdult() {
        return age >= 18;
    }
}

// Usage is automatic - getters, equals, hashCode, toString provided