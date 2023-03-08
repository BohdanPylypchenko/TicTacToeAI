package b314.tictactoe.tui;

import java.util.Arrays;
import java.util.Scanner;

/**
 * TUI for HumanPlayer
 */
public final class HumanPlayerTUI {
    // Coordinates input request
    private static final String COORD_INPUT_REQUEST = "Enter the coordinates: ";

    // Wrong input warning
    private static final String WRONG_INPUT_WARNING = "You should enter numbers!";

    // Coords out of bounds warning
    private static final String COORDS_OUT_OF_BOUNDS_WARNING = "Coordinates should be from 1 to %d!\n";
    // Occupied cell warning
    private static final String OCCUPATED_CELL_WARNING = "This cell is occupied! Choose another one!";

    // Scanner for stdin
    private static final Scanner scanIn = new Scanner(System.in);

    // Regex to get coords from user
    private static final String COORDS_REGEX = "\\d+ \\d+";

    /**
     * Get cell coordinates from player
     * @return coordinates as array of integers
     */
    public static int[] getCoordsFromUser() {
        //scanIn.useDelimiter("\n");
        String buff;
        while (true) {
            // Printing message
            System.out.print(COORD_INPUT_REQUEST);

            // Getting input
            buff = scanIn.nextLine();

            // Checking for regex
            if (buff.matches(COORDS_REGEX)) {
                return Arrays.stream(buff.split(" ")).
                              mapToInt(Integer::parseInt).
                              map(e -> e - 1).
                              toArray();
            } else {
                System.out.println(WRONG_INPUT_WARNING);
            }
        }
    }

    /**
     * Show coord out of bound error
     */
    public static void printCoordOutOfBoundError(int dimension) {
        System.out.printf(COORDS_OUT_OF_BOUNDS_WARNING, dimension);
    }

    /**
     * Show occupied cell warning
     */
    public static void printOccupiedCellCaptureWarning() {
        System.out.println(OCCUPATED_CELL_WARNING);
    }
}
