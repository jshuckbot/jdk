package ru.gb;

/**
 * lesson_4
 */
public class App {
    public static void main(String[] args) {
        
        EmployeeDirectory employeeDirectory = new EmployeeDirectory();
        Employee employee1 = new Employee("Ivan", 199239, "331931101", 12);
        Employee employee2 = new Employee("Sergey", 99983, "91319300", 7);
        Employee employee3 = new Employee("Max", 11101, "999119191", 12);
        
        employeeDirectory.add(employee1);
        employeeDirectory.add(employee2);
        employeeDirectory.add(employee3);
        
        System.out.println(employeeDirectory.findEmployeeByExperience(12));
        System.out.println(employeeDirectory.getPhoneEmployee("Ivan"));
        System.out.println(employeeDirectory.findServiceNumber(11101));
    }
}


