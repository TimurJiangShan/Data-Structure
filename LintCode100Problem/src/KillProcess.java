public class KillProcess {
  public List<Integer> killProcess(List<Integer> pid, List<Integer> ppid, int kill) {
    // Write your code here
    List<Integer> ans = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    for (int i = 0; i < pid.size(); i++) {
      map.put(pid.get(i), ppid.get(i));
    }
    for (int i = 0; i < pid.size(); i++) {
      int k = pid.get(i);
      int p = k;
      while (k != 0) {
        if (map.get(k) == kill) {
          ans.add(p);
          break;
        }
        k = map.get(k);
      }
    }
    ans.add(kill);
    return ans;
  }
}
