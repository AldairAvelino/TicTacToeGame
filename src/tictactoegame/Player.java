package tictactoegame;

public class Player {
    private String name;
    private char symbol;
    private int wins;
    private int draws;
    private int losses;

    public Player(String name, char symbol) {
        this.name = name;
        this.symbol = symbol;
        this.wins = 0;
        this.draws = 0;
        this.losses = 0;
    }

    public Player(String name, char symbol, int wins, int draws, int losses) {
        this.name = name;
        this.symbol = symbol;
        this.wins = wins;
        this.draws = draws;
        this.losses = losses;
    }

    public String getName() {
        return name;
    }

    public char getSymbol() {
        return symbol;
    }

    public int getWins() {
        return wins;
    }

    public int getDraws() {
        return draws;
    }

    public int getLosses() {
        return losses;
    }

    public void incrementWins() {
        wins++;
    }

    public void incrementDraws() {
        draws++;
    }

    public void incrementLosses() {
        losses++;
    }
}
