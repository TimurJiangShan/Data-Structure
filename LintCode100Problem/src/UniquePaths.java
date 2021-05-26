public class UniquePaths {
    // for java
    public int uniqueWeightedPaths(int[][] grid) {
        int n = grid.length;
        int m = grid[0].length;
        if (n == 0 || m == 0)
            return 0;
        Set[][] s = new HashSet[n][m];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < m; j++) {
                s[i][j] = new HashSet();
                if (i == 0 && j == 0) {
                    s[i][j].add(grid[0][0]);
                } else {
                    if (i != 0) {
                        for (Object val : s[i - 1][j]) {
                            s[i][j].add((int) val + grid[i][j]);
                        }
                    }
                    if (j != 0) {
                        for (Object val : s[i][j - 1]) {
                            s[i][j].add((int) val + grid[i][j]);
                        }
                    }
                }
            }
        }
        int ans = 0;
        for (Object val : s[n - 1][m - 1]) {
            ans += (int) val;
        }
        return ans;
    }
}
