public class ProblemCanIaccept {
    public long canAccept(long n, int k) {
        // Write your code here
        long l = 0;
        long r = (long)Math.sqrt(2 * n);
        while(l + 1 < r) {
            long mid = (l + r) / 2;
            long sum = k * (1 + mid) * mid / 2;
            if(sum <= n) {
                l = mid;
            }
            else {
                r = mid;
            }
        }
        if(k * (1 + r) * r / 2 <= n) {
            return r;
        }
        else {
            return l;
        }
    }
}
