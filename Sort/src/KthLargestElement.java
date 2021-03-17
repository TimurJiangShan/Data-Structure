public class KthLargestElement {
    // Version1： 从大到小排序， 然后取第N个元素
    public int kthLargestElement(int n, int[] nums) {
        // write your code here
        if (nums == null || nums.length == 0 || n < 1 || n > nums.length){
            return -1;
        }

        return partition(nums, 0, nums.length-1, n);
    }

    private int partition(int[] nums, int start, int end, int k){
        if (start >= end) {
            return nums[start];
        }

        int left = start, right = end;
        int pivot = nums[(left + right)/2];
        while (left <= right) {
            while (left <= right && nums[left] > pivot) {
                left++;
            }

            while (left <= right && nums[right] < pivot) {
                right--;
            }

            if (left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if (start + k - 1 <= right) {
            return partition(nums, start, right, k);
        }
        if (start + k - 1 >= left) {
            return partition(nums, left, end, k - (left - start));
        }

        return nums[right+1];
    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }

    // Version2：从小到大排序，取第 （数组长度 - N）大的元素
    /*
    *  public int kthLargestElement(int n, int[] nums) {
        // write your code here
        if(nums == null || nums.length == 0 || n < 1 || n > nums.length){
            return -1;
        }
        return partition(nums, 0, nums.length-1, nums.length - n);
    }

    private int partition(int[] nums, int start, int end, int k){
        if(start >= end) {
            return nums[k];
        }
        int left = start, right = end;
        int pivot = nums[(left+right)/2];

        while(left <= right){
            while(left <= right && nums[left] < pivot){
                left++;
            }
            while(left <= right && nums[right] > pivot){
                right--;
            }

            if(left <= right) {
                swap(nums, left, right);
                left++;
                right--;
            }
        }

        if(k <= right) {
            return partition(nums, start, right, k);
        }
        if(k >= left) {
            return partition(nums, left, end, k);
        }

        return nums[k];
    }

    private void swap(int[] num, int i, int j){
        int temp = num[j];
        num[j] = num[i];
        num[i] = temp;
    }
    *
    * */
}
