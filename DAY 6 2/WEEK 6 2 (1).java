package week_6.set_2;

class Student {
    private String name;
    private int attendance;
    public static String collegeName = "SRM Institute of Science and Technology";
    public static int studentCount = 0;

    public Student(String name, int attendance) {
        this.name = name;
        this.attendance = attendance;
        studentCount++;
    }

    public static void printCollegeInfo() {
        System.out.println(collegeName);
        System.out.println("Students created: " + studentCount);
    }
}

public class M5_StudentCollegeInfo {
    public static void main(String[] args) {
        new Student("Asha", 95);
        new Student("Ravi", 88);

        Student.printCollegeInfo();
    }
}