package week_10_major;

public class Problem5_DigitSumAndReversal {
    public static void processNumber(int number) {
        int temp = number;
        int sum = 0;
        int reverse = 0;

        while (temp > 0) {
            int digit = temp % 10;
            sum += digit;
            reverse = (reverse * 10) + digit;
            temp /= 10;
        }

        System.out.println("Sum of digits: " + sum);
        System.out.println("Reverse: " + reverse);
    }

    public static void main(String[] args) {
        processNumber(4721);
    }
}