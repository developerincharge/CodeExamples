package singleton;

import java.util.ArrayList;
import java.util.List;

public class Singleton {
    // Private static instance
    private static Singleton instance;
    
    // Lock object for thread safety
    private static final Object lockObject = new Object();
    
    // Data that the singleton manages
    private List<Country> countries;
    
    // Private constructor to prevent instantiation
    private Singleton() {
        System.out.println("Singleton instance created!");
    }
    
    // Public static method to access the singleton instance
    public static Singleton getInstance() {
        // First check (without lock) for performance
        if (instance == null) {
            synchronized (lockObject) {
                // Second check (with lock) for thread safety
                if (instance == null) {
                    instance = new Singleton();
                }
            }
        }
        return instance;
    }
    
    // Method to get countries with lazy initialization
    public List<Country> getCountries() {
        if (countries == null) {
            synchronized (lockObject) {
                if (countries == null) {
                    initializeCountries();
                }
            }
        }
        return new ArrayList<>(countries); // Return copy to maintain encapsulation
    }
    
    // Private method to initialize countries
    private void initializeCountries() {
        System.out.println("Initializing countries data...");
        
        // Simulate some processing time
        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            Thread.currentThread().interrupt();
        }
        
        countries = new ArrayList<>();
        countries.add(new Country("United States", "US", "Washington D.C."));
        countries.add(new Country("United Kingdom", "UK", "London"));
        countries.add(new Country("Canada", "CA", "Ottawa"));
        countries.add(new Country("Australia", "AU", "Canberra"));
        countries.add(new Country("Germany", "DE", "Berlin"));
        countries.add(new Country("France", "FR", "Paris"));
        countries.add(new Country("Japan", "JP", "Tokyo"));
        
        System.out.println("Countries data initialized!");
    }
    
    // Additional method to demonstrate functionality
    public void displayCountries() {
        List<Country> countriesList = getCountries();
        System.out.println("\nTotal Countries: " + countriesList.size());
        for (Country country : countriesList) {
            System.out.println("  - " + country);
        }
    }
    
    // Method to search for a country by code
    public Country findCountryByCode(String code) {
        List<Country> countriesList = getCountries();
        for (Country country : countriesList) {
            if (country.getCode().equalsIgnoreCase(code)) {
                return country;
            }
        }
        return null;
    }
}

