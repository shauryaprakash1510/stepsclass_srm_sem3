import java.util.Random;

public class RockPaperScissorsGame {
    public static String playRound(String playerMove, String computerMove) {
        if (playerMove.equalsIgnoreCase(computerMove)) {
            return "Draw";
        }
        if ((playerMove.equalsIgnoreCase("Rock") && computerMove.equalsIgnoreCase("Scissors")) ||
            (playerMove.equalsIgnoreCase("Paper") && computerMove.equalsIgnoreCase("Rock")) ||
            (playerMove.equalsIgnoreCase("Scissors") && computerMove.equalsIgnoreCase("Paper"))) {
            return "Player Wins";
        }
        return "Computer Wins";
    }

    public static void runSimulation(String[] playerMoves) {
        String[] moves = {"Rock", "Paper", "Scissors"};
        Random random = new Random();
        int wins = 0;
        int losses = 0;
        int draws = 0;

        System.out.printf("%-8s | %-12s | %-14s | %-14s%n", "Round", "Player Move", "Computer Move", "Result");
        System.out.println("----------------------------------------------------------");

        for (int i = 0; i < playerMoves.length; i++) {
            String playerMove = playerMoves[i];
            String computerMove = moves[random.nextInt(3)];
            String result = playRound(playerMove, computerMove);

            if (result.equals("Player Wins")) {
                wins++;
            } else if (result.equals("Computer Wins")) {
                losses++;
            } else {
                draws++;
            }

            System.out.printf("%-8d | %-12s | %-14s | %-14s%n", (i + 1), playerMove, computerMove, result);
        }

        double winPercentage = ((double) wins / playerMoves.length) * 100.0;
        System.out.printf("%nWins: %d | Losses: %d | Draws: %d | Win %% = %.1f%%%n", wins, losses, draws, winPercentage);
    }
}