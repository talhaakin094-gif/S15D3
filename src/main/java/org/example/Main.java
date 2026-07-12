package org.example;
import org.example.entity.Employee;
import java.util.*;

public class Main {
    public static void main(String[] args) {
        List<Employee> employees = new LinkedList<>();
        Employee employee1 = new Employee(101, "Smith", "John");
        Employee employee2 = new Employee(102, "Johnson", "Emma");
        Employee employee3 = new Employee(103, "Brown", "Michael");
        Employee employee4 = new Employee(103, "Brown", "Michael");
        employees.add(employee1);
        employees.add(employee2);
        employees.add(employee3);
        employees.add(employee4);
        findDuplicates(employees);
        findUniques(employees);
        removeDuplicates(employees);

        System.out.println(WordCounter.calculatedWord());
    }
    public static List<Employee> findDuplicates(List<Employee> employees) {
        List<Employee> duplicates = new LinkedList<>();
        for(Employee employee : employees) {
            int count = 0;
            for(Employee e : employees) {
                if(employee != null && employee.equals(e)) {
                    count = count + 1;
                }
            }
            if(count > 1 && !duplicates.contains(employee)) {
                duplicates.add(employee);
            }
        }
        System.out.println("duplicates: " + duplicates);
        return duplicates;
    }
    public static Map<Integer, Employee> findUniques(List<Employee> employees) {
        Map<Integer, Employee> uniques = new LinkedHashMap<>();
        for(Employee employee : employees) {
            for(Employee e : employees) {
                if(employee != null && !uniques.containsKey(employee.getId()) && employee.equals(e)) {
                    uniques.put(employee.getId(), employee);
                }
            }
        }
        System.out.println("uniques and duplicates: " + uniques);
        return uniques;
    }
    public static List<Employee> removeDuplicates(List<Employee> employees) {
        List<Employee> uniques = new LinkedList<>();
        List<Employee> toRemove = new LinkedList<>();
        for(Employee employee : employees) {
            int count = 0;
            for(Employee e : employees) {
                if(employee != null && employee.equals(e)) {
                    count = count + 1;
                }
            }
            if(count == 1) {
                uniques.add(employee);
            }
            if(count > 1) {
                toRemove.add(employee);
            }
        }
        employees.removeAll(toRemove);
        System.out.println("without duplicates: " + employees);
        return uniques;
    }
}