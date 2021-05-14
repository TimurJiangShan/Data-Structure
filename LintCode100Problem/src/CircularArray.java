public class CircularArray {
  public:
    /**
     * @param nums: an array of positive and negative integers
     * @return: if there is a loop in this array
     */
    bool circularArrayLoop(vector<int> &nums) {
        // Write your code here
        int n = nums.size();
        for(int i = 0; i < n; ++i) {
            if (nums[i] == 0) {
                continue;
            }
        
            int j = i;
            int k = getIndex(i, nums);
        
            while (nums[k] * nums[i] > 0 && nums[getIndex(k, nums)] * nums[i] > 0) {
                if (j == k) {
                    if (j == getIndex(j, nums)) {
                        break;
                    }
                    return true;
                }
                j = getIndex(j, nums);
                k = getIndex(getIndex(k, nums), nums);
            }
        
            j = i;
            int val = nums[i];
            while (nums[j] * val > 0) {
                int next = getIndex(j, nums);
                nums[j] = 0;
                j = next;
            }
        }
        return false;
    }

  int getIndex(int i, vector<int> &nums) {
        int n = nums.size();
        return i + nums[i] >= 0 ? (i + nums[i]) %n : n + ((i + nums[i]) % n);
    }
}
