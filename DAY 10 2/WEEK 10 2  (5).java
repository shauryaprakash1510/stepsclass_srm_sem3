package week_10_major;

public class Problem6_PrimeChecker {
    public static boolean isPrime(int n) {
        if (n <= 1) return false;
        for (int i = 2; i * i <= n; i++) {
            if (n % i == 0) return false;
        }
        return true;
    }

    public static void checkAndPrint(int n) {
        if (isPrime(n)) {
            System.out.println(n + " is prime");
        } else {
            System.out.println(n + " is not prime");
        }
    }

    public static void main(String[] args) {
        checkAndPrint(29);
        checkAndPrint(21);
    }
}