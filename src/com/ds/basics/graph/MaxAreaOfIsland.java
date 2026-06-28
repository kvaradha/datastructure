package com.ds.basics.graph;

/**
 * Code No: 695 - Max Area Of Island
 *
 * @author Karthikeyan
 */
public class MaxAreaOfIsland {
    /**
     * Find Max Area Of Island.
     *
     * @return int
     */
    public static int findMaxArea(int [][]grid) {
        int maxArea = 0;
        for(int i=0; i< grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == 1) {
                    maxArea = Math.max(maxArea, dfs(grid, i, j));
                }
            }
        }
        return maxArea;
    }

    public static int dfs(int [][]grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == 0) {
            return 0;
        }
        // Mark it as visited.
        grid[r][c] = 0;
        int area = 1;
        area = area + dfs(grid, r+1, c);
        area = area + dfs(grid, r-1, c);
        area = area + dfs(grid, r, c+1);
        area = area + dfs(grid, r, c-1);
        return area;
    }

    public static void main(String []args) {
        int [][]grid = {
                {0,0,1,0,0,0,0,1,0,0,0,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,1,1,0,1,0,0,0,0,0,0,0,0},
                {0,1,0,0,1,1,0,0,1,0,1,0,0},
                {0,1,0,0,1,1,0,0,1,1,1,0,0},
                {0,0,0,0,0,0,0,0,0,0,1,0,0},
                {0,0,0,0,0,0,0,1,1,1,0,0,0},
                {0,0,0,0,0,0,0,1,1,0,0,0,0}
        };
        System.out.println(findMaxArea(grid));
    }
}
