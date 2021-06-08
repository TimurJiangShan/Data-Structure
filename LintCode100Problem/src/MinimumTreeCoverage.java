public class MinimumTreeCoverage {
  int INF = (int) (1e8);
  int ans;
  int[] dp = new int[200010];
  List<List<Integer>> g;

  void dfs(int u, int pre, int k) {
    int Mn = INF, Mx = -INF;
    for (int i = 0; i < g.get(u).size(); i++) {
      int v = g.get(u).get(i);
      if (v == pre)
        continue;
      dfs(v, u, k);
      Mn = Math.min(Mn, dp[v]);
      Mx = Math.max(Mx, dp[v]);
    }

    if (Mn == INF) {
      dp[u] = -1;
    } else if (Mn <= -k) {
      dp[u] = k;
      ans++;
    } else if (Mn + Mx > 0) {
      dp[u] = Mx - 1;
    } else {
      dp[u] = Mn - 1;
    }
  }

  public int minCover(int[][] a, int k) {
    // write your code here
    int n = a.length + 1;
    g = new ArrayList<List<Integer>>();
    for (int i = 0; i <= n; i++) {
      g.add(new ArrayList<Integer>());
      dp[i] = 0;
    }
    for (int i = 0; i < n - 1; i++) {
      int u = a[i][0], v = a[i][1];
      g.get(u).add(v);
      g.get(v).add(u);
    }
    ans = 0;
    dfs(1, 1, k);
    if (dp[1] < 0) {
      ans++;
    }
    return ans;
  }
}
