public class LongestPalindromicSubstring {
    // 动态规划解法
    /*
    * Build a 2D Boolean matrix with size N*N, element[i,j] is
    * True if sub-string S[i]...S[j] is a palindromic, otherwise False;
    * */
    public String longestPalindrome(String s) {
        if(s == null || s.length() == 0) return "";

        int n = s.length();
        boolean[][] isPalindrome = new boolean[n][n];

        int longest = 1, start = 0;
        for (int i = 0; i < n; i++) {
            isPalindrome[i][i] = true;
        }

        for (int i = 0; i < n - 1; i++) {
            isPalindrome[i][i+1] = s.charAt(i) == s.charAt(i+1);
            if(isPalindrome[i][i+1]){
                start = i;
                longest = 2;
            }
        }

        for (int i = n-1; i >= 0; i--) {
            for (int j = i+2; j < n; j++){
                isPalindrome[i][j] = isPalindrome[i+1][j-1] && s.charAt(i) == s.charAt(j);
                if (isPalindrome[i][j] && j-i+1 > longest) {
                    start = i;
                    longest = j-i+1;
                }
            }
        }

        return s.substring(start, start + longest);
    }
}
