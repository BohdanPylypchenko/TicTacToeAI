package b314.tictactoe.player;

import b314.tictactoe.genv.Cell;
import b314.tictactoe.genv.Grid;

import java.util.LinkedHashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Set;

/**
 * Abstract player class
 * All players are inherited from this class
 */
public abstract class Player {
    // Char to represent on cell/grid
    private final char sign;

    // Occupied cells
    private final List<Cell> occupied;

    // X coords set
    private final Set<Integer> xCoordSet;

    // Y coords set
    private final Set<Integer> yCoordSet;

    // Game grid reference
    private final Grid grid;

    /**
     * Default constructor
     * @param grid grid to play on
     * @param sign sign of player to display on grid
     */
    Player(Grid grid, char sign) {
        // Initialize by provided data
        this.grid = grid;
        this.sign = sign;

        // Initialize by default
        this.occupied = new LinkedList<>();
        this.xCoordSet = new LinkedHashSet<>(); // will be iterated many times
        this.yCoordSet = new LinkedHashSet<>(); // will be iterated many times
    }

    public char getSign() {
        return sign;
    }

    public Grid getGrid() {
        return this.grid;
    }

    List<Cell> getOccupied() {
        return this.occupied;
    }

    /**
     * Make move by this player
     * Cell is selected by SelectCell method
     */
    public void makeMove() {
        // Selecting cell to make move with
        Cell selected = this.selectCell();

        // Checking for null
        if (selected == null) {
            return;
        }

        // Occupying
        selected.occupyByPlayer(this);

        // Adding
        this.addCellToOccupied(selected);
    }

    /**
     * Make move by this player on decided cell
     * @param x X coord of cell
     * @param y Y coords of cell
     */
    public void makeMove(int x, int y) {
        Cell selected = this.grid.getCell(x, y);
        if (selected.occupyByPlayer(this)) {
            this.addCellToOccupied(selected);
        }
    }

    /**
     * Abstract cell selector
     * has to be implemented in class children
     * @return cell to make move with
     */
    abstract Cell selectCell();

    /**
     * @return true if player won, else - false
     */
    public boolean isWinner() {
        // Check for enough occupied cells
        if (occupied.size() < grid.getDimension()) {
            return false;
        }

        // Checking
        return ((checkForRowWinWithout(0) != -1)                 ||
                (checkForColumnWinWithout(0) != -1)              ||
                (checkForMainDiagonalWinWithout(0) != -1)        ||
                (checkForAdditionalDiagonalWinWithout(0) != -1));
    }

    /**
     * Package-private checker for row win
     * @param countToIgnore count of scores to ignore
     * @return index of winning row,
     *         if no row, returns -1
     */
    final int checkForRowWinWithout(int countToIgnore) {
        // Check for row win
        for (int current: xCoordSet) {
            if (occupied.stream().
                    filter(e -> e.getX() == current).
                    count() == grid.getDimension() - countToIgnore) {
                return current;
            }
        }

        // No success -> -1
        return -1;
    }

    /**
     * Package-private checker for column win
     * @param countToIgnore count of scores to ignore
     * @return index of winning column,
     *         if no column, returns -1
     */
    final int checkForColumnWinWithout(int countToIgnore) {
        // Check for column win
        for (int current: yCoordSet) {
            if (occupied.stream().
                    filter(e -> e.getY() == current).
                    count() == grid.getDimension() - countToIgnore) {
                return current;
            }
        }

        // No success -> -1
        return -1;
    }

    /**
     * Package-private checker for main diagonal win
     * without given scores
     * @param countToIgnore count of scores to ignore
     * @return 1 if win
     *         -1 else
     */
    final int checkForMainDiagonalWinWithout(int countToIgnore) {
        // Check for main diagonal win
        if (occupied.stream().
                     filter(e -> e.getX() == e.getY()).
                     count() == grid.getDimension() - countToIgnore) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Package-private checker for main diagonal win
     * without given scores
     * @param countToIgnore count of scores to ignore
     * @return 1 if win
     *         -1 else
     */
    final int checkForAdditionalDiagonalWinWithout(int countToIgnore) {
        // Check for additional diagonal win
        if (occupied.stream().
                filter(e -> e.getX() == (grid.getDimension() - 1) - e.getY()).
                count() == grid.getDimension() - countToIgnore) {
            return 1;
        } else {
            return -1;
        }
    }

    /**
     * Adds cell to list of occupied,
     * cell's coords to xCoordSet and yCoordSet
     * @param cell cell to process
     */
    private void addCellToOccupied(Cell cell) {
        // Adding cell to occupy
        this.occupied.add(cell);

        // Adding cell coords to sets
        this.xCoordSet.add(cell.getX());
        this.yCoordSet.add(cell.getY());
    }
}
