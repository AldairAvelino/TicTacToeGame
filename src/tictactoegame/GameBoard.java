package tictactoegame;

import java.util.Scanner;


public class GameBoard {
    private char[][] board;

    public GameBoard() {
        board = new char[3][3];
        initializeBoard();
    }

    private void initializeBoard() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                board[i][j] = '-';
            }
        }
    }

    public void printBoard() {
        System.out.println("-------------");
        for (int i = 0; i < 3; i++) {
            System.out.print("| ");
            for (int j = 0; j < 3; j++) {
                System.out.print(board[i][j] + " | ");
            }
            System.out.println();
            System.out.println("-------------");
        }
    }

    public boolean isValidMove(int position) {
        if (position < 1 || position > 9)
            return false;

        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        return board[row][col] == '-';
    }

    public void makeMove(char playerSymbol, int position) {
        int row = (position - 1) / 3;
        int col = (position - 1) % 3;
        board[row][col] = playerSymbol;
    }

    public boolean checkWin() {
        return checkRows() || checkColumns() || checkDiagonals();
    }

    private boolean checkRows() {
        for (int i = 0; i < 3; i++) {
            if (board[i][0] == board[i][1] && board[i][1] == board[i][2] && board[i][0] != '-') {
                return true;
            }
        }
        return false;
    }

    private boolean checkColumns() {
        for (int j = 0; j < 3; j++) {
            if (board[0][j] == board[1][j] && board[1][j] == board[2][j] && board[0][j] != '-') {
                return true;
            }
        }
        return false;
    }

    private boolean checkDiagonals() {
        return (board[0][0] == board[1][1] && board[1][1] == board[2][2] && board[0][0] != '-') ||
                (board[0][2] == board[1][1] && board[1][1] == board[2][0] && board[0][2] != '-');
    }

    public boolean checkDraw() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                if (board[i][j] == '-') {
                    return false;
                }
            }
        }
        return true;
    }

    public void resetBoard() {
        initializeBoard();
    }
    
    public static boolean continueGame(Scanner scanner, char currentPlayerSymbol) {
        System.out.println("Do you want to continue playing? (yes/no)");
        String playAgain = scanner.next();
        if (playAgain.equalsIgnoreCase("yes")) {
            System.out.println("Starting new game...");
            return true;
        } else {
            return false;
        }
    }

}
