package week_8.set_2;

import java.util.*;

abstract class Room {
    protected int units;

    public Room(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getRoomType();
}

class SingleRoom extends Room {
    public SingleRoom(int units) { super(units); }
    @Override
    public double calculateBill() { return units * 8.0; }
    @Override
    public String getRoomType() { return "SINGLE"; }
}

class SharedRoom extends Room {
    private int occupants;
    public SharedRoom(int units, int occupants) {
        super(units);
        this.occupants = occupants;
    }
    @Override
    public double calculateBill() { return (units * 6.0) / occupants; }
    @Override
    public String getRoomType() { return "SHARED"; }
}

class ACRoom extends Room {
    public ACRoom(int units) { super(units); }
    @Override
    public double calculateBill() { return (units * 10.0) + 200.0; }
    @Override
    public String getRoomType() { return "AC"; }
}

public class P3_HostelElectricity {
    public static void main(String[] args) {
        String input = "3\nSINGLE 120\nSHARED 150 3\nAC 100";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<Room> rooms = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            if (type.equals("SINGLE")) {
                rooms.add(new SingleRoom(units));
            } else if (type.equals("SHARED")) {
                int occupants = sc.nextInt();
                rooms.add(new SharedRoom(units, occupants));
            } else if (type.equals("AC")) {
                rooms.add(new ACRoom(units));
            }
        }

        double grandTotal = 0.0;
        for (Room r : rooms) {
            double bill = r.calculateBill();
            System.out.printf("%s: %.2f\n", r.getRoomType(), bill);
            grandTotal += bill;
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}