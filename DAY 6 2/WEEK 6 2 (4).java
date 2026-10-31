package week_6.set_2;

class MessWallet {
    private double balance;

    public MessWallet(double openingBalance) {
        if (openingBalance < 0) {
            System.out.println("Warning: Opening balance cannot be negative. Initialized to 0.");
            this.balance = 0;
        } else {
            this.balance = openingBalance;
        }
    }

    public void topUp(double amount) {
        if (amount <= 0) {
            System.out.println("Top-up rejected: amount must be greater than zero.");
        } else {
            this.balance += amount;
            System.out.printf("Balance after top-up: %.1f\n", this.balance);
        }
    }

    public void deduct(double amount) {
        if (amount > this.balance) {
            System.out.println("Deduct rejected: insufficient balance");
        } else {
            this.balance -= amount;
        }
    }

    public double getBalance() {
        return this.balance;
    }
}

public class M2_HostelMessWallet {
    public static void main(String[] args) {
        MessWallet wallet = new MessWallet(500);
        wallet.topUp(200);
        wallet.deduct(1000);
        System.out.printf("Final balance: %.1f\n", wallet.getBalance());
    }
}