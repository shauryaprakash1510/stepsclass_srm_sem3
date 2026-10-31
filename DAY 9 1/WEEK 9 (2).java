package week_9.set_1;

import java.util.*;

interface UsesTransport {
    default double getTransportFee() { return 12000.0; }
}

abstract class StudentFee {
    protected String name;

    public StudentFee(String name) {
        this.name = name;
    }

    public abstract double calculateTuition();
    public String getName() { return name; }

    public double calculateTotalFee() {
        double fee = calculateTuition();
        if (this instanceof UsesTransport) {
            fee += ((UsesTransport) this).getTransportFee();
        }
        return fee;
    }
}

class DayScholarStudent extends StudentFee implements UsesTransport {
    public DayScholarStudent(String name) { super(name); }
    @Override public double calculateTuition() { return 40000.0; }
}

class HostellerStudent extends StudentFee {
    public HostellerStudent(String name) { super(name); }
    @Override public double calculateTuition() { return 40000.0 + 60000.0; }
}

class ScholarshipStudent extends StudentFee implements UsesTransport {
    public ScholarshipStudent(String name) { super(name); }
    @Override public double calculateTuition() { return 20000.0; }
}

public class Problem3_CollegeFeeCounter {
    public static void main(String[] args) {
        String input = "3\nDAY_SCHOLAR Asha\nHOSTELLER Ravi\nSCHOLAR Neha";
        Scanner sc = new Scanner(input);

        int n = sc.nextInt();
        List<StudentFee> students = new ArrayList<>();

        for (int i = 0; i < n; i++) {
            String type = sc.next();
            String name = sc.next();
            if (type.equals("DAY_SCHOLAR")) students.add(new DayScholarStudent(name));
            else if (type.equals("HOSTELLER")) students.add(new HostellerStudent(name));
            else if (type.equals("SCHOLAR")) students.add(new ScholarshipStudent(name));
        }

        double totalCollected = 0.0;
        for (StudentFee s : students) {
            double fee = s.calculateTotalFee();
            System.out.printf("%s: %.2f\n", s.getName(), fee);
            totalCollected += fee;
        }
        System.out.printf("Total Collected: %.2f\n", totalCollected);
    }
}