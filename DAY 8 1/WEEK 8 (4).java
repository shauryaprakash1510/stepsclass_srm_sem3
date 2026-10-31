package week_8.set_1;

import java.util.*;

abstract class Delivery {
    protected double weight;
    protected double distance;

    public Delivery(double weight, double distance) {
        this.weight = weight;
        this.distance = distance;
    }

    public abstract double calculateFee();
    public abstract String getTypeName();
}

class StandardDelivery extends Delivery {
    public StandardDelivery(double weight, double distance) { super(weight, distance); }
    @Override
    public double calculateFee() { return 5.0 + (0.50 * weight) + (0.10 * distance); }
    @Override
    public String getTypeName() { return "STANDARD"; }
}

class ExpressDelivery extends Delivery {
    public ExpressDelivery(double weight, double distance) { super(weight, distance); }
    @Override
    public double calculateFee() { return 15.0 + (1.00 * weight) + (0.20 * distance); }
    @Override
    public String getTypeName() { return "EXPRESS"; }
}

class InternationalDelivery extends Delivery {
    private double customsFee;
    public InternationalDelivery(double weight, double distance, double customsFee) {
        super(weight, distance);
        this.customsFee = customsFee;
    }
    @Override
    public double calculateFee() { return 25.0 + (2.00 * weight) + (0.50 * distance) + customsFee; }
    @Override
    public String getTypeName() { return "INTERNATIONAL"; }
}

public class P3_DeliveryFee {
    public static void main(String[] args) {
        String input = "3\nSTANDARD 10 50\nEXPRESS 5 20\nINTERNATIONAL 20 100 30";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<Delivery> deliveries = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double dist = sc.nextDouble();
            if (type.equals("STANDARD")) {
                deliveries.add(new StandardDelivery(weight, dist));
            } else if (type.equals("EXPRESS")) {
                deliveries.add(new ExpressDelivery(weight, dist));
            } else if (type.equals("INTERNATIONAL")) {
                double customs = sc.nextDouble();
                deliveries.add(new InternationalDelivery(weight, dist, customs));
            }
        }

        double grandTotal = 0.0;
        for (Delivery d : deliveries) {
            double fee = d.calculateFee();
            System.out.printf("%s: %.2f\n", d.getTypeName(), fee);
            grandTotal += fee;
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}