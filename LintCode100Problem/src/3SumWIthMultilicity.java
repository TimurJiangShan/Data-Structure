public class 3SumWIthMultilicity {
  public int threeSumMulti(int[] A, int target) {
    // Write your code here
    long[] counter = new long[101];
    // 对A中的元素进行计数，counter[a]表示值为a的数量
    for (int a : A) {
        counter[a]++;
    }
    long res = 0;
    // 遍历所有可能的组合情况，并计算当前组合的数量
    // 注意此循环内的 i, j, k 为值而非A中元素的下标
    for (int i = 0; i <= 100; i++) {
        for (int j = i; j <= 100; j++) {
            int k = target - i - j;
            if (k > 100 || k < 0) {
                continue;
            }
            
            if (i == j && j == k) {
                // 3个元素相等的情况
                res += counter[i] * (counter[i] - 1) * (counter[i] - 2) / 6;
            } else if (i == j && j != k) {
                // 其中两个元素相等的情况
                res += counter[i] * (counter[i] - 1) / 2 * counter[k];
            } else if (j < k) {
                // 三个元素均不相等的情况，为了防止重复计算所以规定了元素之间的大小关系
                res += counter[i] * counter[j] * counter[k];
            }
        }
    }
    return (int)(res % (1e9 + 7));
}
}
