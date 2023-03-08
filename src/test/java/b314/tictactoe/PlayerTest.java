package b314.tictactoe;

import b314.tictactoe.genv.Grid;
import b314.tictactoe.player.HumanPlayer;
import b314.tictactoe.tui.GridTUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.*;

/**
 * Tests for HumanPlayer class
 */
public class PlayerTest {
    @Test
    void humanPlayerCreationTest() {
        // Creating new grid
        Grid grid = new Grid(3);

        // Creating new human player
        HumanPlayer hp = new HumanPlayer(grid, 'Y');

        // Asserting
        assertEquals(hp.getSign(), 'Y');
        assertEquals(hp.getGrid(), grid);
        assertFalse(hp.isWinner());
    }

    @Test
    void rowWinTest() {
        // Creating new grid
        Grid grid = new Grid(3);

        // Creating new player
        HumanPlayer hp = new HumanPlayer(grid, 'Y');

        // Placing
        hp.makeMove(0, 0);
        hp.makeMove(0, 1);
        hp.makeMove(0, 2);

        // Printing
        GridTUI.printGrid(grid);

        // Asserting
        assertTrue(hp.isWinner());
    }

    @Test
    void columnWinTest() {
        // Creating new grid
        Grid grid = new Grid(3);

        // Creating new player
        HumanPlayer hp = new HumanPlayer(grid, 'Y');

        // Placing
        hp.makeMove(0, 1);
        hp.makeMove(1, 1);
        hp.makeMove(2, 1);

        // Printing
        GridTUI.printGrid(grid);

        // Asserting
        assertTrue(hp.isWinner());
    }

    @Test
    void mainDiagonalTest() {
        // Creating new grid
        Grid grid = new Grid(3);

        // Creating first player
        HumanPlayer hp1 = new HumanPlayer(grid, 'X');

        // Placing
        hp1.makeMove(0, 0);
        hp1.makeMove(1, 1);
        hp1.makeMove(2, 2);

        // Printing
        GridTUI.printGrid(grid);

        // Asserting
        assertTrue(hp1.isWinner());
    }

    @Test
    void additionalDiagonalTest() {
        // Creating new grid
        Grid grid = new Grid(3);

        // Creating first player
        HumanPlayer hp1 = new HumanPlayer(grid, 'X');

        // Placing
        hp1.makeMove(0, 2);
        hp1.makeMove(1, 1);
        hp1.makeMove(2, 0);

        // Printing
        GridTUI.printGrid(grid);

        // Asserting
        assertTrue(hp1.isWinner());
    }

    @Test
    void zeroOccupationIsWinnerTest() {
        // Creating new grid
        Grid grid = new Grid(3);

        // Creating new player
        HumanPlayer hp = new HumanPlayer(grid, 'a');

        // Printing
        GridTUI.printGrid(grid);

        // Asserting
        assertFalse(hp.isWinner());
    }

    @Test
    void overoccupationIsWinnerTest() {
        // Creating new grid
        Grid grid = new Grid(3);

        // Creating new player
        HumanPlayer hp = new HumanPlayer(grid, 'X');

        // Placing
        hp.makeMove(0, 0);
        hp.makeMove(1, 0);
        hp.makeMove(2, 0);
        hp.makeMove(2, 2);

        // Printing
        GridTUI.printGrid(grid);

        // Asserting
        assertTrue(hp.isWinner());
    }

    @Test
    void drawIsWinnerTest() {
        // Creating new grid
        Grid grid = new Grid(3);

        // Creating players
        HumanPlayer hp1 = new HumanPlayer(grid, 'X');
        HumanPlayer hp2 = new HumanPlayer(grid, 'O');

        // Placing
        hp1.makeMove(0, 0);
        hp2.makeMove(1, 0);
        hp1.makeMove(2, 0);
        hp2.makeMove(1, 1);
        hp1.makeMove(0, 1);
        hp2.makeMove(0, 2);
        hp1.makeMove(1, 2);
        hp2.makeMove(2, 2);
        hp1.makeMove(2, 1);

        // Printing
        GridTUI.printGrid(grid);

        // Asserting
        assertFalse(hp1.isWinner());
        assertFalse(hp2.isWinner());
    }

    @Test
    void makeMoveTest() {
        // Creating new grid
        Grid grid = new Grid(2);

        // Creating new HumanPlayer
        HumanPlayer hp = new HumanPlayer(grid, 'H');

        // Making move
        hp.makeMove(1, 1);

        // Printing
        GridTUI.printGrid(grid);

        // Asserting
        assertEquals(grid.getCell(1, 1).getOccupantPlayer(), hp);

        // Trying to make same move again
        hp.makeMove(1, 1);

        // Printing
        GridTUI.printGrid(grid);

        // Asserting
        assertEquals(grid.getCell(1, 1).getOccupantPlayer(), hp);
    }
}
