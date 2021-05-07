public class SubArrayMinimumsSum {
  class Solution {
    public:
        /**
         * @param A: an array
         * @return: the sum of subarray minimums
         */
        int sumSubarrayMins(vector<int> &A) {
            // Write your code here.
            int res = 0, n = A.size(), mod = 1e9 + 7, j, k;
            stack<int> s;
            for (int i = 0; i <= n; ++i) {
                while (!s.empty() && A[s.top()] > (i == n ? 0 : A[i])) {
                    j = s.top(), s.pop();
                    k = s.empty() ? -1 : s.top();
                    res = (res + A[j] * (i - j) * (j - k)) % mod;
                }
                s.push(i);
            }
            return res;
        }
    };
}
