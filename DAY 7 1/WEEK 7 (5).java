package week_7.set_1;

class Locker {
    private final int lockerNumber;
    private String combinationCode;

    public Locker(int lockerNumber, String initialCode) {
        this.lockerNumber = lockerNumber;
        this.combinationCode = initialCode;
    }

    public boolean changeCode(String oldCode, String newCode) {
        if (this.combinationCode.equals(oldCode)) {
            this.combinationCode = newCode;
            System.out.println("success");
            return true;
        } else {
            System.out.println("rejected, code is unchanged");
            return false;
        }
    }

    public int getLockerNumber() {
        return lockerNumber;
    }
}

public class P4_LockerCode {
    public static void main(String[] args) {
        Locker l = new Locker(101, "1234");
        l.changeCode("1234", "5678");
        l.changeCode("0000", "9999");
    }
}