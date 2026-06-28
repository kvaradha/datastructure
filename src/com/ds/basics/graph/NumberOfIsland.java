package com.ds.basics.graph;

/**
 * Code No: 200 - Number of islands
 *
 * @author Karthikeyan
 */
public class NumberOfIsland {

    /**
     * Number of Island
     *
     * @param grid char[][]
     * @return int
     */
    public static int numberOfIslands(char [][]grid) {
        int numberOfIsland = 0;
        for(int i=0; i<grid.length; i++) {
            for(int j=0; j<grid[0].length; j++) {
                if(grid[i][j] == '1') {
                    numberOfIsland++;
                    dfs(grid, i, j);
                }
            }
        }
        return numberOfIsland;
    }

    private static void dfs(char[][]grid, int r, int c) {
        if(r < 0 || c < 0 || r >= grid.length || c >= grid[0].length || grid[r][c] == '0') {
            return;
        }
        // Mark as visited.
        grid[r][c] = '0';
        dfs(grid, r, c+1);
        dfs(grid, r,c-1);
        dfs(grid, r+1, c);
        dfs(grid, r-1, c);
    }

    public static void main(String []args) {
        char[][] grid = {
                {'1','1','0','0','0'},
                {'1','1','0','0','0'},
                {'0','0','1','0','0'},
                {'0','0','0','1','1'}
        };
        System.out.println(numberOfIslands(grid));
    }
}
