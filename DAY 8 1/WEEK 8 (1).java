package week_8.set_1;

import java.util.*;

abstract class Payment {
    protected double amount;

    public Payment(double amount) {
        this.amount = amount;
    }

    public abstract double calculateFinalAmount();
    public abstract String getTypeName();
}

class CardPayment extends Payment {
    public CardPayment(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount * 1.02; }
    @Override
    public String getTypeName() { return "CARD"; }
}

class WalletPayment extends Payment {
    public WalletPayment(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount * 1.01; }
    @Override
    public String getTypeName() { return "WALLET"; }
}

class BankTransferPayment extends Payment {
    public BankTransferPayment(double amount) { super(amount); }
    @Override
    public double calculateFinalAmount() { return amount; }
    @Override
    public String getTypeName() { return "BANKTRANSFER"; }
}

public class P1_PaymentFee {
    public static void main(String[] args) {
        String input = "3\nCARD 1000\nWALLET 500\nBANKTRANSFER 2000";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<Payment> transactions = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double amount = sc.nextDouble();
            if (type.equals("CARD")) transactions.add(new CardPayment(amount));
            else if (type.equals("WALLET")) transactions.add(new WalletPayment(amount));
            else if (type.equals("BANKTRANSFER")) transactions.add(new BankTransferPayment(amount));
        }

        // Polymorphic processing: No type checking here
        double grandTotal = 0;
        for (Payment p : transactions) {
            double finalAmt = p.calculateFinalAmount();
            System.out.printf("%s: %.2f\n", p.getTypeName(), finalAmt);
            grandTotal += finalAmt;
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}