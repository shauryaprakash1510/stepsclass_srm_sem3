package week_6.set_1;

class HallTicket {
    String studentName;
    int seatNumber;

    public HallTicket(String studentName, int seatNumber) {
        this.studentName = studentName;
        this.seatNumber = seatNumber;
    }
}

public class M4_ExamHallTicket {
    public static void main(String[] args) {
        HallTicket priya = new HallTicket("Priya", 0);
        HallTicket copy = priya;

        copy.seatNumber = 45;
        System.out.printf("Priya's seatNumber (via first variable): %d\n", priya.seatNumber);
        System.out.println("copy == priya: " + (copy == priya));

        HallTicket separate = new HallTicket("Priya", 45);
        System.out.println("separate == priya: " + (separate == priya));
    }
}