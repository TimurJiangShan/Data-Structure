public class Subarray {
  public int sumSubarrayMins(int[] A) {
    // Write your code here.
    Stack<Integer> s = new Stack<>();
    int n = A.length, res = 0, mod = (int) 1e9 + 7;
    for (int i = 0; i <= n; i++) {
      while (!s.isEmpty() && A[s.peek()] > (i == n ? 0 : A[i])) {
        int j = s.pop();
        int k = s.isEmpty() ? -1 : s.peek();
        res = (res + A[j] * (i - j) * (j - k)) % mod;
      }
      s.push(i);
    }
    return res;
  }
}
