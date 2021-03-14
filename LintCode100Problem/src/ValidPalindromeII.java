public class ValidPalindromeII {
    public class Solution {
        /**
         * @param s: a string
         * @return: whether you can make s a palindrome by deleting at most one character
         */

        private class Pair{
            public int left;
            public int right;
            public Pair(int left, int right) {
                this.left = left;
                this.right = right;
            }
        }

        public boolean validPalindrome(String s) {
            // Write your code here
            if(s == null) return true;
            Pair difference = findDifference(s, 0, s.length()-1);
            if(difference.left >= difference.right) return true;
            return isValidPalindrome(s, difference.left+1, difference.right) || isValidPalindrome(s, difference.left, difference.right-1);

        }

        private Pair findDifference(String s, int left, int right){
            while(left < right && s.charAt(left) == s.charAt(right)) {
                left++;
                right--;
            }
            return new Pair(left, right);
        }

        private boolean isValidPalindrome(String s, int left, int right){
            Pair difference = findDifference(s, left, right);
            return difference.left >= difference.right;
        }

    }
}
