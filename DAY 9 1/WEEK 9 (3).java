package week_9.set_1;

import java.util.*;

interface NightServiceable {}

abstract class Cab {
    protected double km;

    public Cab(double km) {
        this.km = km;
    }

    public abstract double getRatePerKm();
    public abstract String getCabType();

    public double calculateFare(boolean isNight) throws UnsupportedOperationException {
        if (isNight && !(this instanceof NightServiceable)) {
            throw new UnsupportedOperationException("night service not available");
        }
        double fare = Math.max(100.0, km * getRatePerKm());
        if (isNight) {
            fare += fare * 0.20;
        }
        return fare;
    }
}

class MiniCab extends Cab {
    public MiniCab(double km) { super(km); }
    @Override public double getRatePerKm() { return 10.0; }
    @Override public String getCabType() { return "MINI"; }
}

class SedanCab extends Cab implements NightServiceable {
    public SedanCab(double km) { super(km); }
    @Override public double getRatePerKm() { return 14.0; }
    @Override public String getCabType() { return "SEDAN"; }
}

class SUVCab extends Cab implements NightServiceable {
    public SUVCab(double km) { super(km); }
    @Override public double getRatePerKm() { return 18.0; }
    @Override public String getCabType() { return "SUV"; }
}

public class Problem4_CityCabFareMeter {
    public static void main(String[] args) {
        String input = "4\nMINI 8 DAY\nSEDAN 10 NIGHT\nSUV 20 DAY\nMINI 5 NIGHT";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        double total = 0.0;

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double km = sc.nextDouble();
            String time = sc.next();
            boolean isNight = time.equalsIgnoreCase("NIGHT");

            Cab cab = null;
            if (type.equals("MINI")) cab = new MiniCab(km);
            else if (type.equals("SEDAN")) cab = new SedanCab(km);
            else if (type.equals("SUV")) cab = new SUVCab(km);

            try {
                double fare = cab.calculateFare(isNight);
                System.out.printf("%s: %.2f\n", cab.getCabType(), fare);
                total += fare;
            } catch (UnsupportedOperationException e) {
                System.out.printf("%s: %s\n", cab.getCabType(), e.getMessage());
            }
        }
        System.out.printf("Total: %.2f\n", total);
    }
}