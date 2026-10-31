package week_10;

public class Problem4_ExamScoreBandCounter {

    private static int lowerBound(int[] scores, int low) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] >= low) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    private static int upperBound(int[] scores, int high) {
        int left = 0, right = scores.length;
        while (left < right) {
            int mid = left + (right - left) / 2;
            if (scores[mid] > high) {
                right = mid;
            } else {
                left = mid + 1;
            }
        }
        return left;
    }

    public static int countInBand(int[] scores, int low, int high) {
        int start = lowerBound(scores, low);
        int end = upperBound(scores, high);
        return Math.max(0, end - start);
    }

    public static void main(String[] args) {
        int[] scores = {35, 42, 42, 50, 58, 58, 58, 63, 71, 88};

        System.out.println(countInBand(scores, 42, 58)); 
        System.out.println(countInBand(scores, 90, 100));
    }
}