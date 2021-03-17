public class SortColor {
    public void sortColors(int[] nums) {
        // write your code here
        if(nums == null) {
            return;
        }
        quickSort(nums, 0, nums.length-1);
    }

    private void quickSort(int[] nums, int start, int end){
        if(start >= end) {
            return;
        }
        int left = start, right = end;
        int pivot = nums[(start+end)/2];
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

        quickSort(nums, start, right);
        quickSort(nums, left, end);

    }

    private void swap(int[] nums, int i, int j){
        int temp = nums[j];
        nums[j] = nums[i];
        nums[i] = temp;
    }
}
