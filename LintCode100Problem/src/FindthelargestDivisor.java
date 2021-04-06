public class FindthelargestDivisor {
    public int FindDivisor(int[] A, int k) {
        int n = A.length;
        int left = 1, right = 1;
        int d = 0;

        for (int i = 0; i < n; i++) {
            right = Math.max(right, A[i]);
        }
        while(left < right) {
            int mid = (left + right) / 2;
            long sum = 0;
            for(int i = 0; i < n; i++) {
                sum += A[i] / mid + (A[i]%mid == 0?0:1);
            }
            if(sum >= k) {
                d = mid;
                left = mid + 1;
            }
            else
            {
                right = mid;
            }
        }
        return d;
    }
}
