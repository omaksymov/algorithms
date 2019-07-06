package mockinterview;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.junit.runners.Parameterized;

import java.util.HashSet;
import java.util.Set;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.*;

@RunWith(Parameterized.class)
public class SudokuTest {
    @Parameterized.Parameters
    public static SudokuTestItem[] data() {
        return new SudokuTestItem[]{
                new SudokuTestItem(new int[][]{
                        {0, 0, 0, 0, 0, 5, 4, 0, 9},
                        {4, 5, 1, 0, 0, 2, 3, 0, 0},
                        {9, 8, 2, 0, 0, 0, 5, 6, 1},
                        {6, 0, 7, 0, 0, 0, 9, 8, 0},
                        {0, 0, 3, 4, 6, 0, 0, 0, 0},
                        {5, 0, 0, 2, 8, 7, 0, 1, 0},
                        {0, 4, 0, 0, 7, 0, 0, 9, 6},
                        {3, 0, 0, 0, 0, 0, 7, 0, 0},
                        {0, 0, 5, 9, 4, 6, 8, 0, 2}
                }),
                new SudokuTestItem(new int[][]{
                        {0, 0, 5, 0, 7, 0, 2, 6, 0},
                        {7, 0, 3, 0, 0, 0, 0, 8, 1},
                        {9, 0, 0, 0, 6, 5, 0, 0, 0},
                        {8, 3, 0, 7, 5, 0, 0, 4, 0},
                        {0, 7, 0, 4, 0, 9, 1, 0, 0},
                        {5, 0, 0, 3, 0, 0, 0, 0, 0},
                        {0, 0, 0, 2, 0, 0, 6, 9, 0},
                        {0, 0, 6, 0, 4, 0, 0, 0, 2},
                        {0, 0, 0, 0, 0, 0, 0, 5, 7}
                })
        };
    }

    private SudokuTestItem testItem;

    public SudokuTest(SudokuTestItem testItem) {
        this.testItem = testItem;
    }

    static class SudokuTestItem {
        int[][] board;

        SudokuTestItem(int[][] board) {
            this.board = board;
        }
    }

    @Test
    public void testSudokuSolution() {
        Sudoku sol = new Sudoku(testItem.board);
        sol.solve();
        assertThat(checkFilledBoard(sol.board), is(true));
    }

    private boolean checkFilledBoard(int[][] board) {
        int n = board.length;
        for (int row = 0; row < n; row++) {
            for (int col = 0; col < n; col++) {
                if (board[row][col] == 0) return false;
            }
        }
        boolean res;
        for (int row = 0; row < n; row++) {
            res = checkRow(row, board);
            if (!res) return false;
        }
        for (int col = 0; col < n; col++) {
            res = checkCol(col, board);
            if (!res) return false;
        }
        for (int i = 0; i < n / 3; i++) {
            for (int j = 0; j < n / 3; j++) {
                res = checkBlock(i, j, board);
                if (!res) return false;
            }
        }
        return true;
    }

    private boolean checkRow(int row, int[][] board) {
        Set<Integer> set = newFullSet(board);
        boolean res;
        for (int i = 0; i < board.length; i++) {
            res = set.remove(board[row][i]);
            if (!res) return false;
        }
        return set.isEmpty();
    }

    private Set<Integer> newFullSet(int[][] board) {
        Set<Integer> set = new HashSet<>();
        for (int i = 1; i <= board.length; i++) {
            set.add(i);
        }
        return set;
    }

    private boolean checkCol(int col, int[][] board) {
        Set<Integer> set = newFullSet(board);
        boolean res;
        for (int[] ints : board) {
            res = set.remove(ints[col]);
            if (!res) return false;
        }
        return set.isEmpty();
    }

    private boolean checkBlock(int blockHorizontalIndex, int blockVerticalIndex, int[][] board) {
        Set<Integer> set = newFullSet(board);
        boolean res;
        for (int row = blockHorizontalIndex * 3; row < blockHorizontalIndex * 3 + 3; row++) {
            for (int col = blockVerticalIndex * 3; col < blockVerticalIndex * 3 + 3; col++) {
                res = set.remove(board[row][col]);
                if (!res) return false;
            }
        }
        return set.isEmpty();
    }
}