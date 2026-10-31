package week_8.set_2;

import java.util.*;

abstract class Vehicle {
    protected int hours;

    public Vehicle(int hours) {
        this.hours = hours;
    }

    public abstract double calculateCharge();
    public abstract String getVehicleType();
}

class Bike extends Vehicle {
    public Bike(int hours) { super(hours); }
    @Override
    public double calculateCharge() { return hours * 10.0; }
    @Override
    public String getVehicleType() { return "BIKE"; }
}

class Car extends Vehicle {
    public Car(int hours) { super(hours); }
    @Override
    public double calculateCharge() {
        if (hours <= 1) return 30.0;
        return 30.0 + (hours - 1) * 20.0;
    }
    @Override
    public String getVehicleType() { return "CAR"; }
}

class Truck extends Vehicle {
    public Truck(int hours) { super(hours); }
    @Override
    public double calculateCharge() {
        return Math.max(100.0, hours * 50.0);
    }
    @Override
    public String getVehicleType() { return "TRUCK"; }
}

public class P2_CampusParking {
    public static void main(String[] args) {
        String input = "4\nBIKE 3\nCAR 4\nTRUCK 1\nCAR 1";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<Vehicle> vehicles = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int hours = sc.nextInt();
            if (type.equals("BIKE")) vehicles.add(new Bike(hours));
            else if (type.equals("CAR")) vehicles.add(new Car(hours));
            else if (type.equals("TRUCK")) vehicles.add(new Truck(hours));
        }

        double grandTotal = 0.0;
        for (Vehicle v : vehicles) {
            double charge = v.calculateCharge();
            System.out.printf("%s: %.2f\n", v.getVehicleType(), charge);
            grandTotal += charge;
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}