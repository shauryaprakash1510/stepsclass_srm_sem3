public class Problem2_WarehouseBinGridScan {

    public static class Summary {
        public int total;
        public int row;
        public int col;

        public Summary(int total, int row, int col) {
            this.total = total;
            this.row = row;
            this.col = col;
        }

        @Override
        public String toString() {
            return "total = " + total + ", maxCoordinate = (" + row + "," + col + ")";
        }
    }

    public static Summary warehouseSummary(int[][] grid) {
        int total = 0;
        int maxVal = -1;
        int maxRow = 0;
        int maxCol = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                total += grid[i][j];
                if (grid[i][j] > maxVal) {
                    maxVal = grid[i][j];
                    maxRow = i;
                    maxCol = j;
                }
            }
        }

        return new Summary(total, maxRow, maxCol);
    }

    public static void main(String[] args) {
        int[][] grid = {
            {4, 9, 2},
            {7, 1, 6},
            {3, 12, 5}
        };

        System.out.println(warehouseSummary(grid));
    }
}