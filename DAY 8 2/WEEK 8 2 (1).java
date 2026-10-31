package week_8.set_2;

import java.time.LocalDate;
import java.util.*;

abstract class StreamingPlan {
    protected String subscriberName;
    protected LocalDate startDate;

    public StreamingPlan(String subscriberName, LocalDate startDate) {
        this.subscriberName = subscriberName;
        this.startDate = startDate;
    }

    public abstract LocalDate calculateRenewalDate();
    public String getSubscriberName() { return subscriberName; }
}

class BasicPlan extends StreamingPlan {
    public BasicPlan(String name, LocalDate date) { super(name, date); }
    @Override
    public LocalDate calculateRenewalDate() { return startDate.plusDays(30); }
}

class StandardPlan extends StreamingPlan {
    public StandardPlan(String name, LocalDate date) { super(name, date); }
    @Override
    public LocalDate calculateRenewalDate() { return startDate.plusDays(90); }
}

class PremiumPlan extends StreamingPlan {
    public PremiumPlan(String name, LocalDate date) { super(name, date); }
    @Override
    public LocalDate calculateRenewalDate() { return startDate.plusDays(365); }
}

public class P5_StreamingPlanRenewal {
    public static void main(String[] args) {
        String input = "4\nBASIC Asha 2024-01-15\nSTANDARD Ravi 2024-02-01\nPREMIUM Neha 2024-03-10\nBASIC Kiran 2024-12-20";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<StreamingPlan> plans = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String planType = sc.next();
            String name = sc.next();
            LocalDate date = LocalDate.parse(sc.next());

            if (planType.equals("BASIC")) plans.add(new BasicPlan(name, date));
            else if (planType.equals("STANDARD")) plans.add(new StandardPlan(name, date));
            else if (planType.equals("PREMIUM")) plans.add(new PremiumPlan(name, date));
        }

        for (StreamingPlan plan : plans) {
            System.out.printf("%s: %s\n", plan.getSubscriberName(), plan.calculateRenewalDate());
        }
    }
}