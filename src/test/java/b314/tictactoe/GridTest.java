package b314.tictactoe;

import b314.tictactoe.genv.Grid;
import b314.tictactoe.tui.GridTUI;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNull;

/**
 * Grid class tests
 */
public class GridTest {
    @Test
    void gridCreationTest() {
        // Creating new grid
        Grid g = new Grid(3);

        // Printing grid
        GridTUI.printGrid(g);

        // Asserting
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                assertNull(g.getCell(i, j).getOccupantPlayer());
                assertEquals(g.getCell(i, j).getGrid(), g);
                assertEquals(g.getCell(i, j).getX(), i);
                assertEquals(g.getCell(i, j).getY(), j);
            }
        }
        assertEquals(g.getDimension(), 3);
        assertEquals(g.getFreeCells().size(), 9);
    }
}
