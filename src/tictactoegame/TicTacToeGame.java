package tictactoegame;

import java.util.Scanner;

public class TicTacToeGame {
    private static Player player1;
    private static Player player2;
    private static char currentPlayer;
    private static boolean gameEnded = false;

    public static void main(String[] args) {
        ScoreManager.loadScoreData(); // Carrega os dados do placar

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            System.out.println("Welcome to Tic Tac Toe Game");
            System.out.println("1. Start Game");
            System.out.println("2. View Score");
            System.out.println("3. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    GameBoard.resetGame();
                    ScoreManager.resetScoreData(); // Redefine os dados do placar
                    GameBoard.printBoard();
                    startGame(scanner);
                    break;
                case 2:
                    ScoreManager.viewScore();
                    break;
                case 3:
                    ScoreManager.saveScoreData(); // Salva os dados do placar antes de sair
                    System.out.println("Thanks for playing!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        } while (choice != 3);

        scanner.close();
    }

    private static void startGame(Scanner scanner) {
        System.out.println("Enter player 1's name:");
        String name1 = scanner.next();
        System.out.println("Enter player 2's name:");
        String name2 = scanner.next();

        player1 = new Player(name1, 'X');
        player2 = new Player(name2, 'O');

        currentPlayer = player1.getSymbol();
        
        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + " (" + getPlayerName(currentPlayer) + "), enter your move (1-9):");
            int position = scanner.nextInt();
            
            if (GameBoard.isValidMove(position)) {
                GameBoard.makeMove(currentPlayer, position);
                GameBoard.printBoard();
                
                if (GameBoard.checkWin()) {
                    System.out.println("Player " + currentPlayer + " (" + getPlayerName(currentPlayer) + ") wins!");
                    ScoreManager.updateScore(currentPlayer);
                    if (GameBoard.continueGame(scanner, currentPlayer))
                        GameBoard.resetGame();
                    else
                        gameEnded = true;
                } else if (GameBoard.checkDraw()) {
                    System.out.println("It's a draw!");
                    ScoreManager.updateDrawScore();
                    if (GameBoard.continueGame(scanner, currentPlayer))
                        GameBoard.resetGame();
                    else
                        gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Please enter a number between 1 and 9 that hasn't been played.");
            }
        }
    }

    private static String getPlayerName(char symbol) {
        if (symbol == 'X')
            return player1.getName();
        else
            return player2.getName();
    }
}
