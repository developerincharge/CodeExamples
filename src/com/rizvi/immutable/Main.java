package com.rizvi.immutable;

import java.time.LocalDate;
import java.util.*;

// Usage
public class Main {
    public static void main(String[] args) {
        System.out.println("=== IMMUTABLE CLASSES DEMONSTRATION ===\n");

        // Test Scenario 1: Basic Immutable Class
        testBasicImmutableClass();

        // Test Scenario 2: With Mutable Objects
        testWithMutableObjects();

        // Test Scenario 3: Builder Pattern
        testBuilderPattern();

        // Test Scenario 4: Array Fields
        testArrayFields();

        // Test Scenario 5: Java Record
        testJavaRecord();

        // Test Scenario 6: Complete Example
        testCompleteExample();

        // Test Scenario 7: Employee without Collection
        testEmployeeWithoutCollection();

        // Test Scenario 8: Employee With Collection(need more code to achieve Immutability)
          testImmutableWithCollection();
         // Test Scenario 9 : Employee with Record Class to easily achieve immutability)
             testImmutableRecord();


    }
    // ========== SCENARIO 1: Basic Immutable Class ==========
    private static void testBasicImmutableClass() {
        System.out.println("1. BASIC IMMUTABLE CLASS DEMO");
        System.out.println("================================");

        ImmutablePerson person = new ImmutablePerson("John Doe", 30, "john@example.com");

        System.out.println("Created: " + person);
        System.out.println("Name: " + person.getName());
        System.out.println("Age: " + person.getAge());
        System.out.println("Email: " + person.getEmail());

        // Try to modify (won't work - no setters)
        // person.setName("Jane"); // Compile error!

        System.out.println();
    }


    // ========== SCENARIO 2: With Mutable Objects ==========
    private static void testWithMutableObjects() {
        System.out.println("2. WITH MUTABLE OBJECTS DEMO");
        System.out.println("================================");

        Date originalDate = new Date();
        List<String> originalSkills = new ArrayList<>(Arrays.asList("Java", "Spring", "SQL"));
        Department originalDept = new Department("Engineering", "Building A");

        ImmutableEmployee employee = new ImmutableEmployee(
                "E001", "Alice Smith", originalDate, originalSkills, originalDept
        );

        System.out.println("Original Department Location: " + originalDept.getLocation());

        // Try to modify original objects
        originalDate.setTime(0); // Modify original date
        originalSkills.add("Python"); // Modify original list
        originalDept.setLocation("Building B"); // Modify original department

        System.out.println("Modified Original Department Location: " + originalDept.getLocation());

        // Check if employee data changed
        System.out.println("\nEmployee Data (should be unchanged):");
        System.out.println("Join Date: " + employee.getJoinDate());
        System.out.println("Skills: " + employee.getSkills());
        System.out.println("Department Location: " + employee.getDepartment().getLocation());

        // Try to modify through getter
        List<String> skillsFromGetter = employee.getSkills();
        try {
            skillsFromGetter.add("JavaScript"); // Should throw UnsupportedOperationException
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify skills list: " + e.getClass().getSimpleName());
        }

        System.out.println();
    }

    // ========== SCENARIO 3: Builder Pattern ==========
    private static void testBuilderPattern() {
        System.out.println("3. BUILDER PATTERN DEMO");
        System.out.println("================================");

        ImmutableProduct laptop = new ImmutableProduct.Builder("P001", "Gaming Laptop")
                .price(1299.99)
                .addCategory("Electronics")
                .addCategory("Gaming")
                .addSpecification("Processor", "Intel i7")
                .addSpecification("RAM", "32GB")
                .addSpecification("GPU", "RTX 4070")
                .build();

        System.out.println("Product Built:");
        System.out.println("ID: " + laptop.getId());
        System.out.println("Name: " + laptop.getName());
        System.out.println("Price: $" + laptop.getPrice());
        System.out.println("Categories: " + laptop.getCategories());
        System.out.println("Specifications: " + laptop.getSpecifications());

        // Try to modify
        Map<String, String> specs = laptop.getSpecifications();
        try {
            specs.put("Storage", "1TB SSD"); // Should fail
        } catch (UnsupportedOperationException e) {
            System.out.println("Cannot modify specifications: " + e.getClass().getSimpleName());
        }

        System.out.println();
    }

    // ========== SCENARIO 4: Array Fields ==========
    private static void testArrayFields() {
        System.out.println("4. ARRAY FIELDS DEMO");
        System.out.println("================================");

        int[][] originalMatrix = {
                {1, 2, 3},
                {4, 5, 6},
                {7, 8, 9}
        };

        ImmutableMatrix matrix = new ImmutableMatrix(originalMatrix);

        System.out.println("Original Matrix:");
        printMatrix(originalMatrix);

        // Modify original
        originalMatrix[0][0] = 100;

        System.out.println("\nModified Original Matrix:");
        printMatrix(originalMatrix);

        System.out.println("\nImmutable Matrix (should be unchanged):");
        int[][] matrixCopy = matrix.getMatrix();
        printMatrix(matrixCopy);

        // Get single element
        System.out.println("\nElement at (1,2): " + matrix.getElement(1, 2));

        System.out.println();
    }

    // ========== SCENARIO 5: Java Record ==========
    private static void testJavaRecord() {
        System.out.println("5. JAVA RECORD DEMO (Java 14+)");
        System.out.println("================================");

        List<String> courses = new ArrayList<>(Arrays.asList("Math", "Physics", "CS"));
        ImmutableStudent student = new ImmutableStudent("S001", "Bob Johnson", 20, courses);

        System.out.println("Student Record:");
        System.out.println(student); // toString() auto-generated
        System.out.println("ID: " + student.id()); // Accessor method
        System.out.println("Name: " + student.name());
        System.out.println("Age: " + student.age());
        System.out.println("Courses: " + student.courses());
        System.out.println("Is Adult: " + student.isAdult());

        // Try to modify courses list
        courses.add("Chemistry");
        System.out.println("\nAfter modifying original list:");
        System.out.println("Original list: " + courses);
        System.out.println("Student courses (should be unchanged): " + student.courses());

        System.out.println();
    }

    // ========== SCENARIO 6: Complete Example ==========
    private static void testCompleteExample() {
        System.out.println("6. COMPLETE EXAMPLE DEMO");
        System.out.println("================================");

        List<Transaction> initialTransactions = Arrays.asList(
                new Transaction(LocalDate.of(2023, 1, 15), "OPENING", 1000.0),
                new Transaction(LocalDate.of(2023, 2, 1), "DEPOSIT", 500.0)
        );

        ImmutableBankAccount account = new ImmutableBankAccount(
                "ACC123456",
                "Charlie Brown",
                1500.0,
                LocalDate.of(2023, 1, 15),
                initialTransactions
        );

        System.out.println("Initial Account:");
        System.out.println("Account Holder: " + account.getAccountHolder());
        System.out.println("Balance: $" + account.getBalance());
        System.out.println("Open Date: " + account.getOpenDate());
        System.out.println("Number of Transactions: " + account.getTransactions().size());

        // Create new account with deposit (immutable modification)
        ImmutableBankAccount updatedAccount = account.withDeposit(200.0);

        System.out.println("\nAfter Deposit (New Account Object):");
        System.out.println("Original Balance: $" + account.getBalance());
        System.out.println("Updated Balance: $" + updatedAccount.getBalance());
        System.out.println("Updated Transactions: " + updatedAccount.getTransactions().size());

        // Verify original unchanged
        System.out.println("\nOriginal Account Unchanged:");
        System.out.println("Original Transactions: " + account.getTransactions().size());

        System.out.println();
    }

    // Helper method for matrix printing
    private static void printMatrix(int[][] matrix) {
        for (int[] row : matrix) {
            System.out.println(Arrays.toString(row));
        }

        System.out.println();
    }
        private static void testEmployeeWithoutCollection() {
            // Scenario 7 Employee without Collections

            System.out.println("An Employee without Collection Implementation ");

            ImmutableWithoutCollection emp = new ImmutableWithoutCollection(101, "Syed");
            System.out.println("New Employee Id: " + emp.getId());
            System.out.println("New Employee Name: " + emp.getName());

            System.out.println();
        }

        private static void testImmutableWithCollection() {

              // Scenario 8 : Employee with Collection (achieving immutability)
            List<String> lis = new ArrayList<>();
            lis.add("A");
            lis.add("Imtiaz");
            ImmutableWithCollection immutable = new ImmutableWithCollection(102, "Rizvi", lis);

            System.out.println(immutable);
            lis.add("B");
            lis.add("Hassan");
            System.out.println(immutable);
//            lis = immutable.getListString();
//            lis.add("C");
//            lis.add("Fatima");
            System.out.println(immutable);

            System.out.println();

        }

        public static void testImmutableRecord(){
         //  Scenario 9 : Employee With Record class(achieving immutability)
            List<String> lis1 = new ArrayList<>();
            lis1.add("A");
            lis1.add("Imtiaz");
            ImmutableRecord immutableRecord = new ImmutableRecord(104, "Syed", lis1);
            System.out.println(immutableRecord);
            lis1 = immutableRecord.stringList();
//            lis1.add("B");
//            lis1.add("Hassan");
            System.out.println(immutableRecord);
        }
              //
}
