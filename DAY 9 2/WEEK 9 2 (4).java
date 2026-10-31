package week_9;

import java.util.*;

abstract class Connection {
    protected int units;

    public Connection(int units) {
        this.units = units;
    }

    public abstract double calculateBill();
    public abstract String getType();
}

class HomeConnection extends Connection {
    public HomeConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        if (units <= 100) {
            return units * 5.0;
        } else {
            return (100 * 5.0) + ((units - 100) * 7.0);
        }
    }

    @Override
    public String getType() {
        return "HOME";
    }
}

class ShopConnection extends Connection {
    public ShopConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return (units * 8.0) + 100.0;
    }

    @Override
    public String getType() {
        return "SHOP";
    }
}

class FactoryConnection extends Connection {
    public FactoryConnection(int units) {
        super(units);
    }

    @Override
    public double calculateBill() {
        return Math.max(1000.0, units * 6.0);
    }

    @Override
    public String getType() {
        return "FACTORY";
    }
}

public class P4_ElectricityBilling {
    public static void main(String[] args) {
        String input = "3\nHOME 150\nSHOP 90\nFACTORY 120";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<Connection> connections = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int units = sc.nextInt();
            if (type.equals("HOME")) connections.add(new HomeConnection(units));
            else if (type.equals("SHOP")) connections.add(new ShopConnection(units));
            else if (type.equals("FACTORY")) connections.add(new FactoryConnection(units));
        }

        double grandTotal = 0.0;
        for (Connection c : connections) {
            double bill = c.calculateBill();
            System.out.printf("%s: %.2f\n", c.getType(), bill);
            grandTotal += bill;
        }
        System.out.printf("Total: %.2f\n", grandTotal);
    }
}