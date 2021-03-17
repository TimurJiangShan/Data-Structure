public class KthLargestElement {
    public int kthLargestElement(int k, int[] nums){
        if (nums == null || nums.length == 0 || k < 1 || k > nums.length){
            return -1;
        }
        // 第K大，意味着总后往前是 长度 - K
        return partition(nums, 0, nums.length-1, nums.length-k);
    }

    private int partition(int[] nums, int start, int end, int k){
        if (start >= end) {
            return nums[k];
        }

        int left = start, right = end;
        int pivot = nums[(start + end)/2];
        while (left <= right) {
            while (left <= right && nums[left] < pivot) {
                left++;
            }

            while (left <= right && nums[right] > pivot) {
                right++;
            }

            if (left <= right) {
                swap(nums, left, right);
            }
        }

        if (k <= right) {
            return partition(nums, start, right, k);
        }
        if (k >= left) {
            return partition(nums, left, end, k);
        }

        return nums[k];
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
