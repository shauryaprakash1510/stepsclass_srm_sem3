package week_10;

public class Problem10_BusiestBusRow {

    public static void busiestRow(int[][] grid) {
        int maxRowIndex = 0;
        int maxTotal = -1;

        for (int i = 0; i < grid.length; i++) {
            int rowTotal = 0;
            for (int j = 0; j < grid[i].length; j++) {
                rowTotal += grid[i][j];
            }

            if (rowTotal > maxTotal) {
                maxTotal = rowTotal;
                maxRowIndex = i;
            }
        }

        System.out.printf("Row %d, Total %d\n", maxRowIndex, maxTotal);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {2, 0, 1},
            {3, 3, 1},
            {1, 1, 1}
        };

        busiestRow(grid);
    }
}