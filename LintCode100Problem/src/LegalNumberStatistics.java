public class LegalNumberStatistics {
  public int[] getAns(int[] a, int[][] q) {
    // write your code here
    int n = a.length, m = q.length;
    int[] ans = new int[m];
    for (int j = 0; j < m; j++) {
      int L = q[j][0], R = q[j][1];
      ans[j] = 0;
      for (int i = 0; i < n; i++) {
        if (a[i] >= L && a[i] <= R)
          ans[j]++;
      }
    }
    return ans;
  }
}
