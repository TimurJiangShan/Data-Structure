import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
/**
 * 暴力枚举三个数复杂度为O(N^3) 先考虑2Sum的做法，假设升序数列a，对于一组解ai,aj, 另一组解ak,al 必然满足 i<k j>l 或 i>k j<l,
 * 因此我们可以用两个指针，初始时指向数列两端 指向数之和大于目标值时，右指针向左移使得总和减小，
 * 反之左指针向右移 由此可以用O(N)的复杂度解决2Sum问题，3Sum则枚举第一个数
 * O(N2)使用有序数列的好处是，在枚举和移动指针时值相等的数可以跳过，省去去重部分
 * */

public class ThreeSum {
    private void findTwoSum(int[] nums, int index, List<List<Integer>> results){
        int left = index + 1, right = nums.length - 1;
        int target = -nums[index];

        while (left < right) {
            int twoSum = nums[left] + nums[right];
            if (twoSum < target) {
                left++;
            } else if(twoSum > target){
                right--;
            } else {
                List<Integer> triple = new ArrayList();
                triple.add(nums[index]);
                triple.add(nums[left]);
                triple.add(nums[right]);
                results.add(triple);
                left++;
                right--;
                while (left < right && nums[left] == nums[left-1]){
                    left++;
                }
            }
        }
    }

    public List<List<Integer>> threeSum(int[] numbers){
        Arrays.sort(numbers);

        List<List<Integer>> result = new ArrayList();
        for (int i = 0; i < numbers.length; i++) {
            if (i != 0 && numbers[i] == numbers[i-1]) {
                continue;
            }
            findTwoSum(numbers, i , result);
        }

        return result;
    }
}
