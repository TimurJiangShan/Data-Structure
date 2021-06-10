public class MatrixRestoration {
  public int[][] matrixRestoration(int n, int m, int[][] after) {
    // 倒序遍历矩阵
    for (int i = n - 1; i >= 0; i--) {
      for (int j = m - 1; j >= 0; j--) {
        // 减去上面的部分
        if (i > 0) {
          after[i][j] -= after[i - 1][j];
        }
        // 减去左面的部分
        if (j > 0) {
          after[i][j] -= after[i][j - 1];
        }
        // 加上重复减去的部分
        if (i > 0 && j > 0) {
          after[i][j] += after[i - 1][j - 1];
        }
      }
    }
    return after;
  }
}
