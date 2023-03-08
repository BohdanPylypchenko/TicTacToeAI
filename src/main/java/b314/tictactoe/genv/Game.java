package b314.tictactoe.genv;

import b314.tictactoe.player.*;
import b314.tictactoe.tui.GameTUI;
import b314.tictactoe.tui.GridTUI;

/**
 * Game class
 * Represents TicTacToe game
 */
public final class Game {
    // Game grid
    private final Grid grid;

    // Player array
    private final Player[] players;

    /**
     * Private constructor
     * @param grid Grid instance to use for game
     * @param players array of players
     */
    private Game(Grid grid, Player[] players) {
        this.grid = grid;
        this.players = players;
    }

    /**
     * Game state
     * Notice: no lost state, there is always a winner
     */
    private enum GameState {
        WIN,
        DRAW,
        CONTINUE
    }

    /**
     * Static method
     * to create 3x3 game with 2 outside-specified
     * players. Players are defined by string names.
     * @param player1Type Type of player 1 (as enum value)
     * @param player2Type Type of player 2 (as enum value)
     */
    public static Game create2User3x3(GameTUI.PlayerType player1Type,
                                      GameTUI.PlayerType player2Type) {
        // Creating new grid
        Grid grid = new Grid(3);

        // Creating players
        Player[] players = new Player[2];

        // Creating game instance
        Game game = new Game(grid, players);

        // Initializing players
        GameTUI.PlayerType[] playerTypes = { player1Type, player2Type };
        char[] playerSigns = { 'X', 'O' };
        for (int i = 0; i < players.length; i++) {
            if (playerTypes[i] == GameTUI.PlayerType.USER) {
                players[i] = new HumanPlayer(grid, playerSigns[i]);
            } else if (playerTypes[i] == GameTUI.PlayerType.EASY) {
                players[i] = new EasyBotPlayer(grid, playerSigns[i]);
            } else if (playerTypes[i] == GameTUI.PlayerType.MEDIUM) {
                players[i] = new MediumBotPlayer(grid, playerSigns[i], game);
            } else if (playerTypes[i] == GameTUI.PlayerType.HARD) {
                players[i] = new HardBotPlayer(grid, playerSigns[i], game, i);
            }
        }

        // Returning game
        return game;
    }

    public Player[] getPlayers() {
        return this.players;
    }

    /**
     * Runs game
     */
    public void run() {
        // Game cycle
        GameState state = GameState.CONTINUE;
        while(state == GameState.CONTINUE) {
            // Cycling though players
            for (Player current : this.players) {
                // Printing grid
                GridTUI.printGrid(grid);

                // Current player makes move
                current.makeMove();

                // Checking game state
                state = this.calcGameState(current);
                switch (state) {
                    case WIN:
                        GridTUI.printGrid(grid);
                        GameTUI.printWinEnd(current);
                        return;
                    case DRAW:
                        GridTUI.printGrid(grid);
                        GameTUI.printDrawEnd();
                        return;
                }
            }
        }
    }

    /**
     * Calculates game state: win, draw, continue
     * @param last player, who made last move
     */
    private GameState calcGameState(Player last) {
        // Checking if win
        if (last.isWinner()) {
            return GameState.WIN;
        }

        // Is there any free cells?
        if (this.grid.isFull()) {
            // No winner and no free -> draw
            return GameState.DRAW;
        }

        // Free left -> continue
        return GameState.CONTINUE;
    }
}
