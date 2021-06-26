public class Movies
on Flight
{

  public int[] FlightDetails(int[] arr, int k) {
    // write your code here
    if (arr == null || arr.length < 2) {
      return new int[0];
    }

    class Pair {
      int index;
      int value;

      Pair(int index, int value) {
        this.index = index;
        this.value = value;
      }
    }

    class PairComparator implements Comparator<Pair> {
      public int compare(Pair one, Pair two) {
        return one.value - two.value;
      }
    }

    List<Pair> list = new ArrayList<>();
    for (int i = 0; i < arr.length; i++) {
      list.add(new Pair(i, arr[i]));
    }

    Collections.sort(list, new PairComparator());

    int[] result = new int[2];
    result[0] = -1;
    result[1] = -1;
    int maxLen = Integer.MIN_VALUE;
    int longer = Integer.MIN_VALUE;

    int left = 0;
    int right = list.size() - 1;

    while (left < right) {
      int sum = list.get(left).value + list.get(right).value;
      if (sum <= k - 30) {
        if (sum > maxLen) {
          result[0] = Math.min(list.get(left).index, list.get(right).index);
          result[1] = Math.max(list.get(left).index, list.get(right).index);
          maxLen = sum;
          longer = Math.max(list.get(left).value, list.get(right).value);
        } else if (sum == maxLen) {
          if (longer < Math.max(list.get(left).value, list.get(right).value)) {
            result[0] = Math.min(list.get(left).index, list.get(right).index);
            result[1] = Math.max(list.get(left).index, list.get(right).index);
            maxLen = sum;
            longer = Math.max(list.get(left).value, list.get(right).value);
          }
        }
        left++;
      } else {
        right--;
      }
    }
    return result;
  }
}
