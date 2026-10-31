package week_10_major;

public class Problem2_WordReverserPalindrome {
    public static void checkPalindrome(String word) {
        StringBuilder sb = new StringBuilder(word);
        String reversed = sb.reverse().toString();

        System.out.println(reversed);
        if (word.equalsIgnoreCase(reversed)) {
            System.out.println("palindrome");
        } else {
            System.out.println("not a palindrome");
        }
    }

    public static void main(String[] args) {
        checkPalindrome("level");
        checkPalindrome("java");
    }
}