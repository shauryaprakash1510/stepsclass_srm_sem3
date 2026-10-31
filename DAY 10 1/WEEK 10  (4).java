package week_10;

public class Problem6_ClassAttendanceTracker {

    public static class AttendanceResult {
        public final int present;
        public final int longestStreak;

        public AttendanceResult(int present, int longestStreak) {
            this.present = present;
            this.longestStreak = longestStreak;
        }

        @Override
        public String toString() {
            return String.format("Present: %d, Longest streak: %d", present, longestStreak);
        }
    }

    public static AttendanceResult attendanceSummary(int[] days) {
        int totalPresent = 0;
        int maxStreak = 0;
        int currentStreak = 0;

        for (int day : days) {
            if (day == 1) {
                totalPresent++;
                currentStreak++;
                if (currentStreak > maxStreak) {
                    maxStreak = currentStreak;
                }
            } else {
                currentStreak = 0;
            }
        }

        return new AttendanceResult(totalPresent, maxStreak);
    }

    public static void main(String[] args) {
        int[] sample1 = {1, 1, 0, 1, 1, 1, 0, 1};
        System.out.println(attendanceSummary(sample1)); 

        int[] sample2 = {0, 0, 0};
        System.out.println(attendanceSummary(sample2)); 
    }
}