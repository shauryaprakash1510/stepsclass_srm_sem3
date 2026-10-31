package week_9.set_1;

import java.util.*;

interface Insurable {
    double calculateInsurance();
}

abstract class Parcel {
    protected double weightKg;
    protected double declaredValue;

    public Parcel(double weightKg, double declaredValue) {
        this.weightKg = weightKg;
        this.declaredValue = declaredValue;
    }

    public abstract double calculateShippingCharge();
    public abstract String getType();

    public double getInsurance() {
        if (this instanceof Insurable) {
            return ((Insurable) this).calculateInsurance();
        }
        return 0.0;
    }

    public double calculateTotal() {
        return calculateShippingCharge() + getInsurance();
    }
}

class StandardParcel extends Parcel {
    public StandardParcel(double weight, double value) { super(weight, value); }
    @Override public double calculateShippingCharge() { return 40.0 + 10.0 * weightKg; }
    @Override public String getType() { return "STANDARD"; }
}

class ExpressParcel extends Parcel implements Insurable {
    public ExpressParcel(double weight, double value) { super(weight, value); }
    @Override public double calculateShippingCharge() { return 80.0 + 15.0 * weightKg; }
    @Override public double calculateInsurance() { return 0.02 * declaredValue; }
    @Override public String getType() { return "EXPRESS"; }
}

class FragileParcel extends Parcel implements Insurable {
    public FragileParcel(double weight, double value) { super(weight, value); }
    @Override public double calculateShippingCharge() { return (40.0 + 10.0 * weightKg) + 50.0; }
    @Override public double calculateInsurance() { return 0.02 * declaredValue; }
    @Override public String getType() { return "FRAGILE"; }
}

public class Problem2_ParcelShippingDesk {
    public static void main(String[] args) {
        String input = "3\nSTANDARD 3 500\nEXPRESS 2 1000\nFRAGILE 4 2000";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<Parcel> parcels = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double weight = sc.nextDouble();
            double value = sc.nextDouble();

            if (type.equals("STANDARD")) parcels.add(new StandardParcel(weight, value));
            else if (type.equals("EXPRESS")) parcels.add(new ExpressParcel(weight, value));
            else if (type.equals("FRAGILE")) parcels.add(new FragileParcel(weight, value));
        }

        double grandTotal = 0.0;
        for (Parcel p : parcels) {
            double charge = p.calculateShippingCharge();
            double ins = p.getInsurance();
            double total = p.calculateTotal();
            System.out.printf("%s: Charge=%.2f Insurance=%.2f Total=%.2f\n", p.getType(), charge, ins, total);
            grandTotal += total;
        }
        System.out.printf("Grand Total: %.2f\n", grandTotal);
    }
}