package week_7.set_1;

class Scorecard {
    private final int totalQuestions;
    private final boolean[] results;
    private int count;

    public Scorecard(int totalQuestions) {
        this.totalQuestions = totalQuestions;
        this.results = new boolean[totalQuestions];
        this.count = 0;
    }

    public void recordAnswer(boolean isCorrect) {
        if (count < totalQuestions) {
            results[count++] = isCorrect;
        }
    }

    public int getScore() {
        int score = 0;
        for (int i = 0; i < count; i++) {
            if (results[i]) score++;
        }
        return score;
    }
}

public class P2_QuizScorecard {
    public static void main(String[] args) {
        Scorecard sc = new Scorecard(4);
        sc.recordAnswer(true);
        sc.recordAnswer(true);
        sc.recordAnswer(false);
        sc.recordAnswer(true);
        System.out.println("sc.getScore() -> " + sc.getScore());
    }
}