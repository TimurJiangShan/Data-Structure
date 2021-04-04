public class BuildaTemple {
    public int buildTemple(int m, List<Integer> woods) {
        // write your code here.
        int n = woods.size();
        int l = 0;
        int r = Integer.MAX_VALUE;
        int ans = Integer.MIN_VALUE;
        while (l <= r) {
            int mid = l + (r-l)/2;               //二分答案
            if (check(woods,mid,m)) {			 //check枚举的答案是否可行
                l = mid + 1;
                ans = mid;
            }
            else {
                r = mid - 1;
            }
        }
        return ans;
    }
    public boolean check(List<Integer> woods, int mid, int m) {
        int number = 0;
        for (int i = 0; i < woods.size(); i++) {
            number += woods.get(i)/mid;
        }
        if (number >= m) return true;
        return false;
    }
}
