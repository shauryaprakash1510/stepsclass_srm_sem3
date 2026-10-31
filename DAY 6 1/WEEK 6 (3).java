package week_6.set_1;

class Employee {
    private String empId;
    private String empName;
    private double salary;
    private boolean isIntern;

    public Employee(String empId, String empName, double salary) {
        this.empId = empId;
        this.empName = empName;
        this.salary = salary;
        this.isIntern = false;
    }

    public Employee(String empId, String empName) {
        this(empId, empName, 0.0);
        this.isIntern = true;
    }

    public void printProfile() {
        System.out.printf("%s -| %s | Rs %.1f | Intern: %b\n", empId, empName, salary, isIntern);
    }
}

public class M3_EmployeeProfile {
    public static void main(String[] args) {
        Employee permanent = new Employee("E101", "Divya", 65000);
        Employee intern = new Employee("E102", "Arjun");

        permanent.printProfile();
        intern.printProfile();
    }
}