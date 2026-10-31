import java.util.Arrays;

public class Problem3_LibraryBookShelf {

    public static void shelf(int[] books) {
        int n = books.length;

        for (int i = 1; i < n; i++) {
            int key = books[i];
            int j = i - 1;

            while (j >= 0 && books[j] > key) {
                books[j + 1] = books[j];
                j--;
            }
            books[j + 1] = key;

            System.out.printf("After placing %d: %s\