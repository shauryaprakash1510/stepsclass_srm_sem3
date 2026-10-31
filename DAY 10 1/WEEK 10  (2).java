package week_10;

import java.util.Arrays;

public class Problem8_DutyRosterRotation {

    
    public static String[] rotateRoster(String[] names, long k) {
        int n = names.length;
        if (n == 0) return names;

        int shift = (int) (k % n);
        String[] result = new String[n];

        for (int i = 0; i < n; i++) {
            int newIndex = (i + shift) % n;
            result[newIndex] = names[i];
        }

        return result;
    }

    public static void main(String[] args) {
        String[] names = {"A", "B", "C", "D", "E"};

        System.out.println(Arrays.toString(rotateRoster(names, 2))); 
        System.out.println(Arrays.toString(rotateRoster(names, 7))); 
    }
}