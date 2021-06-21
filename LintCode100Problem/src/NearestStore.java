public class NearestStore {
  public List<Integer> findNearestStore(List<Integer> stores, List<Integer> houses) {
    Collections.sort(stores);
    List<Integer> ans = new ArrayList<>();
    if (stores == null || stores.size() == 0) {
      return ans;
    }
    for (int house : houses) {
      int ClosestStore = search(stores, house);
      ans.add(ClosestStore);
    }
    return ans;
  }

  private int search(List<Integer> stores, int house) {
    int start = 0;
    int end = stores.size() - 1;
    while (start + 1 < end) {
      int mid = start + (end - start) / 2;
      if (stores.get(mid) == house) {
        return house;
      } else if (stores.get(mid) < house) {
        start = mid;
      } else {
        end = mid;
      }
    }
    if (Math.abs(house - stores.get(start)) > Math.abs(stores.get(end) - house)) {
      return stores.get(end);
    } else {
      return stores.get(start);
    }
  }

}
