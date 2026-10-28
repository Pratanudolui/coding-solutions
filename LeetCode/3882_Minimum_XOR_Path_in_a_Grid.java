class Solution {
    private int ans;
    private boolean[][][] memo;

    public int minCost(int[][] grid) {
        int m = grid.length;
        int n = grid[0].length;

        ans = Integer.MAX_VALUE;
        memo = new boolean[m][n][1024];

        dfs(grid, 0, 0, 0, m, n);

        return ans;
    }

    private void dfs(int[][] grid, int i, int j, int xor, int m, int n) {
        xor ^= grid[i][j];

        // 0 is the minimum possible XOR
        if (ans == 0)
            return;

        // Already visited this state
        if (memo[i][j][xor])
            return;

        memo[i][j][xor] = true;

        // Destination reached
        if (i == m - 1 && j == n - 1) {
            ans = Math.min(ans, xor);
            return;
        }

        // Move down
        if (i + 1 < m)
            dfs(grid, i + 1, j, xor, m, n);

        // Move right
        if (j + 1 < n)
            dfs(grid, i, j + 1, xor, m, n);
    }
}
