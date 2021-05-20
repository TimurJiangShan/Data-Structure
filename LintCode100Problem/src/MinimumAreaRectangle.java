public class MinimumAreaRectangle {
  public int minimumAreaRectangle(int[][] points) {
    // Write your code here.
    int res = Integer.MAX_VALUE;
    List<List<Integer>> list = new ArrayList<List<Integer>>();
    for (int i = 0; i < points.length; i++) {
      List<Integer> list2 = new ArrayList<Integer>();
      for (int j = 0; j < points[i].length; j++) {
        list2.add(points[i][j]);
      }
      list.add(list2);
    }
    Collections.sort(list, new Comparator<List<Integer>>() {
      public int compare(List<Integer> a, List<Integer> b) {
        if (a.get(1).equals(b.get(1)))
          return a.get(0) < b.get(0) ? -1 : 1;
        else
          return a.get(1) < b.get(1) ? -1 : 1;
      }
    });
    for (int i = 0; i < points.length; i++) {
      System.out.println(list.get(i).get(0) + " " + list.get(i).get(1));
    }
    for (int i = 0; i < points.length - 1; ++i) {
      int q = i + 1;
      while (q < points.length) {
        if (!list.get(q).get(0).equals(list.get(i).get(0))) {
          ++q;
          continue;
        }
        int height1 = list.get(q).get(1) - list.get(i).get(1);
        if (height1 == 0)
          continue;
        for (int k = i + 1; k < points.length; ++k) {
          if (!list.get(i).get(1).equals(list.get(k).get(1)))
            break;
          int width = list.get(k).get(0) - list.get(i).get(0);
          if (width == 0)
            continue;
          int height2 = 0;
          int j = k + 1;
          while (j < points.length) {
            if (!list.get(j).get(0).equals(list.get(k).get(0))) {
              ++j;
              continue;
            }
            height2 = list.get(j).get(1) - list.get(k).get(1);
            if (height2 == 0 || height2 != height1) {
              ++j;
              continue;
            }
            res = Math.min(res, width * height2);
            break;
          }
        }
        ++q;
      }
    }
    return res == Integer.MAX_VALUE ? 0 : res;
  }
}
