package week_8.set_2;

import java.util.*;

abstract class Employee {
    protected String name;
    protected double monthlySalary;

    public Employee(String name, double monthlySalary) {
        this.name = name;
        this.monthlySalary = monthlySalary;
    }

    public abstract double calculateBonus();
    public String getName() { return name; }
}

class FullTimeEmployee extends Employee {
    public FullTimeEmployee(String name, double salary) { super(name, salary); }
    @Override
    public double calculateBonus() { return monthlySalary * 0.10; }
}

class PartTimeEmployee extends Employee {
    public PartTimeEmployee(String name, double salary) { super(name, salary); }
    @Override
    public double calculateBonus() { return monthlySalary * 0.05; }
}

class InternEmployee extends Employee {
    public InternEmployee(String name, double salary) { super(name, salary); }
    @Override
    public double calculateBonus() { return 2000.0; }
}

public class P4_FestivalBonus {
    public static void main(String[] args) {
        String input = "3\nFULLTIME Asha 50000\nPARTTIME Ravi 30000\nINTERN Neha 15000";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<Employee> employees = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            double salary = sc.nextDouble();

            if (type.equals("FULLTIME")) employees.add(new FullTimeEmployee(name, salary));
            else if (type.equals("PARTTIME")) employees.add(new PartTimeEmployee(name, salary));
            else if (type.equals("INTERN")) employees.add(new InternEmployee(name, salary));
        }

        double grandTotal = 0.0;
        for (Employee emp : employees) {
            double bonus = emp.calculateBonus();
            System.out.printf("%s: %.2f\n", emp.getName(), bonus);
            grandTotal += bonus;
        }
        System.out.printf("Total Bonus: %.2f\n", grandTotal);
    }
}