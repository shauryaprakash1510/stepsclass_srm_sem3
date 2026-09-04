public class FirstNonRepeatingChar {
    public static char findFirstNonRepeatingChar(String text) {
        int[] freq = new int[256];

        for (int i = 0; i < text.length(); i++) {
            freq[text.charAt(i)]++;
        }

        for (int i = 0; i < text.length(); i++) {
            if (freq[text.charAt(i)] == 1) {
                return text.charAt(i);
            }
        }

        return '\0';
    }

    public static void displayFirstNonRepeatingChar(String text) {
        char ch = findFirstNonRepeatingChar(text);
        if (ch != '\0') {
            System.out.println("First Non-Repeating Character: '" + ch + "'");
        } else {
            System.out.println("No Non-Repeating Character Found");
        }
    }
}