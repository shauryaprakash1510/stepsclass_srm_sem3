package week_6.set_1;

class EmployeeInfo {
    private String empName;
    private double salary;
    public static String companyName = "Bright Horizon Technologies";
    public static int employeeCount = 0;

    public EmployeeInfo(String empName, double salary) {
        this.empName = empName;
        this.salary = salary;
        employeeCount++;
    }

    public static void printCompanyInfo() {
        System.out.println(companyName);
        System.out.println("Employees on record: " + employeeCount);
    }
}

public class M5_EmployeeCompanyInfo {
    public static void main(String[] args) {
        new EmployeeInfo("Asha", 50000);
        new EmployeeInfo("Ravi", 60000);
        new EmployeeInfo("Neha", 70000);

        EmployeeInfo.printCompanyInfo();
    }
}