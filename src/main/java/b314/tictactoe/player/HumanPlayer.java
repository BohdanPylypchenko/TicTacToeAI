package b314.tictactoe.player;

import b314.tictactoe.genv.Cell;
import b314.tictactoe.genv.Grid;
import b314.tictactoe.tui.HumanPlayerTUI;

/**
 * Human player implementation
 */
public final class HumanPlayer extends Player {
    /**
     * Default constructor
     * @param grid grid to play on
     * @param sign sign of player to display on grid
     */
    public HumanPlayer(Grid grid, char sign) {
        super(grid, sign);
    }

    /**
     * Human selectCell implementation
     * @return cell to occupy
     */
    @Override
    protected Cell selectCell() {
        // While user does not select free cell
        int[] coords;
        while (true) {
            // Getting coords from user
            coords = HumanPlayerTUI.getCoordsFromUser();

            // Processing coords
            if (!this.areCoordsInBounds(coords)) {
                // Coords are not in bounds
                HumanPlayerTUI.printCoordOutOfBoundError(this.getGrid().getDimension());
            } else if (this.getGrid().getCell(coords[0], coords[1]).getOccupantPlayer() == null) {
                // Cell is free, can return
                return this.getGrid().getCell(coords[0], coords[1]);
            } else {
                // Cell is already occupied -> show warning
                HumanPlayerTUI.printOccupiedCellCaptureWarning();
            }
        }
    }

    /**
     * Coordinates bound validation
     * @param coords array of coords
     * @return true, if all are in bounds [1; n]
     *         else false
     */
    private boolean areCoordsInBounds(int[] coords) {
        for (int coord : coords) {
            if (coord < 0 || coord >= this.getGrid().getDimension()) {
                return false;
            }
        }
        return true;
    }
}
