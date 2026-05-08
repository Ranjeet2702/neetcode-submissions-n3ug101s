class Solution {
    public int maxAreaOfIsland(int[][] grid) {
        int maxArea = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == 1) {
                    // har island ka area nikalo
                    int area = dfs(grid, i, j);
                    // max update karo
                    maxArea = Math.max(maxArea, area);
                }
            }
        }
        return maxArea;
    }

    private int dfs(int[][] grid, int i, int j) {
        // boundary ya water → 0 return karo
        if (i < 0 || i >= grid.length ||
            j < 0 || j >= grid[0].length ||
            grid[i][j] == 0) {
            return 0;
        }

        grid[i][j] = 0; // visited mark karo

        // current cell(1) + charo directions ka area
        return 1
            + dfs(grid, i + 1, j)  // neeche
            + dfs(grid, i - 1, j)  // upar
            + dfs(grid, i, j + 1)  // right
            + dfs(grid, i, j - 1); // left
    }
}