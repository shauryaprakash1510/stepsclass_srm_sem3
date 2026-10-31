package week_9;

import java.util.*;

abstract class LibraryItem {
    protected String title;
    protected int daysLate;

    public LibraryItem(String title, int daysLate) {
        this.title = title;
        this.daysLate = daysLate;
    }

    public String getTitle() {
        return title;
    }

    public abstract double calculateFine();
}

class Book extends LibraryItem {
    public Book(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 2.0;
    }
}

class DVD extends LibraryItem {
    public DVD(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return Math.min(50.0, daysLate * 5.0);
    }
}

class Magazine extends LibraryItem {
    public Magazine(String title, int daysLate) {
        super(title, daysLate);
    }

    @Override
    public double calculateFine() {
        return daysLate * 1.0;
    }
}

public class P3_LibraryLateFine {
    public static void main(String[] args) {
        String input = "3\nBOOK Algebra 4\nDVD Inception 12\nMAGAZINE Sports 3";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<LibraryItem> items = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String title = sc.next();
            int days = sc.nextInt();

            if (type.equals("BOOK")) items.add(new Book(title, days));
            else if (type.equals("DVD")) items.add(new DVD(title, days));
            else if (type.equals("MAGAZINE")) items.add(new Magazine(title, days));
        }

        double totalFines = 0.0;
        for (LibraryItem item : items) {
            double fine = item.calculateFine();
            System.out.printf("%s: %.2f\n", item.getTitle(), fine);
            totalFines += fine;
        }
        System.out.printf("Total Fines: %.2f\n", totalFines);
    }
}