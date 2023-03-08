package b314.tictactoe.player;

import b314.tictactoe.genv.Cell;
import b314.tictactoe.genv.Grid;
import b314.tictactoe.tui.BotTUI;

/**
 * Easy bot player implementation
 */
public final class EasyBotPlayer extends Player {
     /**
     * Default constructor
     * @param grid grid to play on
     * @param sign sign of player to display on grid
     */
    public EasyBotPlayer(Grid grid, char sign) {
        super(grid, sign);
    }

    /**
     * selectCell override
     * @return cell to occupy
     */
    @Override
    protected Cell selectCell() {
        // Showing message
        BotTUI.printEasyBotMakeMoveMessage();

        // Check if grid is full
        if (this.getGrid().isFull()) {
            // No free -> return null
            return null;
        }

        // Endless cycle
        int[] coords = new int[2];
        while(true) {
            // Generating coords
            coords[0] = RndContainer.getRnd().nextInt(this.getGrid().getDimension());
            coords[1] = RndContainer.getRnd().nextInt(this.getGrid().getDimension());

            // Check if cell is occupied
            if (this.getGrid().getCell(coords[0], coords[1]).getOccupantPlayer() == null) {
                return this.getGrid().getCell(coords[0], coords[1]);
            }
        }
    }
}
