package week_9.set_1;

import java.util.*;

interface SaverModeSupported {}

abstract class Appliance {
    protected double hours;

    public Appliance(double hours) {
        this.hours = hours;
    }

    public abstract double getPowerRating();
    public abstract String getApplianceName();

    public double calculateUnits(boolean saverRequested) throws UnsupportedOperationException {
        if (saverRequested && !(this instanceof SaverModeSupported)) {
            throw new UnsupportedOperationException("saver mode not supported");
        }
        double units = (getPowerRating() * hours) / 1000.0;
        if (saverRequested) {
            units *= 0.75;
        }
        return units;
    }

    public double calculateCost(double units) {
        return units * 8.0;
    }
}

class Fridge extends Appliance {
    public Fridge(double hours) { super(hours); }
    @Override public double getPowerRating() { return 150.0; }
    @Override public String getApplianceName() { return "FRIDGE"; }
}

class AC extends Appliance implements SaverModeSupported {
    public AC(double hours) { super(hours); }
    @Override public double getPowerRating() { return 1500.0; }
    @Override public String getApplianceName() { return "AC"; }
}

class TV extends Appliance {
    public TV(double hours) { super(hours); }
    @Override public double getPowerRating() { return 100.0; }
    @Override public String getApplianceName() { return "TV"; }
}

class Washer extends Appliance implements SaverModeSupported {
    public Washer(double hours) { super(hours); }
    @Override public double getPowerRating() { return 500.0; }
    @Override public String getApplianceName() { return "WASHER"; }
}

public class Problem5_HomeApplianceEnergyReport {
    public static void main(String[] args) {
        String input = "4\nFRIDGE 24\nAC 8 SAVER\nTV 5\nWASHER 2 SAVER";
        Scanner sc = new Scanner(input);

        int n = Integer.parseInt(sc.nextLine().trim());
        double totalCost = 0.0;

        for (int i = 0; i < n; i++) {
            String line = sc.nextLine().trim();
            String[] tokens = line.split("\\s+");
            String type = tokens[0];
            double hours = Double.parseDouble(tokens[1]);
            boolean saver = tokens.length > 2 && tokens[2].equalsIgnoreCase("SAVER");

            Appliance app = null;
            if (type.equals("FRIDGE")) app = new Fridge(hours);
            else if (type.equals("AC")) app = new AC(hours);
            else if (type.equals("TV")) app = new TV(hours);
            else if (type.equals("WASHER")) app = new Washer(hours);

            try {
                double units = app.calculateUnits(saver);
                double cost = app.calculateCost(units);
                System.out.printf("%s: Units=%.2f Cost=%.2f\n", app.getApplianceName(), units, cost);
                totalCost += cost;
            } catch (UnsupportedOperationException e) {
                System.out.printf("%s: %s\n", app.getApplianceName(), e.getMessage());
            }
        }
        System.out.printf("Total Cost: %.2f\n", totalCost);
    }
}