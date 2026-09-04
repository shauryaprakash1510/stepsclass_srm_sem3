public class SeatDuplicationChecker {
    public static void checkDuplicateSeats(int[] seatNumbers) {
        boolean found = false;

        for (int i = 0; i < seatNumbers.length; i++) {
            boolean isDuplicate = false;
            for (int j = i + 1; j < seatNumbers.length; j++) {
                if (seatNumbers[i] == seatNumbers[j]) {
                    isDuplicate = true;
                    break;
                }
            }

            if (isDuplicate) {
                boolean alreadyReported = false;
                for (int k = 0; k < i; k++) {
                    if (seatNumbers[k] == seatNumbers[i]) {
                        alreadyReported = true;
                        break;
                    }
                }
                if (!alreadyReported) {
                    System.out.println("Duplicate Seat Number Found: " + seatNumbers[i]);
                    found = true;
                }
            }
        }

        if (!found) {
            System.out.println("No Duplicate Seats Found");
        }
    }
}
