import java.util.HashMap;

public class PerfectRectangle {
  public boolean isRectangleCover(int[][] rectangles) {
    // write your code here
    Map<String, Integer> map = new HashMap<String, Integer>();
    for (int i = 0; i < rectangles.length; i++) {
      for (int j = 0; j < 4; j++) { // 枚举四个顶点
        String tem = String.valueOf(rectangles[i][j / 2 * 2]) + ',' + String.valueOf(rectangles[i][j % 2 * 2 + 1]); // 字符串保存坐标
        int tmp;
        if (map.containsKey(tem)) {
          tmp = map.get(tem).intValue();
        } else {
          tmp = 0;
        }
        if ((tmp & (1 << j)) > 0) { // 如果当前点在其他矩形的同样顶点位置出现
          return false;
        }
        tmp |= (1 << j); // 将当前点在该矩形的此处顶点位置计入
        map.remove(tem);
        map.put(tem, Integer.valueOf(tmp));
      }
    }
    int cntCorner = 0;
    for (Map.Entry<String, Integer> entry : map.entrySet()) {
      int sec = entry.getValue().intValue();
      if ((sec & (sec - 1)) == 0 && cntCorner++ > 4) { // 如果cntCorner(顶点数)大于4
        return false;
      }
      if (((sec & (sec - 1)) > 0) && ((sec == 3 || sec == 12 || sec == 5 || sec == 10 || sec == 15) == false)) { // 3,12,5,10,15分别代表该点出现2次和4次
        if ((sec & (sec - 1)) > 0) {
          System.out.println(sec);
        }
        return false;
      }
    }
    return true;
  }
}
