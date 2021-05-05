public class KDifference {
  public int KDifference(int[] nums, int target) {
    // write your code here
    Map<Integer, Integer> map = new HashMap<Integer, Integer>();
    int ans = 0;
    for (int i = 0; i < nums.length; i++)
      map.put(nums[i], 1);
    for (int i = 0; i < nums.length; i++)
      if (map.containsKey(nums[i] - target))
        ans++;
    return ans;
  }
}
