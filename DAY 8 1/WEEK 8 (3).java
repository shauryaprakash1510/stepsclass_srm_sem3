package week_8.set_1;

import java.util.*;

abstract class Question {
    protected String questionText;
    protected String correctAnswer;
    protected String studentAnswer;
    protected int points;

    public Question(String questionText, String correctAnswer, String studentAnswer, int points) {
        this.questionText = questionText;
        this.correctAnswer = correctAnswer;
        this.studentAnswer = studentAnswer;
        this.points = points;
    }

    public abstract double evaluateScore();
    public abstract String getTypeName();
}

class MCQQuestion extends Question {
    public MCQQuestion(String q, String c, String s, int p) { super(q, c, s, p); }
    @Override
    public double evaluateScore() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
    }
    @Override
    public String getTypeName() { return "MCQ"; }
}

class TFQuestion extends Question {
    public TFQuestion(String q, String c, String s, int p) { super(q, c, s, p); }
    @Override
    public double evaluateScore() {
        return correctAnswer.equalsIgnoreCase(studentAnswer) ? points : 0.0;
    }
    @Override
    public String getTypeName() { return "TF"; }
}

class EssayQuestion extends Question {
    public EssayQuestion(String q, String c, String s, int p) { super(q, c, s, p); }
    @Override
    public double evaluateScore() {
        String[] keywords = correctAnswer.split(",");
        String studentAnsLower = studentAnswer.toLowerCase();
        int matches = 0;
        for (String kw : keywords) {
            if (studentAnsLower.contains(kw.trim().toLowerCase())) {
                matches++;
            }
        }

        if (matches >= 2) return 0.75 * points;
        else if (matches == 1) return 0.50 * points;
        else return 0.0;
    }
    @Override
    public String getTypeName() { return "ESSAY"; }
}

public class P4_QuestionGrader {
    public static void main(String[] args) {
        List<Question> questions = new ArrayList<>();
        questions.add(new MCQQuestion("What is the capital of France?", "Paris", "Paris", 10));
        questions.add(new TFQuestion("The Earth is flat?", "False", "True", 5));
        questions.add(new EssayQuestion("Name two primary OOP principles.", "Inheritance, Polymorphism, Encapsulation", "Polymorphism is one.", 20));
        questions.add(new EssayQuestion("Describe abstraction and composition.", "Abstraction, Composition", "I talked about abstraction.", 15));

        double totalScore = 0.0;
        for (Question q : questions) {
            double score = q.evaluateScore();
            System.out.printf("%s: %.2f\n", q.getTypeName(), score);
            totalScore += score;
        }
        System.out.printf("Total Score: %.2f\n", totalScore);
    }
}