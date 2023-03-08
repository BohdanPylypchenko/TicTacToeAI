package b314.tictactoe.player;

import b314.tictactoe.genv.Cell;
import b314.tictactoe.genv.Game;
import b314.tictactoe.genv.Grid;
import b314.tictactoe.tui.BotTUI;

import java.util.Collections;
import java.util.LinkedList;
import java.util.List;

/**
 * Hard bot implementation
 */
public final class HardBotPlayer extends Player {
    private final class FakePlayer extends Player {

        /**
         * Real player copy constructor
         * @param grid grid to play on
         * @param origin original real player to copy data from
         */
        FakePlayer(Grid grid, Player origin) {
            // Calling parent constructor
            super(grid, origin.getSign());

            // Making moves
            for (Cell current : origin.getOccupied()) {
                this.makeMove(current.getX(), current.getY());
            }
        }

        /**
         * Dummy selectCell implementation
         * @return null
         */
        @Override
        protected Cell selectCell() {
            return null;
        }
    }

    // Game reference
    private final Game game;

    // Self index in game's original array
    private final int originalIndex;

    // Index of next free cell to select for move
    private int nextCellToMoveIndex;

    /**
     * Default constructor
     * @param grid grid to play on
     * @param sign sign of player to display on grid
     * @param originalIndex Self index in original player array
     */
    public HardBotPlayer(Grid grid, char sign, Game game, int originalIndex) {
        super(grid, sign);
        this.game = game;
        this.originalIndex = originalIndex;
    }

    /**
     * selectCell override
     * @return cell to occupy
     */
    @Override
    protected Cell selectCell() {
        // Printing message
        BotTUI.printHardBotMakeMoveMessage();

        // Going through the tree
        func(this.getGrid(),
             this.game.getPlayers(),
             this.originalIndex - 1);

        // Returning cell
        return this.getGrid().getFreeCells().get(nextCellToMoveIndex);
    }

    /**
     * Recursive function to traverse game state tree
     * @param lastGrid previous grid state
     * @param players players array
     * @param lastMoveMakerIndex index of player - last move maker
     * @return mark of move
     */
    private int func(Grid lastGrid,
                     Player[] players,
                     int lastMoveMakerIndex) {

        // Evaluate current state
        if (players[originalIndex].isWinner()) {
            return 2;
        } else if (players[(players.length + lastMoveMakerIndex) % players.length].isWinner()) {
            return -1;
        } else if (lastGrid.isFull()) {
            return 1;
        }

        // Moving next
        int currentMoveMakerIndex = (lastMoveMakerIndex + 1) % players.length;
        Grid nextGrid;
        Cell nextMove;
        FakePlayer[] nextPlayers = new FakePlayer[players.length];
        List<Integer> values = new LinkedList<>();
        for (int i = 0; i < lastGrid.getFreeCells().size(); i++) {
            // Creating new grid
            nextGrid = new Grid(lastGrid.getDimension());

            // Creating players copies and placing them on the grid
            for (int j = 0; j < nextPlayers.length; j++) {
                nextPlayers[j] = new FakePlayer(nextGrid, players[j]);
            }

            // Making new move
            nextMove = nextGrid.getFreeCells().get(i);
            nextPlayers[currentMoveMakerIndex].makeMove(nextMove.getX(), nextMove.getY());

            // Moving down the tree
            values.add(func(nextGrid,
                       nextPlayers,
                       currentMoveMakerIndex));
        }

        // Returning
        int result;
        if (currentMoveMakerIndex == originalIndex) {
            result = Collections.max(values);
        } else {
            result = Collections.min(values);
        }
        this.nextCellToMoveIndex = values.indexOf(result);
        return result;
    }
}
