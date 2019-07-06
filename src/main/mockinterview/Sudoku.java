package mockinterview;

import java.util.LinkedList;
import java.util.List;

public class Sudoku {
    private static final int BOARD_LIMIT = 9;
    private static final int BLOCK_SIZE = BOARD_LIMIT / 3;

    int[][] board = new int[BOARD_LIMIT][BOARD_LIMIT];
    private PossibleCell[][] progress = new PossibleCell[BOARD_LIMIT][BOARD_LIMIT];
    private int passesCount = 0;

    Sudoku(int[][] vals) {
        initBoard(vals);
    }

    private void initBoard(int[][] vals) {
        for (int i = 0; i < BOARD_LIMIT; i++) {
            for (int j = 0; j < BOARD_LIMIT; j++) {
                board[i][j] = vals[i][j];
                progress[i][j] = new PossibleCell(board[i][j]);
            }
        }
        passesCount = 0;
    }

    void printBoard() {
        for (int i = 0; i < BOARD_LIMIT; i++) {
            for (int j = 0; j < BOARD_LIMIT; j++) {
                System.out.print("" + board[i][j] + ' ');
            }
            System.out.println();
        }
    }

    /**
     * Walk through every 0-cell, check row, column and block, which should fill possible values
     * when board walked through - check all possible cells and fill those which have only 1 possible value
     * (into the board).
     * Repeat the process until there are no 0 cells in the board.
     * Complexity: O(N^3)
     */
    void solve() {
        boolean atLeastOneZero;
        do {
            atLeastOneZero = false;
            for (int row = 0; row < BOARD_LIMIT; row++) {
                for (int col = 0; col < BOARD_LIMIT; col++) {
                    if (board[row][col] == 0) {
                        atLeastOneZero = true;
                        checkCell(row, col);
                    }
                }
            }
            boolean atLeastOneFilled = fillDefined();
            passesCount++;
            if (atLeastOneZero && !atLeastOneFilled) {
                System.out.println("No solution!");
                break;
            }
        } while (atLeastOneZero);
    }


    private void checkCell(int row, int col) {
        checkRow(row, col);
        checkCol(row, col);
        checkBlock(row, col);
    }

    private void checkRow(int cellRow, int cellCol) {
        PossibleCell possibleCell = progress[cellRow][cellCol];
        for (int col = 0; col < BOARD_LIMIT; col++) {
            if (col == cellCol) continue;
            removePossible(possibleCell, board[cellRow][col]);
        }
    }

    private void checkCol(int cellRow, int cellCol) {
        PossibleCell possibleCell = progress[cellRow][cellCol];
        for (int row = 0; row < BOARD_LIMIT; row++) {
            if (row == cellRow) continue;
            removePossible(possibleCell, board[row][cellCol]);
        }
    }

    private void checkBlock(int cellRow, int cellCol) {
        // find block limits, then traverse it in the way similar to row/column
        int leftLimit = (cellCol / BLOCK_SIZE) * BLOCK_SIZE; // truncation will not result into same col
        int rightLimit = leftLimit + BLOCK_SIZE; // exclusively
        int topLimit = (cellRow / BLOCK_SIZE) * BLOCK_SIZE; // truncation will not result into same row
        int bottomLimit = topLimit + BLOCK_SIZE; // exclusively
        PossibleCell possibleCell = progress[cellRow][cellCol];
        for (int row = topLimit; row < bottomLimit; row++) {
            for (int col = leftLimit; col < rightLimit; col++) {
                if (row == cellRow && col == cellCol) continue;
                removePossible(possibleCell, board[row][col]);
            }
        }
    }

    private void removePossible(PossibleCell possibleCell, int curVal) {
        if (curVal != 0) {
            possibleCell.remove(curVal);
        }
    }

    private boolean fillDefined() {
        boolean atLeastOneFilled = false;
        for (int row = 0; row < BOARD_LIMIT; row++) {
            for (int col = 0; col < BOARD_LIMIT; col++) {
                if (board[row][col] == 0 && progress[row][col].isDefined()) {
                    board[row][col] = progress[row][col].getDefined();
                    atLeastOneFilled = true;
                }
            }
        }
        return atLeastOneFilled;
    }


    static class PossibleCell {
        private List<Integer> possibleVals;

        PossibleCell(int val) {
            possibleVals = new LinkedList<>();
            if (val != 0) {
                possibleVals.add(val);
            } else {
                for (int i = 1; i <= BOARD_LIMIT; i++) {
                    possibleVals.add(i);
                }
            }
        }

        boolean isDefined() {
            return possibleVals.size() == 1;
        }

        int getDefined() {
            return possibleVals.get(0);
        }

        void remove(int val) {
            possibleVals.remove((Integer) val);
        }
    }

    public static void main(String[] args) {
        Sudoku sol = new Sudoku(new int[][]{
                {0, 0, 0, 0, 0, 5, 4, 0, 9},
                {4, 5, 1, 0, 0, 2, 3, 0, 0},
                {9, 8, 2, 0, 0, 0, 5, 6, 1},
                {6, 0, 7, 0, 0, 0, 9, 8, 0},
                {0, 0, 3, 4, 6, 0, 0, 0, 0},
                {5, 0, 0, 2, 8, 7, 0, 1, 0},
                {0, 4, 0, 0, 7, 0, 0, 9, 6},
                {3, 0, 0, 0, 0, 0, 7, 0, 0},
                {0, 0, 5, 9, 4, 6, 8, 0, 2}
        });
        System.out.println("initial board:");
        sol.printBoard();
        sol.solve();
        System.out.println("solved:");
        sol.printBoard();
        System.out.println("passes:" + sol.passesCount);
    }
}
