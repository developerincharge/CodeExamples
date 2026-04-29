package com.rizvi.immutable;

import java.util.*;
import java.util.Date;

public final class ImmutableEmployee {
    private final String empId;
    private final String name;
    private final Date joinDate;  // Mutable
    private final List<String> skills;  // Mutable
    private final Department department;  // Custom mutable object
    
    // Constructor with defensive copying
    public ImmutableEmployee(String empId, String name, Date joinDate, 
                           List<String> skills, Department department) {
        this.empId = empId;
        this.name = name;
        
        // Defensive copy for Date (mutable)
        this.joinDate = new Date(joinDate.getTime());
        
        // Defensive copy for List (create unmodifiable list)
        this.skills = Collections.unmodifiableList(new ArrayList<>(skills));
        
        // Deep copy for custom mutable object
        this.department = new Department(department);
    }
    
    // Getters that return defensive copies
    public Date getJoinDate() {
        // Return copy instead of original reference
        return new Date(joinDate.getTime());
    }
    
    public List<String> getSkills() {
        // Return unmodifiable view
        return Collections.unmodifiableList(new ArrayList<>(skills));
    }
    
    public Department getDepartment() {
        // Return deep copy
        return new Department(department);
    }
    
    // Other getters...
    public String getEmpId() { return empId; }
    public String getName() { return name; }
}

// Supporting mutable class (for demonstration)
class Department {
    private String name;
    private String location;
    
    public Department(String name, String location) {
        this.name = name;
        this.location = location;
    }
    
    // Copy constructor for deep copying
    public Department(Department other) {
        this.name = other.name;
        this.location = other.location;
    }
    
    // Setters (makes it mutable)
    public void setName(String name) { this.name = name; }
    public void setLocation(String location) { this.location = location; }
    
    public String getName() { return name; }
    public String getLocation() { return location; }
}