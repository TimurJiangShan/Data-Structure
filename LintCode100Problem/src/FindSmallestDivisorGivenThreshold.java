public class FindSmallestDivisorGivenThreshold {
    Boolean check(int[] nums, int mid, int threshold) {
        int total = 0;
        for (int i = 0; i < nums.length; i++) total += (nums[i] + mid - 1) / mid;
        if (total <= threshold) return true;
        return false;
    }
    public int smallestDivisor(int[] nums, int threshold) {

        int left = 1, right = nums[0];

        for (int i = 0; i < nums.length; i++) right = Math.max(nums[i], right);
        while (left + 1 < right) {
            int mid = (left + right) / 2;
            if (check(nums, mid, threshold)) right = mid;
            else left = mid;
        }
        if (check(nums, left, threshold)) return left;
        return right;
    }
}
