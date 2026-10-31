package week_6.set_2;

class Course {
    private String code;
    private String title;
    private int credits;
    private int labCredits;

    public Course(String code, String title, int credits, int labCredits) {
        this.code = code;
        this.title = title;
        this.credits = credits;
        this.labCredits = labCredits;
    }

    public Course(String code, String title, int credits) {
        this(code, title, credits, 0);
    }

    public int totalCredits() {
        return this.credits + this.labCredits;
    }

    public String getCode() {
        return code;
    }
}

public class M3_CourseCredits {
    public static void main(String[] args) {
        Course theory = new Course("21CSC201J", "Data Structures", 4);
        Course labCourse = new Course("21CSC205L", "DSA Lab", 3, 1);

        System.out.printf("%s total credits: %d\n", theory.getCode(), theory.totalCredits());
        System.out.printf("%s total credits: %d\n", labCourse.getCode(), labCourse.totalCredits());
    }
}