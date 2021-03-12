public class ValidPalindrome {
    public boolean isPalindrome(String s) {
        // write your code here
        // if(s == null || s.length() == 0) return true;
        String strNew = s.replaceAll("[^A-Za-z0-9]", "");
        if(strNew.length() <= 1) {
            return true;
        }
        int i = 0, j = strNew.length()-1;
        do {
            if(Character.toLowerCase(strNew.charAt(i)) == Character.toLowerCase(strNew.charAt(j))){
                i++;
                j--;
            } else {
                return false;
            }
        } while(i < j);
        return true;
    }
}
