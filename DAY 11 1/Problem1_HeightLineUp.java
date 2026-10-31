import java.util.Arrays;

public class Problem1_HeightLineUp {

    public static void lineUp(int[] heights) {
        int n = heights.length;
        int pass = 1;

        for (int i = 0; i < n; i++) {
            boolean swapped = false;

            for (int j = 0; j < n - 1 - i; j++) {
                if (heights[j] > heights[j + 1]) {
                    int temp = heights[j];
                    heights[j] = heights[j + 1];
                    heights[j + 1] = temp;
                    swapped = true;
                }
            }

            System.out.printf("Pass %d: %s\n", pass++, Arrays.toString(heights));

            if (!swapped) {
                break;
            }
        }
    }

    public static void main(String[] args) {
        int[] heights1 = {4, 2, 5, 1};
        lineUp(heights1);

        int[] heights2 = {1, 3, 2, 4};
        lineUp(heights2);

        int[] custom = {5, 4, 3, 2, 1};
        lineUp(custom);
    }
}