package tictactoegame;

import java.io.*;

public class ScoreManager {
    private static Player player1;
    private static Player player2;

    public static void updateScore(char winner) {
        if (winner == 'X') {
            player1.incrementWins();
            player2.incrementLosses();
        } else {
            player2.incrementWins();
            player1.incrementLosses();
        }
    }

    public static void updateDrawScore() {
        player1.incrementDraws();
        player2.incrementDraws();
    }

    public static void viewScore() {
        System.out.println("Player\tWins\tDraws\tLosses");
        System.out.println(player1.getName() + "\t" + player1.getWins() + "\t" + player1.getDraws() + "\t" + player1.getLosses());
        System.out.println(player2.getName() + "\t" + player2.getWins() + "\t" + player2.getDraws() + "\t" + player2.getLosses());
    }

    public static void saveScoreData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("score.txt"))) {
            writer.println(player1.getName());
            writer.println(player1.getWins());
            writer.println(player1.getDraws());
            writer.println(player1.getLosses());
            writer.println(player2.getName());
            writer.println(player2.getWins());
            writer.println(player2.getDraws());
            writer.println(player2.getLosses());
        } catch (IOException e) {
            System.out.println("Error saving score data.");
        }
    }

    public static void resetScoreData() {
        try (PrintWriter writer = new PrintWriter(new FileWriter("score.txt"))) {
            writer.println("Player 1");
            writer.println(0);
            writer.println(0);
            writer.println(0);
            writer.println("Player 2");
            writer.println(0);
            writer.println(0);
            writer.println(0);
        } catch (IOException e) {
            System.out.println("Error resetting score data.");
        }
    }

    public static void loadScoreData() {
        try (BufferedReader reader = new BufferedReader(new FileReader("score.txt"))) {
            String name1 = reader.readLine();
            int wins1 = Integer.parseInt(reader.readLine());
            int draws1 = Integer.parseInt(reader.readLine());
            int losses1 = Integer.parseInt(reader.readLine());

            String name2 = reader.readLine();
            int wins2 = Integer.parseInt(reader.readLine());
            int draws2 = Integer.parseInt(reader.readLine());
            int losses2 = Integer.parseInt(reader.readLine());

            player1 = new Player(name1, 'X', wins1, draws1, losses1);
            player2 = new Player(name2, 'O', wins2, draws2, losses2);
        } catch (IOException | NumberFormatException e) {
            // If there's an error loading score data, initialize scores to zero
            player1 = new Player("Player 1", 'X');
            player2 = new Player("Player 2", 'O');
        }
    }
}
