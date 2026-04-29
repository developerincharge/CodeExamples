package com.rizvi.immutable;

import java.util.*;

public final class ImmutableProduct {
    private final String id;
    private final String name;
    private final double price;
    private final List<String> categories;
    private final Map<String, String> specifications;
    
    // Private constructor
    private ImmutableProduct(Builder builder) {
        this.id = builder.id;
        this.name = builder.name;
        this.price = builder.price;
        this.categories = Collections.unmodifiableList(
            new ArrayList<>(builder.categories));
        this.specifications = Collections.unmodifiableMap(
            new HashMap<>(builder.specifications));
    }
    
    // Getters
    public String getId() { return id; }
    public String getName() { return name; }
    public double getPrice() { return price; }
    public List<String> getCategories() {
        return Collections.unmodifiableList(new ArrayList<>(categories));
    }
    public Map<String, String> getSpecifications() {
        return Collections.unmodifiableMap(new HashMap<>(specifications));
    }
    
    // Builder class
    public static class Builder {
        private String id;
        private String name;
        private double price;
        private List<String> categories = new ArrayList<>();
        private Map<String, String> specifications = new HashMap<>();
        
        public Builder(String id, String name) {
            this.id = id;
            this.name = name;
        }
        
        public Builder price(double price) {
            this.price = price;
            return this;
        }
        
        public Builder addCategory(String category) {
            this.categories.add(category);
            return this;
        }
        
        public Builder addSpecification(String key, String value) {
            this.specifications.put(key, value);
            return this;
        }
        
        public Builder categories(List<String> categories) {
            this.categories = new ArrayList<>(categories);
            return this;
        }
        
        public Builder specifications(Map<String, String> specifications) {
            this.specifications = new HashMap<>(specifications);
            return this;
        }
        
        public ImmutableProduct build() {

            return new ImmutableProduct(this);
        }
    }
}

