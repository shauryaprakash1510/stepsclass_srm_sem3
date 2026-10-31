import java.util.Arrays;

public class Problem5_DiceThrowTally {

    public static int[] diceSort(int[] rolls) {
        int[] count = new int[7];

        for (int r : rolls) {
            if (r >= 1 && r <= 6) {
                count[r]++;
            }
        }

        System.out.print("Counts: ");
        for (int v = 1; v <= 6; v++) {
            System.out.printf("%d:%d%s", v, count[v], (v == 6 ? "\n" : " "));
        }

        int[] sorted = new int[rolls.length];
        int idx = 0;
        for (int v = 1; v <= 6; v++) {
            for (int c = 0; c < count[v]; c++) {
                sorted[idx++] = v;
            }
        }

        return sorted;
    }

    public static void main(String[] args) {
        int[] rolls = {4, 1, 6, 4, 2, 1, 4};
        int[] sorted = diceSort(rolls);
        System.out.println("Sorted: " + Arrays.toString(sorted));

        int[] customRolls = {6, 6, 3, 2, 5, 2, 1};
        int[] customSorted = diceSort(customRolls);
        System.out.println("Sorted: " + Arrays.toString(customSorted));
    }
}