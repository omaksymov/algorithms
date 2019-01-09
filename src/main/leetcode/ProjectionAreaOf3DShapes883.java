package leetcode;

/**
 * On a N * N grid, we place some 1 * 1 * 1 cubes that are axis-aligned with the x, y, and z axes.
 * Each value v = grid[i][j] represents a tower of v cubes placed on top of grid cell (i, j).
 *
 * Now we view the projection of these cubes onto the xy, yz, and zx planes.
 * A projection is like a shadow, that maps our 3 dimensional figure to a 2 dimensional plane.
 * Here, we are viewing the "shadow" when looking at the cubes from the top, the front, and the side.
 *
 * Return the total area of all three projections.
 *
 * See examples in a test class.
 *
 * Note:
 * 1 <= grid.length = grid[0].length <= 50
 * 0 <= grid[i][j] <= 50
 */
public class ProjectionAreaOf3DShapes883 {
    /**
     * Initial solution, obvious to understand
     */
    static class Solution1 {
        public int projectionArea(int[][] grid) {
            int xy = countXYProjection(grid);
            int xz = countXZProjection(grid);
            int yz = countYZProjection(grid);
            return xy + xz + yz;
        }

        // Every non-zero height of cell adds up into 1 area item
        private int countXYProjection(int[][] a) {
            int n = a.length;
            int area = 0;
            for (int i = 0; i < n; i++) {
                for (int j = 0; j < n; j++) {
                    if (a[i][j] != 0) {
                        area++;
                    }
                }
            }
            return area;
        }

        // For every x find the maximum height z and add all max values - it will be xz projection area
        private int countXZProjection(int[][] a) {
            int n = a.length;
            int area = 0;
            for (int i = 0; i < n; i++) {
                int max = a[i][0];
                for (int j = 1; j < n; j++) {
                    if (a[i][j] > max) {
                        max = a[i][j];
                    }
                }
                area += max;
            }
            return area;
        }

        // For every y find the maximum height z and add all max values - it will be yz projection area
        private int countYZProjection(int[][] a) {
            int n = a.length;
            int area = 0;
            for (int j = 0; j < n; j++) {
                int max = a[0][j];
                for (int i = 1; i < n; i++) {
                    if (a[i][j] > max) {
                        max = a[i][j];
                    }
                }
                area += max;
            }
            return area;
        }
    }

    /**
     * Optimized version of Solution1: instead of (3 * n^2) runtime we have n^2
     */
    static class Solution2 {
        public int projectionArea(int[][] grid) {
            int[][] a  = grid;
            int n = a.length;
            int areaXY = 0;
            int areaXZ = 0;
            int areaYZ = 0;
            for (int i = 0; i < n; i++) {
                int maxX = a[i][0];
                int maxY = a[0][i];
                for (int j = 0; j < n; j++) {
                    if (a[i][j] != 0) {
                        areaXY++;
                    }
                    if (a[i][j] > maxX) {
                        maxX = a[i][j];
                    }
                    if (a[j][i] > maxY) {
                        maxY = a[j][i];
                    }
                }
                areaXZ += maxX;
                areaYZ += maxY;
            }
            return areaXY + areaXZ + areaYZ;
        }
    }
}
