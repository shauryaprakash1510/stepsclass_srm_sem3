package week_8.set_1;

import java.util.*;

abstract class Transport {
    protected double distance;

    public Transport(double distance) {
        this.distance = distance;
    }

    public abstract double calculateFare();
    public abstract String getTypeName();
}

class Bus extends Transport {
    public Bus(double distance) { super(distance); }
    @Override
    public double calculateFare() {
        return Math.min(10.0, 2.0 + (0.10 * distance));
    }
    @Override
    public String getTypeName() { return "BUS"; }
}

class Train extends Transport {
    public Train(double distance) { super(distance); }
    @Override
    public double calculateFare() {
        return 3.0 + (0.15 * distance);
    }
    @Override
    public String getTypeName() { return "TRAIN"; }
}

class Metro extends Transport {
    private double peakHourFactor;
    public Metro(double distance, double peakHourFactor) {
        super(distance);
        this.peakHourFactor = peakHourFactor;
    }
    @Override
    public double calculateFare() {
        return (1.50 + (0.20 * distance)) * peakHourFactor;
    }
    @Override
    public String getTypeName() { return "METRO"; }
}

public class P5_TransportFare {
    public static void main(String[] args) {
        String input = "3\nBUS 15\nTRAIN 50\nMETRO 10 1.5";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<Transport> journeys = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            double distance = sc.nextDouble();
            if (type.equals("BUS")) journeys.add(new Bus(distance));
            else if (type.equals("TRAIN")) journeys.add(new Train(distance));
            else if (type.equals("METRO")) {
                double peak = sc.nextDouble();
                journeys.add(new Metro(distance, peak));
            }
        }

        double grandTotal = 0.0;
        for (Transport t : journeys) {
            double fare = t.calculateFare();
            System.out.printf("%s: %.2f\n", t.getTypeName(), fare);
            grandTotal += fare;
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}