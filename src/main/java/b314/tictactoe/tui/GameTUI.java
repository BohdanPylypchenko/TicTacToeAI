package b314.tictactoe.tui;

import b314.tictactoe.genv.Game;
import b314.tictactoe.player.Player;

import java.util.Scanner;

public class GameTUI {
    // Private static stdin scanner
    private static final Scanner scanIn = new Scanner(System.in);

    // Command request
    private static final String COMMAND_REQUEST = "Input command: ";

    // Bad parameters warning
    private static final String BAD_PARAMETERS_WARNING = "Bad parameters!";

    // User sign
    public static final String PLAYER_USER_COMMAND = "user";

    // Easy bot sign
    public static final String PLAYER_EASY_COMMAND = "easy";

    // Medium bot sign
    public static final String PLAYER_MEDIUM_COMMAND = "medium";

    // Hard bot sign
    public static final String PLAYER_HARD_COMMAND = "hard";

    // Player type enum
    public enum PlayerType {
        USER,
        EASY,
        MEDIUM,
        HARD
    }

    // Start command regex
    private static final String START_REGEX = "start (user|easy|medium|hard) (user|easy|medium|hard)";

    // Exit command regex
    private static final String EXIT_REGEX = "exit";

    /**
     * Prints greeting / tutorial
     */
    public static void printGreetingMessage() {
        System.out.println("""
                           TicTacToe game (AI version)
                           
                           Greetings! You have launched TicTacToe game!
                           
                           To start the game, enter "start" command.
                           Start command takes 2 arguments.
                           1st defines type of player 1;
                           2nd defines type of player 2;
                           There are 4 types for each player:
                               1. Easy bot     - makes random moves only
                               2. Medium bot   - random moves, if other player is 1 move from win - denies that move
                                                 by taking the field
                               3. Hard bot     - Dark Souls like difficulty (Mini-Max algorithm)
                               4. Human player - enter moves from keyboard.
                           To play against bot, enter "start user (easy|medium|hard)".
                           To play against human friend, enter "start user user".
                           To turn the program into Skynet, use "start hard hard".
                           
                           After starting game session as human player, you will be asked to enter coordinates of cell
                           to occupy.
                           Coordinate in grid numerated in matrix-style:
                               x ----
                           y 11 12 13
                           | 21 22 23
                           | 31 32 33
                           To enter coordinates of move, pass them like this: x y (x coord, SPACE, y coord).
                           Example: to occupy cell 23, enter "2 3".
                           
                           Game session example:
                           Input command: start user medium
                           ---------
                           |       |
                           |       |
                           |       |
                           ---------
                           Enter the coordinates: 1 1
                           ---------
                           | X     |
                           |       |
                           |       |
                           ---------
                           Making move level "medium"
                           ---------
                           | X     |
                           | O     |
                           |       |
                           ---------
                           Enter the coordinates: 1 3
                           ---------
                           | X   X |
                           | O     |
                           |       |
                           ---------
                           Making move level "medium"
                           ---------
                           | X O X |
                           | O     |
                           |       |
                           ---------
                           Enter the coordinates: 2 2
                           ---------
                           | X O X |
                           | O X   |
                           |       |
                           ---------
                           Making move level "medium"
                           ---------
                           | X O X |
                           | O X   |
                           |     O |
                           ---------
                           Enter the coordinates: 3 1
                           ---------
                           | X O X |
                           | O X   |
                           | X   O |
                           ---------
                           X wins
                                           
                           Input command: exit
                           
                           Finally, to exit, enter "exit" command.
                           (Notice, to exit the game / start new game, you first need to finish current one.)
                           
                           Good luck :)
                           """);
    }

    /**
     * @param winner game winner
     */
    public static void printWinEnd(Player winner) {
        System.out.println(winner.getSign() + " wins");
    }

    /**
     * draw end
     */
    public static void printDrawEnd() {
        System.out.println("Draw");
    }

    /**
     * Prints bad parameters warning
     */
    public static void printBadParametersWarning() {
        System.out.println(BAD_PARAMETERS_WARNING);
    }

    /**
     * Runs game UI cycle
     */
    public static void cycleGameUI() {
        String command;
        String[] playerTypeCommands;
        Game game;
        while (true) {
            // Printing command request
            System.out.print(COMMAND_REQUEST);

            // Reading
            command = scanIn.nextLine();

            // Making decision
            if (command.matches(EXIT_REGEX)) {
                System.exit(0);
            } else if (command.matches(START_REGEX)) {
                playerTypeCommands = command.split(" ");
                game = callCreate2User3x3(playerTypeCommands);
                game.run();
                System.out.println();
            } else {
                printBadParametersWarning();
            }
        }
    }

    /**
     * Converts string input to enum input
     * and calls create2User3x3 from Game class
     * with converted params
     * @param playerTypeCommands player's types
     * @return result of create2User3x3 call
     */
    private static Game callCreate2User3x3(String[] playerTypeCommands) {
        // Getting players types as enum
        PlayerType[] playerTypes = new PlayerType[playerTypeCommands.length - 1];
        for (int i = 1; i < playerTypeCommands.length; i++) {
            switch (playerTypeCommands[i]) {
                case GameTUI.PLAYER_USER_COMMAND:
                    playerTypes[i - 1] = PlayerType.USER;
                    break;
                case GameTUI.PLAYER_EASY_COMMAND:
                    playerTypes[i - 1] = PlayerType.EASY;
                    break;
                case GameTUI.PLAYER_MEDIUM_COMMAND:
                    playerTypes[i - 1] = PlayerType.MEDIUM;
                    break;
                case GameTUI.PLAYER_HARD_COMMAND:
                    playerTypes[i - 1] = PlayerType.HARD;
                    break;
            }
        }

        // Returning result of create2User3x3 call
        return Game.create2User3x3(playerTypes[0], playerTypes[1]);
    }
}
