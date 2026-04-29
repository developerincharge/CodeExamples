package com.rizvi.immutable;

// Step 1: Make the class final
public final class ImmutablePerson {
    
    // Step 2: Make all fields private and final
    private final String name;
    private final int age;
    private final String email;
    
    // Step 3: Initialize all fields in constructor
    public ImmutablePerson(String name, int age, String email) {
        this.name = name;
        this.age = age;
        this.email = email;
    }
    
    // Step 4: Only provide getters (no setters)
    public String getName() {
        return name;
    }
    
    public int getAge() {
        return age;
    }
    
    public String getEmail() {
        return email;
    }
    
    // Step 5: Override toString, equals, hashCode if needed
    @Override
    public String toString() {
        return "Person{name='" + name + "', age=" + age + ", email='" + email + "'}";
    }
}