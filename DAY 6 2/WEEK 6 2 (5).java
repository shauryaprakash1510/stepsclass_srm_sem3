package week_6.set_2;

class PlacementRecord {
    private String studentName;
    private String company;
    private double packageLpa;

    public PlacementRecord(String studentName, String company, double packageLpa) {
        this.studentName = studentName;
        this.company = company;
        this.packageLpa = packageLpa;
    }

    public void printRecord() {
        System.out.printf("%s -> %s @ %.1f LPA\n", studentName, company, packageLpa);
    }
}

public class M1_PlacementRecord {
    public static void main(String[] args) {
        PlacementRecord[] records = new PlacementRecord[] {
            new PlacementRecord("Ravi", "TCS", 4.5),
            new PlacementRecord("Anitha", "Zoho", 6.2),
            new PlacementRecord("Karthik", "Infosys", 4.0)
        };

        for (PlacementRecord r : records) {
            r.printRecord();
        }
    }
}