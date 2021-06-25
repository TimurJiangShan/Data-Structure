public class BoatsSaveToPeople {
  /**
   * @param people: The i-th person has weight people[i].
   * @param limit:  Each boat can carry a maximum weight of limit.
   * @return: Return the minimum number of boats to carry every given person.
   */
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
