package week_10_major;

public class Problem7_FactorialCalculation {
    public static long calculateFactorial(int n) {
        long fact = 1;
        for (int i = 1; i <= n; i++) {
            fact *= i;
        }
        return fact;
    }

    public static void main(String[] args) {
        System.out.println(calculateFactorial(5));
        System.out.println(calculateFactorial(0));
    }
}