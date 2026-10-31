import java.util.Arrays;

public class Problem2_PrizeTable {

    public static int prizeTable(int[] marks) {
        int n = marks.length;
        int swaps = 0;

        for (int i = 0; i < n - 1; i++) {
            int maxIdx = i;

            for (int j = i + 1; j < n; j++) {
                if (marks[j] > marks[maxIdx]) {
                    maxIdx = j;
                }
            }

            if (maxIdx != i) {
                int temp = marks[i];
                marks[i] = marks[maxIdx];
                marks[maxIdx] = temp;
                swaps++;
            }
        }

        return swaps;
    }

    public static void main(String[] args) {
        int[] marks1 = {45, 90, 60, 75};
        int s1 = prizeTable(marks1);
        System.out.println(Arrays.toString(marks1));
        System.out.println("swaps = " + s1);

        int[] marks2 = {80, 70, 60};
        int s2 = prizeTable(marks2);
        System.out.println(Arrays.toString(marks2));
        System.out.println("swaps = " + s2);

        int[] custom = {25, 50, 75, 100};
        int s3 = prizeTable(custom);
        System.out.println(Arrays.toString(custom));
        System.out.println("swaps = " + s3);
    }
}