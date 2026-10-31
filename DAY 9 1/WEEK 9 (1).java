package week_9.set_1;

import java.util.*;

abstract class TicketBooking {
    protected int count;
    public static final double CONVENIENCE_FEE = 20.0;

    public TicketBooking(int count) {
        this.count = count;
    }

    public abstract double getBasePricePerTicket();
    public abstract String getSeatType();

    public double calculateTotal() {
        return count * (getBasePricePerTicket() + CONVENIENCE_FEE);
    }
}

class RegularBooking extends TicketBooking {
    public RegularBooking(int count) { super(count); }
    @Override public double getBasePricePerTicket() { return 150.0; }
    @Override public String getSeatType() { return "REGULAR"; }
}

class PremiumBooking extends TicketBooking {
    public PremiumBooking(int count) { super(count); }
    @Override public double getBasePricePerTicket() { return 250.0; }
    @Override public String getSeatType() { return "PREMIUM"; }
}

class ReclinerBooking extends TicketBooking {
    public ReclinerBooking(int count) { super(count); }
    @Override public double getBasePricePerTicket() { return 400.0; }
    @Override public String getSeatType() { return "RECLINER"; }
}

public class Problem1_MovieTicketCounter {
    public static void main(String[] args) {
        String input = "3\nREGULAR 3\nPREMIUM 2\nRECLINER 1";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<TicketBooking> bookings = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            int count = sc.nextInt();
            if (type.equals("REGULAR")) bookings.add(new RegularBooking(count));
            else if (type.equals("PREMIUM")) bookings.add(new PremiumBooking(count));
            else if (type.equals("RECLINER")) bookings.add(new ReclinerBooking(count));
        }

        double total = 0.0;
        for (TicketBooking b : bookings) {
            double amt = b.calculateTotal();
            System.out.printf("%s: %.2f\n", b.getSeatType(), amt);
            total += amt;
        }
        System.out.printf("Total: %.2f\n", total);
    }
}