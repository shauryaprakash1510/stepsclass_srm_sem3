public class MatchDayGridAnalyzer {
    private static double rowAverage(int[] row) {
        if (row == null || row.length == 0) {
            return 0.0;
        }
        double sum = 0;
        for (int run : row) {
            sum += run;
        }
        return sum / row.length;
    }

    public static String classifyMatches(int[][] runsPerOver, int threshold) {
        StringBuilder sb = new StringBuilder();

        for (int i = 0; i < runsPerOver.length; i++) {
            double avg = rowAverage(runsPerOver[i]);
            String status = (avg >= threshold) ? "Power Surge" : "Normal";
            sb.append("Match ").append(i).append(": ").append(status);
            if (i < runsPerOver.length - 1) {
                sb.append(" | ");
            }
        }

        return sb.toString();
    }
}