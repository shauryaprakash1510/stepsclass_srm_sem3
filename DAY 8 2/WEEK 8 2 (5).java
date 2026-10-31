package week_8.set_2;

import java.util.*;

abstract class Customer {
    protected double billAmount;

    public Customer(double billAmount) {
        this.billAmount = billAmount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getCustomerType();
}

class StudentCustomer extends Customer {
    public StudentCustomer(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return billAmount * 0.90; } // 10% discount
    @Override
    public String getCustomerType() { return "STUDENT"; }
}

class StaffCustomer extends Customer {
    public StaffCustomer(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return billAmount * 0.95; } // 5% discount
    @Override
    public String getCustomerType() { return "STAFF"; }
}

class GuestCustomer extends Customer {
    public GuestCustomer(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return billAmount + 10.0; } // 10 service charge
    @Override
    public String getCustomerType() { return "GUEST"; }
}

public class P1_CanteenBilling {
    public static void main(String[] args) {
        String input = "3\nSTUDENT 200\nSTAFF 300\nGUEST 150";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<Customer> bills = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            if (type.equals("STUDENT")) bills.add(new StudentCustomer(amount));
            else if (type.equals("STAFF")) bills.add(new StaffCustomer(amount));
            else if (type.equals("GUEST")) bills.add(new GuestCustomer(amount));
        }

        double grandTotal = 0.0;
        for (Customer c : bills) {
            double finalAmt = c.calculateFinalAmount();
            System.out.printf("%s: %.2f\n", c.getCustomerType(), finalAmt);
            grandTotal += finalAmt;
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}