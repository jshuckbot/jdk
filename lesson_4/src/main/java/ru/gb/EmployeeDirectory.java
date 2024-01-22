package ru.gb;

import java.util.ArrayList;
import java.util.List;

public class EmployeeDirectory {
    List<Employee> employees = new ArrayList<>();
    
    public List<Employee> findEmployeeByExperience(int experience) {
        return employees.stream().filter(x -> x.getExperience() == experience).toList();
    }
    
    public void add(Employee employee) {
        employees.add(employee);
    }
    
    public List<String> getPhoneEmployee(String name) {
        List<Employee> filterEmployees = employees.stream().filter(x -> x.getName().equals(name)).toList();
        List<String> numbersEmployees = new ArrayList<>();
        for (Employee employee : filterEmployees) {
            numbersEmployees.add(employee.getPhone());
        }
        return numbersEmployees;
    }
    
    public Employee findServiceNumber(int serviceNumber) {
        return employees.stream().filter(x -> x.getServiceNumber() == serviceNumber).findFirst().get();
    }
}
