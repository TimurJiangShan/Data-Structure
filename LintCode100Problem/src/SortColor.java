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

    // Version2 : 采用双指针的方法，一遍扫描即可。时间复杂度为O(n), 空间复杂度是常量空间(Constant)

    /*
    *
        我们建立首尾双指针left和right，分别指示0/1边界和1/2边界。left左边（不含left）全为0，right右边（不含right）全为2。初始化left和mid为0，right 为len(nums)-1。
        第三个指针mid从left起向right移动，边扫描边实时更新两个边界。
        若 nums[mid]为 0 ：交换第 mid个和第left个元素，并将 left 指针和mid指针都向右移。
        若 nums[mid]为 2 ：交换第 mid个和第 right个元素，并将 right指针左移
        若 nums[mid]为 1 ：将指针mid右移。
        补充一下，当mid与left交换后，mid能够后移，因为此时nums[mid]可能为0，后面还需要与left交换。
    * */
}
