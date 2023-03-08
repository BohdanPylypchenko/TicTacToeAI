package b314.tictactoe.genv;

import java.util.ArrayList;
import java.util.List;

/**
 * Game grid class
 */
public final class Grid {
    // Cell matrix
    private final Cell[][] cells;

    // Free cell list
    private final List<Cell> freeCells;

    /**
     * Grid constructor
     * @param dimension dimension of Grid (n x n)
     */
    public Grid(int dimension) {
        // Initializing matrix
        cells = new Cell[dimension][dimension];

        // Initializing lists
        freeCells = new ArrayList<>();

        // Initializing cells, adding to freeCells list
        for (int i = 0; i < dimension; i++) {
            for (int j = 0; j < dimension; j++) {
                cells[i][j] = new Cell(this, i, j);
                freeCells.add(cells[i][j]);
            }
        }
    }

    public int getDimension() {
        return this.cells[0].length;
    }

    public Cell getCell(int x, int y) {
        return this.cells[x][y];
    }

    /**
     * Row getter
     * @param rowIndex index of row to make copy and return
     * @return full copy of row
     */
    public Cell[] getRow(int rowIndex) {
        Cell[] result = new Cell[this.getDimension()];
        for (int i = 0; i < result.length; i++) {
            result[i] = cells[rowIndex][i];
        }
        return result;
    }

    /**
     * Column getter
     * @param columnIndex index of column to make copy and return
     * @return full copy of column
     */
    public Cell[] getColumn(int columnIndex) {
        Cell[] result = new Cell[this.getDimension()];
        for (int i = 0; i < result.length; i++) {
            result[i] = cells[i][columnIndex];
        }
        return result;
    }

    /**
     * Main diagonal getter
     * @return full copy of main diagonal cells
     */
    public Cell[] getMainDiagonal() {
        Cell[] result = new Cell[this.getDimension()];
        for (int i = 0; i < result.length; i++) {
            result[i] = cells[i][i];
        }
        return result;
    }

    /**
     * Additional diagonal getter
     * @return full copy of additional diagonal cells
     */
    public Cell[] getAdditionalDiagonal() {
        Cell[] result = new Cell[this.getDimension()];
        for (int i = 0; i < result.length; i++) {
            result[i] = cells[this.getDimension() - 1 - i][i];
        }
        return result;
    }

    /**
     * @return list of free cells
     */
    public List<Cell> getFreeCells() {
        return this.freeCells;
    }

    /**
     * Removes cell from list of free cells
     * @param cell cell to remove from free list
     */
    void removeCellFromFree(Cell cell) {
        this.freeCells.remove(cell);
    }

    /**
     * Checks, if cell is full
     * @return true, if there are free
     *         (not occupied) cells
     *         Otherwise - false
     */
    public boolean isFull() {
        return this.freeCells.size() == 0;
    }
}
