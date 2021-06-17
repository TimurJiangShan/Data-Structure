public class DecreasePalindrome {
  public int numberOfOperations(String s) {
    char[] str = s.toCharArray();
    int n = s.length();
    int cnt = 0;
    for (int i = 0, j = n - 1; i < j; i++, j--) {
      cnt += Math.abs(str[i] - str[j]);
    }
    return cnt;
  }
}
