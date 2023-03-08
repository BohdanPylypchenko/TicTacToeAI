package b314.tictactoe;

import b314.tictactoe.genv.Grid;
import b314.tictactoe.player.EasyBotPlayer;
import b314.tictactoe.tui.GridTUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertTrue;

/**
 * Tests for EasyBotPlayer class
 */
public class EasyBotPlayerTest {
    @Test
    void singleMoveTest() {
        // Creating new grid
        Grid grid = new Grid(2);

        // Creating new EasyBotPlayer
        EasyBotPlayer ebp = new EasyBotPlayer(grid, 'O');

        // Making single move
        ebp.makeMove();

        // Printing
        GridTUI.printGrid(grid);

        // Asserting
        boolean areAnyCellsWereTakenByBot = false;
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2; j++) {
                if (grid.getCell(i, j).getOccupantPlayer() == ebp) {
                    areAnyCellsWereTakenByBot = true;
                    break;
                }
            }
        }
        assertTrue(areAnyCellsWereTakenByBot);
    }
}
