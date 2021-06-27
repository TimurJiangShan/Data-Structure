public class HandkerchiefThrowing {
  public int gameTurns(List<Integer> to) {
    int n = to.size();
    int minTurn = n;

    for (int i = 0; i < n; i++) {
      int position = i;
      int turnCount = 0;
      Set<Integer> visited = new HashSet<Integer>();

      position = to.get(position);
      turnCount++;
      while (position != i) {
        position = to.get(position);
        turnCount++;
        // 如果到了已访问过的点，代表这个手绢进入死循环，到不了出发点
        if (visited.contains(position)) {
          break;
        }
        visited.add(position);
      }
      // 只有回到出发点，才算做有效值
      if (position == i) {
        minTurn = Math.min(minTurn, turnCount);
      }
    }

    return minTurn;
  }
}
