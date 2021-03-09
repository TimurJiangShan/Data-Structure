import java.util.Arrays;

public class LongestIncreasingSubsequence {

    public int longestIncreasingSubsequence(int[] nums) {
        int[] dp = new int[nums.length];
        // base case: dp 数组全都初始化为1
        // dp[i] 初始值为 1，因为以 nums[i] 结尾的最长递增子序列起码要包含它自己
        Arrays.fill(dp, 1);

        for (int i = 0; i < nums.length; i++) {
            for(int j = 0; j < i; j++) {
                if(nums[i] > nums[j]){
                    dp[i] = Math.max(dp[i], dp[j] + 1);
                }
            }
        }

        int result = 0;
        for (int i = 0; i < dp.length; i++) {
            result = Math.max(result, dp[i]);
        }

        return result;
    }
}
