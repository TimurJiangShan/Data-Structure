public class Interearray {
  public int maxLen(int[] tree) {
    int cur = 0, max = 0, a = 0, b = 0, count_b = 0;
    for (int num : tree) {
      if (num == a || num == b) {
        cur++;
      } else {
        cur = count_b + 1;
      }
      if (num == b) {
        count_b++;
      } else {
        count_b = 1;
        a = b;
        b = num;
      }
      max = Math.max(max, cur);
    }
    return max;
  }
}
