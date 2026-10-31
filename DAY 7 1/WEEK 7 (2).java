package week_7.set_1;

class PiggyBank {
    private final String id;
    private int savings;

    public PiggyBank(String id) {
        this.id = id;
        this.savings = 0;
    }

    public void deposit(int amount) {
        if (amount > 0) {
            this.savings += amount;
            System.out.println("savings = " + this.savings);
        }
    }

    public void withdraw(int amount) {
        if (amount > 0 && amount <= this.savings) {
            this.savings -= amount;
            System.out.println("savings = " + this.savings);
        } else {
            System.out.println("rejected, savings stays " + this.savings);
        }
    }

    public int getSavings() {
        return this.savings;
    }

    public String getId() {
        return id;
    }
}

public class P1_PiggyBank {
    public static void main(String[] args) {
        PiggyBank pb = new PiggyBank("PB-1");
        pb.deposit(100);
        pb.withdraw(30);
        pb.withdraw(500);
    }
}