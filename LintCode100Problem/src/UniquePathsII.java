public class UniquePathsII {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        //获取网格的长宽
        int n = obstacleGrid.length,m = obstacleGrid[0].length;
        if (n == 0 || m == 0) {
            return 0;
        }
        int[][] dp = new int[n][m];
        //对于左边界，第一个障碍物或边界前的所有边界点皆可到达
        if (obstacleGrid[0][0] == 0) {
            dp[0][0] = 1;
        }
        for (int i = 0;i < n;i++) {
            for (int j = 0;j < m;j++){
                if (i==0 && j==0) {
                    continue;
                }
                //若遇到障碍物，则跳过
                if (obstacleGrid[i][j] == 1) {
                    continue;
                }
                //对于上边界，第一个障碍物或边界左边的所有边界点皆可到达
                if (i == 0) {
                    dp[i][j] = dp[i][j-1];
                    continue;
                }
                //对于左边界，第一个障碍物或边界前的所有边界点皆可到达
                if (j == 0) {
                    dp[i][j] = dp[i-1][j];
                    continue;
                }
                //到达当前点的路径数等于能到达此点上面的点和左边点的路径数之和
                dp[i][j] = dp[i-1][j] + dp[i][j-1];
            }
        }
        return dp[n-1][m-1];
    }
}
