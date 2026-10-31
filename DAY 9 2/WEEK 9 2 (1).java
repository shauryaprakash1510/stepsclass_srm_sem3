package week_9;

import java.util.*;

// Common abstract base type for all plots
abstract class Plot {
    private String owner;

    public Plot(String owner) {
        this.owner = owner;
    }

    public String getOwner() {
        return owner;
    }

    public abstract double calculateArea();
    public abstract String getShape();
}

class CirclePlot extends Plot {
    private double radius;

    public CirclePlot(String owner, double radius) {
        super(owner);
        this.radius = radius;
    }

    @Override
    public double calculateArea() {
        return Math.PI * radius * radius;
    }

    @Override
    public String getShape() {
        return "CIRCLE";
    }
}

class RectanglePlot extends Plot {
    private double length;
    private double width;

    public RectanglePlot(String owner, double length, double width) {
        super(owner);
        this.length = length;
        this.width = width;
    }

    @Override
    public double calculateArea() {
        return length * width;
    }

    @Override
    public String getShape() {
        return "RECTANGLE";
    }
}

class TrianglePlot extends Plot {
    private double base;
    private double height;

    public TrianglePlot(String owner, double base, double height) {
        super(owner);
        this.base = base;
        this.height = height;
    }

    @Override
    public double calculateArea() {
        return 0.5 * base * height;
    }

    @Override
    public String getShape() {
        return "TRIANGLE";
    }
}

public class P1_GardenPlotArea {
    public static void main(String[] args) {
        String input = "3\nCIRCLE Asha 5\nRECTANGLE Ravi 4 6\nTRIANGLE Neha 10 3";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<Plot> plots = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String shape = sc.next();
            String owner = sc.next();
            if (shape.equals("CIRCLE")) {
                plots.add(new CirclePlot(owner, sc.nextDouble()));
            } else if (shape.equals("RECTANGLE")) {
                plots.add(new RectanglePlot(owner, sc.nextDouble(), sc.nextDouble()));
            } else if (shape.equals("TRIANGLE")) {
                plots.add(new TrianglePlot(owner, sc.nextDouble(), sc.nextDouble()));
            }
        }

        // Open-Closed Principle: reporting code never checks plot types
        double totalArea = 0.0;
        for (Plot p : plots) {
            double area = p.calculateArea();
            System.out.printf("%s (%s): %.2f\n", p.getOwner(), p.getShape(), area);
            totalArea += area;
        }
        System.out.printf("Total Area: %.2f\n", totalArea);
    }
}