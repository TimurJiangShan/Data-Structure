public class DetectCapital {
  public boolean detectCapitalUse(String word) {
    // write your code here
    int countUpper = 0, countLower = 0;
    boolean flag = word.charAt(0) >= 'A' && word.charAt(0) <= 'Z';
    for (int i = 0; i < word.length(); i++) {
      if (word.charAt(i) >= 'A' && word.charAt(i) <= 'Z') {
        countUpper++;
        if (i != 0 && countLower > 0 && !flag)
          return false;
        if (countLower > 0 && countUpper > 1)
          return false;
      } else {
        countLower++;
        if (countUpper > 1)
          return false;
      }
    }
    return true;
  }
}
