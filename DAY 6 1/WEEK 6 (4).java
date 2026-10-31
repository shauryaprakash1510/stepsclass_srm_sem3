package week_6.set_1;

class PayrollAccount {
    private double basicSalary;
    private double bonus;

    public PayrollAccount(double openingSalary) {
        if (openingSalary < 0) {
            System.out.println("Warning: Basic salary cannot be negative. Initialized to 0.");
            this.basicSalary = 0;
        } else {
            this.basicSalary = openingSalary;
        }
        this.bonus = 0.0;
    }

    public void creditBonus(double amount) {
        if (amount <= 0) {
            System.out.println("Credit rejected: bonus amount must be greater than zero.");
        } else {
            this.bonus += amount;
            System.out.printf("Bonus credited: Rs %.1f\n", amount);
        }
    }

    public void deductTax(double percent) {
        if (percent < 0 || percent > 100) {
            System.out.println("Deduction rejected: invalid tax percentage.");
        } else {
            this.basicSalary -= (this.basicSalary * percent / 100.0);
            System.out.printf("Tax deducted: %.0f%%\n", percent);
        }
    }

    public double getNetSalary() {
        return this.basicSalary + this.bonus;
    }
}

public class M2_PayrollSalary {
    public static void main(String[] args) {
        PayrollAccount account = new PayrollAccount(50000);
        account.creditBonus(5000);
        account.deductTax(10);
        System.out.printf("Net salary: Rs %.1f\n", account.getNetSalary());
    }
}