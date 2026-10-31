package week_9;

import java.util.*;

// Base class prevents generic direct instantiation
abstract class Staff {
    private String name;

    public Staff(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public abstract double calculatePay();
}

class FullTimeStaff extends Staff {
    private double weeklySalary;

    public FullTimeStaff(String name, double weeklySalary) {
        super(name);
        this.weeklySalary = weeklySalary;
    }

    @Override
    public double calculatePay() {
        return weeklySalary;
    }
}

class HourlyStaff extends Staff {
    private double hours;
    private double rate;

    public HourlyStaff(String name, double hours, double rate) {
        super(name);
        this.hours = hours;
        this.rate = rate;
    }

    @Override
    public double calculatePay() {
        if (hours <= 40) {
            return hours * rate;
        } else {
            return (40 * rate) + ((hours - 40) * 1.5 * rate);
        }
    }
}

class InternStaff extends Staff {
    private double stipend;

    public InternStaff(String name, double stipend) {
        super(name);
        this.stipend = stipend;
    }

    @Override
    public double calculatePay() {
        return stipend;
    }
}

public class P2_WeeklyStaffPay {
    public static void main(String[] args) {
        String input = "3\nFULLTIME Asha 12000\nHOURLY Ravi 45 200\nINTERN Neha 5000";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<Staff> staffMembers = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            if (type.equals("FULLTIME")) {
                staffMembers.add(new FullTimeStaff(name, sc.nextDouble()));
            } else if (type.equals("HOURLY")) {
                staffMembers.add(new HourlyStaff(name, sc.nextDouble(), sc.nextDouble()));
            } else if (type.equals("INTERN")) {
                staffMembers.add(new InternStaff(name, sc.nextDouble()));
            }
        }

        double totalPayroll = 0.0;
        for (Staff s : staffMembers) {
            double pay = s.calculatePay();
            System.out.printf("%s: %.2f\n", s.getName(), pay);
            totalPayroll += pay;
        }
        System.out.printf("Total Payroll: %.2f\n", totalPayroll);
    }
}