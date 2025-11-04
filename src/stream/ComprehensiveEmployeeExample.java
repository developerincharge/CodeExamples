package stream;

import java.util.*;
import java.util.stream.Collectors;

public class ComprehensiveEmployeeExample {
    public static void main(String[] args) {
        Department it = new Department("IT", "D001");
        Department hr = new Department("HR", "D002");
        Department finance = new Department("Finance", "D003");
        
        List<Employee> employees = Arrays.asList(
            new Employee("John Doe", it, 75000),
            new Employee("Jane Smith", hr, 65000),
            new Employee("Bob Johnson", it, 80000),
            new Employee("Alice Brown", hr, 70000),
            new Employee("Charlie Wilson", finance, 90000),
            new Employee("Diana Lee", it, 85000),
            new Employee("Eve Davis", finance, 95000)
        );

        // Multiple operations in one stream
        Map<Department, List<String>> result = employees.stream()
                .filter(emp -> emp.getSalary() > 70000)  // Filter high earners
                .sorted(Comparator.comparing(Employee::getSalary).reversed()) // Sort by salary desc
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
              //          TreeMap.comparing(Department::getName) // Sort departments by name
                        Collectors.mapping(
                                Employee::getName,
                                Collectors.toList()
                        )
                ));

        Map<Department, List<String>> employeeNamesByDept = employees.stream()
                .collect(Collectors.groupingBy(
                        Employee::getDepartment,
                        Collectors.mapping(Employee::getName, Collectors.toList())
                ));
        
        // Print results
        result.forEach((dept, names) -> {
            System.out.println(dept.getName() + " (" + names.size() + " employees): " + names);
        });
        
        // Additional statistics
        System.out.println("\nDepartment Statistics:");
        employees.stream()
                .collect(Collectors.groupingBy(
                    Employee::getDepartment,
                    Collectors.summarizingDouble(Employee::getSalary)
                ))
                .forEach((dept, stats) -> {
                    System.out.printf("%s: Count=%d, Avg=%.2f, Max=%.2f, Min=%.2f%n",
                            dept.getName(), stats.getCount(), stats.getAverage(), 
                            stats.getMax(), stats.getMin());
                });
    }
}