# Tic Tac Toe Game

Welcome to the classic Tic Tac Toe game implemented in Java! This console-based game allows two players to compete against each other in a battle of wits and strategy.

## Overview

This repository contains all the code necessary to run the Tic Tac Toe game. The game is organized into multiple modules, each responsible for different aspects of the gameplay.

## Modules

### `TicTacToeGame.java`

- **Description**: The main class controlling the game flow.
- **Functionality**: 
  - Starts the game, allows players to view scores, or exit.
  - Manages the main game loop, player turns, and game outcomes.

### `GameBoard.java`

- **Description**: Handles the game board and related operations.
- **Functionality**:
  - Initializes and prints the game board.
  - Validates player moves and checks for win conditions.

### `Player.java`

- **Description**: Represents a player in the game.
- **Functionality**:
  - Stores player information (name, symbol, scores).
  - Provides methods to update player scores based on game outcomes.

### `ScoreManager.java`

- **Description**: Manages player scores, including loading, saving, and resetting.
- **Functionality**:
  - Handles score data storage in an external file (`score.txt`).
  - Updates player scores based on game results.

## How to Play

1. Run the `TicTacToeGame.java` file to start the game.
2. Choose an option from the main menu: start a new game, view scores, or exit.
3. During the game, players take turns entering their moves using numbers 1-9 to indicate board positions.
4. The game continues until a player wins, the game ends in a draw, or the players choose to exit.

Enjoy the challenge and excitement of Tic Tac Toe with this easy-to-use Java implementation!
