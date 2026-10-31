package week_10;

public class Problem7_SecondBestScore {

   
    public static int secondHighest(int[] scores) {
        int highest = -1;
        int second = -1;

        for (int s : scores) {
            if (s > highest) {
                second = highest;
                highest = s;
            } else if (s < highest && s > second) {
                second = s;
            }
        }

        return second;
    }

    public static void main(String[] args) {
        int[] sample1 = {45, 78, 92, 78, 60};
        System.out.println(secondHighest(sample1)); 

        int[] sample2 = {50, 50, 50};
        System.out.println(secondHighest(sample2));
    }
}