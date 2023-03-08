package b314.tictactoe.genv;

import b314.tictactoe.player.Player;

/**
 * Grid cell class
 */
public final class Cell {
    // Game grid
    private final Grid grid;

    // Occupied player
    private Player occupantPlayer;

    // Private coordinates
    private final int x, y;

    /**
     * Default constructor
     * @param grid Grid instance, which owns cell
     * @param x cell x coordinate
     * @param y cell y coordinate
     */
    Cell(Grid grid, int x, int y) {
        this.grid = grid;
        this.x = x;
        this.y = y;
        this.occupantPlayer = null;
    }

    public Grid getGrid() {
        return this.grid;
    }

    public Player getOccupantPlayer() {
        return this.occupantPlayer;
    }

    public int getX() {
        return this.x;
    }

    public int getY() {
        return this.y;
    }

    /**
     * Make cell occupied by player
     * @param player player to occupy cell
     * @return occupation flag: true if occupied, else false
     */
    public boolean occupyByPlayer(Player player) {
        // Check if already occupied
        if (this.occupantPlayer != null) {
            return false;
        }

        // Not occupied -> assign, return true
        this.occupantPlayer = player;

        // Reducing grid's free cell count
        this.grid.removeCellFromFree(this);

        // Returning true
        return true;
    }
}
