package stream;

import java.util.*;
import java.util.stream.Collectors;

class Employee {
    private String name;
    private Department department;
    private double salary;

    public Employee(String name, Department department, double salary) {
        this.name = name;
        this.department = department;
        this.salary = salary;
    }

    // Getters
    public String getName() { return name; }
    public Department getDepartment() { return department; }
    public double getSalary() { return salary; }

    @Override
    public String toString() { return name; }
}

class Department {
    private String name;
    private String code;

    public Department(String name, String code) {
        this.name = name;
        this.code = code;
    }

    // Getters
    public String getName() { return name; }
    public String getCode() { return code; }

    // Important: Override equals and hashCode for proper Map key behavior
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Department that = (Department) o;
        return Objects.equals(name, that.name) && Objects.equals(code, that.code);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, code);
    }

    @Override
    public String toString() { return name + "(" + code + ")"; }
}

public class EmployeeListToMapConverter {
    public static void main(String[] args) {
        // Create departments
        Department it = new Department("IT", "D001");
        Department hr = new Department("HR", "D002");
        Department finance = new Department("Finance", "D003");

        // Create employees
        List<Employee> employees = Arrays.asList(
                new Employee("John Doe", it, 75000),
                new Employee("Jane Smith", hr, 65000),
                new Employee("Bob Johnson", it, 80000),
                new Employee("Alice Brown", hr, 70000),
                new Employee("Charlie Wilson", finance, 90000),
                new Employee("Diana Lee", it, 85000)
        );

        // Convert List<Employee> to Map<Department, List<Employee>>
        Map<Department, List<Employee>> employeesByDept = employees.stream()
                .collect(Collectors.groupingBy(Employee::getDepartment));

        // Print the result
        employeesByDept.forEach((dept, empList) -> {
            System.out.println(dept + ": " + empList);
        });
    }
}