package string_coding;

import java.util.Arrays;
import java.util.List;

public class PrintEmpNames {

    public static void main(String[] args) {
        System.out.println("Filter Employee");

        List<Employee> employees = Arrays.asList(
                new Employee(1, "Alice", "New York", "HR", 60000),
                new Employee(2, "Bob", "Los Angeles", "IT", 75000),
                new Employee(3, "Charlie", "Chicago", "Finance", 80000),
                new Employee(4, "David", "Houston", "IT", 72000),
                new Employee(5, "Eve", "Phoenix", "HR", 65000),
                new Employee(6, "Frank", "Philadelphia", "Finance", 95000),
                new Employee(7, "Grace", "San Antonio", "IT", 110000),
                new Employee(8, "Hannah", "San Diego", "HR", 55000)
        );


        employees.stream()
                .map(emp ->emp.getEmpName().toUpperCase())
                .sorted()
                .forEach(System.out::println);
    }
}
