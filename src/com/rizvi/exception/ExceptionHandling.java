package com.rizvi.exception;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Scanner;
import java.util.InputMismatchException;

public class ExceptionHandling {
    
    // Database connection details
    private static final String URL = "jdbc:mysql://localhost:3306/userdb";
    private static final String USER = "root";
    private static final String PASSWORD = "1234";

    public static void main(String[] args) {
        handleDatabaseOperations();
        handleUserInput();
        handleFileOperations();
    }
    
    // Scenario 1: Database Exception Handling
    public static void handleDatabaseOperations() {
        Connection connection = null;
        PreparedStatement preparedStatement = null;
        ResultSet resultSet = null;
        
        try {
            System.out.println("=== Database Operations ===");
            
            // 1. Establish database connection
            connection = DriverManager.getConnection(URL, USER, PASSWORD);
            System.out.println("Database connection established successfully.");
            
            // 2. Create a prepared statement
            String query = "SELECT id, name FROM users WHERE age > ?";
            preparedStatement = connection.prepareStatement(query);
            
            // 3. Set parameter (simulating potential error)
            preparedStatement.setInt(1, 18);
            
            // 4. Execute query
            resultSet = preparedStatement.executeQuery();
            
            // 5. Process results
            while (resultSet.next()) {
                int id = resultSet.getInt("id");
                String name = resultSet.getString("name");
                System.out.println("User ID: " + id + ", Name: " + name);
            }
            
        } catch (SQLException e) {
            // Handle specific SQL exceptions
            System.err.println("Database error occurred:");
            
            // Check specific error conditions
            if (e.getErrorCode() == 1045) {
                System.err.println("Access denied - Check username/password");
            } else if (e.getErrorCode() == 0) {
                System.err.println("Cannot connect to database - Check if database is running");
            } else {
                System.err.println("SQL Error Code: " + e.getErrorCode());
                System.err.println("SQL State: " + e.getSQLState());
                System.err.println("Message: " + e.getMessage());
            }
            
            // Log the full stack trace for debugging
            e.printStackTrace();
            
        } finally {
            // 6. Always close resources in finally block
            try {
                if (resultSet != null) resultSet.close();
                if (preparedStatement != null) preparedStatement.close();
                if (connection != null) connection.close();
                System.out.println("Database resources closed successfully.");
            } catch (SQLException e) {
                System.err.println("Error closing database resources: " + e.getMessage());
            }
        }
    }
    
    // Scenario 2: User Input Exception Handling
    public static void handleUserInput() {
        Scanner scanner = new Scanner(System.in);
        
        System.out.println("\n=== User Input Handling ===");
        
        while (true) {
            try {
                System.out.print("Enter a number: ");
                int number = scanner.nextInt();
                
                // Potential arithmetic exception
                int result = 100 / number;
                System.out.println("100 divided by " + number + " = " + result);
                
                break; // Exit loop on successful input
                
            } catch (InputMismatchException e) {
                System.err.println("Invalid input! Please enter a valid integer.");
                scanner.nextLine(); // Clear the invalid input
                
            } catch (ArithmeticException e) {
                System.err.println("Cannot divide by zero! Please enter a non-zero number.");
                
            } catch (Exception e) {
                System.err.println("Unexpected error: " + e.getMessage());
                break;
            }
        }
        
        scanner.close();
    }
    
    // Scenario 3: File Operations with Multiple Exception Types
    public static void handleFileOperations() {
        System.out.println("\n=== File Operations ===");
        
        try {
            // Simulating different exception scenarios
            String filename = "test.txt";
            
            // Check if file exists (simulated)
            if (filename == null) {
                throw new NullPointerException("Filename cannot be null");
            }
            
            // Simulate file reading
            String content = readFile(filename);
            System.out.println("File content: " + content);
            
        } catch (NullPointerException e) {
            System.err.println("Null pointer error: " + e.getMessage());
            
        } catch (SecurityException e) {
            System.err.println("Security violation: " + e.getMessage());
            
        } catch (Exception e) {
            // Catch-all for other exceptions
            System.err.println("General error in file operations: " + e.getMessage());
            
        } finally {
            System.out.println("File operation completed (finally block always executes)");
        }
    }
    
    // Helper method that throws different exceptions
    private static String readFile(String filename) throws Exception {
        // Simulating different error conditions
        if (filename.isEmpty()) {
            throw new IllegalArgumentException("Filename cannot be empty");
        }
        
        if (!filename.endsWith(".txt")) {
            throw new UnsupportedOperationException("Only .txt files are supported");
        }
        
        // Simulate file not found
        if (!filename.equals("test.txt")) {
            throw new Exception("File not found: " + filename);
        }
        
        return "Sample file content";
    }
    
    // Scenario 4: Custom Exception Handling
    public static void validateUserAge(int age) throws InvalidAgeException {
        if (age < 0) {
            throw new InvalidAgeException("Age cannot be negative", age);
        }
        
        if (age > 150) {
            throw new InvalidAgeException("Age is unrealistically high", age);
        }
        
        if (age < 18) {
            throw new InvalidAgeException("User must be at least 18 years old", age);
        }
        
        System.out.println("Valid age: " + age);
    }
}

// Custom Exception Class
class InvalidAgeException extends Exception {
    private int invalidAge;
    
    public InvalidAgeException(String message, int age) {
        super(message);
        this.invalidAge = age;
    }
    
    public int getInvalidAge() {
        return invalidAge;
    }
}