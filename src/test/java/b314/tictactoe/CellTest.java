package b314.tictactoe;

import b314.tictactoe.genv.Grid;
import b314.tictactoe.player.HumanPlayer;
import b314.tictactoe.tui.GridTUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Cell class tests
 */
class CellTest {
    @Test
    void cellSingleOccupationTest() {
        // Greetings
        System.out.println("========== Single occupation ==========");

        // Grid creation
        Grid g = new Grid(4);

        // Creating new human player
        HumanPlayer hp1 = new HumanPlayer(g, 'X');

        // Occupying
        boolean occupationResult = g.getCell(0, 1).occupyByPlayer(hp1);

        // Printing grid
        System.out.println("Grid (after occupation):");
        GridTUI.printGrid(g);

        // Asserting
        assertTrue(occupationResult);
        assertEquals(g.getCell(0, 1).getOccupantPlayer(), hp1);
    }

    @Test
    void cellMultipleOccupationTest() {
        // Greetings
        System.out.println("========== Multiple occupation ==========");

        // Grid creation
        Grid g = new Grid(4);

        // Creating new human player
        HumanPlayer hp1 = new HumanPlayer(g, 'X');

        // Occupying
        boolean occupationResult = g.getCell(2, 1).occupyByPlayer(hp1);

        // Printing grid
        System.out.println("Grid (after occupation):");
        GridTUI.printGrid(g);

        // Asserting
        assertTrue(occupationResult);
        assertEquals(g.getCell(2, 1).getOccupantPlayer(), hp1);

        // Creating another human player
        HumanPlayer hp2 = new HumanPlayer(g, 'O');

        // Trying to occupy [2, 1] with hp2
        occupationResult = g.getCell(2, 1).occupyByPlayer(hp2);

        // Printing grid
        System.out.println("Grid (2nd failed occupation attempt):");
        GridTUI.printGrid(g);

        // Asserting
        assertFalse(occupationResult);
        assertEquals(g.getCell(2, 1).getOccupantPlayer(), hp1);

        // Final occupation
        occupationResult = g.getCell(3, 3).occupyByPlayer(hp2);

        // Printing grid
        System.out.println("Grid (final):");
        GridTUI.printGrid(g);

        // Asserting
        assertTrue(occupationResult);
        assertEquals(g.getCell(3, 3).getOccupantPlayer(), hp2);
        assertEquals(g.getCell(2, 1).getOccupantPlayer(), hp1);
    }
}
