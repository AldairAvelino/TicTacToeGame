package tictactoegame;

import java.util.Scanner;
import java.util.InputMismatchException;

public class TicTacToeGame {
    private static boolean gameEnded = false;

    public static void main(String[] args) {
        ScoreManager.loadScoreData(); // Carrega os dados do placar

        Scanner scanner = new Scanner(System.in);

        int choice;
        do {
            try{
                System.out.println("Welcome to Tic Tac Toe Game");
                System.out.println("1. Start Game");
                System.out.println("2. View Score");
                System.out.println("3. Exit");
                System.out.print("Enter your choice: ");
                choice = scanner.nextInt();
            } catch (InputMismatchException e) {
                // Se o usuário inserir um valor que não é um número inteiro
                System.out.println("\nInvalid input. Please enter a number.\n");
                // Limpa o buffer do scanner
                scanner.nextLine();
                // Define uma escolha inválida para continuar no loop
                choice = 0;
            }
            switch (choice) {
                case 1:
                    GameBoard gameBoard = new GameBoard();
                    System.out.println("Enter player 1's name:");
                    String name1 = scanner.next();
                    System.out.println("Enter player 2's name:");
                    String name2 = scanner.next();
                    ScoreManager.setPlayerNames(name1, name2);
                    ScoreManager.resetScoreData(); // Redefine os dados do placar
                    gameBoard.printBoard();
                    startGame(scanner, gameBoard);
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

    private static void startGame(Scanner scanner, GameBoard gameBoard) {
        char currentPlayer = 'X'; // Começa com o jogador 1 (X)
        
        while (!gameEnded) {
            System.out.println("Player " + currentPlayer + " (" + ScoreManager.getPlayerName(currentPlayer) + "), enter your move (1-9):");
            
            try {
            
            int position = scanner.nextInt();
            
            if (gameBoard.isValidMove(position)) {
                gameBoard.makeMove(currentPlayer, position);
                gameBoard.printBoard();
                
                if (gameBoard.checkWin()) {
                    System.out.println("Player " + currentPlayer + " (" + ScoreManager.getPlayerName(currentPlayer) + ") wins!");
                    ScoreManager.updateScore(currentPlayer);
                    if (GameBoard.continueGame(scanner, currentPlayer))
                        gameBoard.resetBoard();
                    else
                        gameEnded = true;
                } else if (gameBoard.checkDraw()) {
                    System.out.println("It's a draw!");
                    ScoreManager.updateDrawScore();
                    if (GameBoard.continueGame(scanner, currentPlayer))
                        gameBoard.resetBoard();
                    else
                        gameEnded = true;
                } else {
                    currentPlayer = (currentPlayer == 'X') ? 'O' : 'X';
                }
            } else {
                System.out.println("Invalid move. Please enter a number between 1 and 9 that hasn't been played.");
            }
           } catch (InputMismatchException e) {
               // Se o jogador inserir um valor que não é um número inteiro
                System.out.println("Invalid input. Please enter a number.");
                // Limpa o buffer do scanner
                scanner.nextLine();
           }
        }
    }
}
