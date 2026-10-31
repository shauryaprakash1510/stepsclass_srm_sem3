package week_10_major;

public class Problem3_EvenOddListCounter {
    public static void countEvenOdd(int[] numbers) {
        int evenCount = 0;
        int oddCount = 0;

        for (int num : numbers) {
            if (num % 2 == 0) {
                evenCount++;
            } else {
                oddCount++;
            }
        }

        System.out.println("Even: " + evenCount);
        System.out.println("Odd: " + oddCount);
    }

    public static void main(String[] args) {
        int[] numbers = {3, 8, 12, 5, 7, 10};
        countEvenOdd(numbers);
    }
}