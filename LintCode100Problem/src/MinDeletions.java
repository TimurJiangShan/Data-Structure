public class MinDeletions {
    public int minDeletionsToObtainStringInRightFormat(String s) {
        // write your code here
        int n = s.length();
        int left_B = 0;
        int right_A = 0;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'A') right_A++;
        }

        int ans = right_A;

        for(int i = 0; i < n; i++) {
            if(s.charAt(i) == 'A') right_A--;
            else {
                left_B++;
            }
            ans = Math.min(ans, right_A + left_B);
        }

        return ans;
    }
}
