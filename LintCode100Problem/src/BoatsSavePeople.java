public class BoatsSavePeople {
  public int numRescueBoats(List<Integer> people, int limit) {
    // Write your code here.
    Collections.sort(people);
    int i = 0, j = people.size() - 1;
    int ans = 0;

    while (i <= j) {
      ans++;
      if (people.get(i) + people.get(j) <= limit)
        i++;
      j--;
    }

    return ans;
  }
}
