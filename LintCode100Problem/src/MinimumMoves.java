public class MinimumMoves {
  public int minMoves2(int[] nums) {

    int median = quickselect(nums, 0, nums.length - 1, (nums.length + 1) / 2);
    int minmoves = 0;

    for (int i = 0; i < nums.length; ++i) {
      minmoves += Math.abs(median - nums[i]);
    }
    return minmoves;
  }

  private int quickselect(int[] nums, int start, int end, int size) {
    int mid = (start + end) / 2;
    int pivot = nums[mid];
    int i = start - 1, j = end + 1;
    for (int k = start; k < j; k++) {
      if (nums[k] < pivot) {
        i++;
        swap(nums[i], nums[k]);
      } else if (nums[k] > pivot) {
        j--;
        swap(nums[j], nums[k]);
        k--;
      }
    }
    if (i - start + 1 >= size) {
      return quickselect(nums, start, i, size);
    } else if (j - start >= size) {
      return nums[j - 1];
    } else {
      return quickselect(nums, j, end, size - (j - start));
    }
  }
}
