package week_9;

import java.util.*;

abstract class Booking {
    protected double distanceKm;
    // Common fee specified in exactly one place
    private static final double BOOKING_FEE = 50.0;

    public Booking(double distanceKm) {
        this.distanceKm = distanceKm;
    }

    protected abstract double calculateBaseFare();
    public abstract String getMode();

    // Final template method adding the shared fee
    public final double calculateTotalFare() {
        return calculateBaseFare() + BOOKING_FEE;
    }
}

class BusBooking extends Booking {
    public BusBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 2.0;
    }

    @Override
    public String getMode() {
        return "BUS";
    }
}

class TrainBooking extends Booking {
    public TrainBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return distanceKm * 1.5;
    }

    @Override
    public String getMode() {
        return "TRAIN";
    }
}

class FlightBooking extends Booking {
    public FlightBooking(double distanceKm) {
        super(distanceKm);
    }

    @Override
    protected double calculateBaseFare() {
        return 2500.0 + (distanceKm * 4.0);
    }

    @Override
    public String getMode() {
        return "FLIGHT";
    }
}

public class P5_TravelBooking {
    public static void main(String[] args) {
        String input = "3\nBUS 200\nTRAIN 300\nFLIGHT 500";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<Booking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String mode = sc.next();
            double distance = sc.nextDouble();

            if (mode.equals("BUS")) bookings.add(new BusBooking(distance));
            else if (mode.equals("TRAIN")) bookings.add(new TrainBooking(distance));
            else if (mode.equals("FLIGHT")) bookings.add(new FlightBooking(distance));
        }

        for (Booking b : bookings) {
            System.out.printf("%s: %.2f\n", b.getMode(), b.calculateTotalFare());
        }
    }
}