public class SecondDiameter {
  class Edge {
    int to;
    int value;
    int next;

    public Edge(int to, int value, int next) {
      this.to = to;
      this.value = value;
      this.next = next;
    }
  }

  /**
   * 从begin点开始bfs遍历整个树，并计算出begin到每个点的距离 存到distance数组里
   **/
  void bfs(int begin, int n, long[] distance, Edge[] pointEdge, int[] head) {
    // bfs队列
    Queue<Integer> queue = new LinkedList<Integer>();
    boolean[] visited = new boolean[n];
    for (int i = 0; i < n; i++) {
      visited[i] = false;
    }
    // 将begin压入队列
    visited[begin] = true;
    queue.add(begin);
    distance[begin] = 0L;

    while (!queue.isEmpty()) {
      int now = queue.poll();
      long nowValue = distance[now];
      for (int i = head[now]; i != 0; i = pointEdge[i].next) {
        int to = pointEdge[i].to;
        int value = pointEdge[i].value;
        if (!visited[to]) {
          visited[to] = true;
          distance[to] = value + nowValue;
          queue.add(to);
        }
      }
    }
  }

  /**
   * 从distance数组里找出距离最大的位置
   **/
  int findMaxDistanceIndex(long[] distance) {
    // 初始化最大距离和最大距离所在的数组下标
    long maxDistance = 0;
    int index = 0;
    int size = distance.length;
    // 找出最大距离
    for (int i = 0; i < size; i++) {
      if (distance[i] > maxDistance) {
        maxDistance = distance[i];
        index = i;
      }
    }

    return index;
  }

  /**
   * @param edge: edge[i][0] [1] [2] start point,end point,value
   * @return: return the second diameter length of the tree
   */
  public long getSecondDiameter(int[][] edge) {
    // write your code here
    // 边的数量
    int edgeNumber = edge.length;
    // 点的数量
    int n = edgeNumber + 1;

    // 距离指定起点的距离
    long[] distance = new long[n];
    // 距离直径第一个端点的距离
    long[] distanceOne = new long[n];
    // 距离直径第二个端点的距离
    long[] distanceTwo = new long[n];
    // 每个点储存有哪些边
    int[] head = new int[n];
    Edge[] pointEdge = new Edge[2 * n];
    int edgeCount = 0;
    // 加无向边
    for (int i = 0; i < edgeNumber; i++) {
      ++edgeCount;
      pointEdge[edgeCount] = new Edge(edge[i][1], edge[i][2], head[edge[i][0]]);
      head[edge[i][0]] = edgeCount;
      ++edgeCount;
      pointEdge[edgeCount] = new Edge(edge[i][0], edge[i][2], head[edge[i][1]]);
      head[edge[i][1]] = edgeCount;
    }

    // 从指定的起点开始BFS
    bfs(0, n, distance, pointEdge, head);
    // 找出距离指定起点的最远的点 ，也就是直径的第一个端点
    int diameterFirstPointIndex = findMaxDistanceIndex(distance);
    // 从直径的第一个端点再开始BFS
    bfs(diameterFirstPointIndex, n, distanceOne, pointEdge, head);
    // 找出距离第一个端点最远的点 ，也就是直径的第二个端点
    int diameterSecondPointIndex = findMaxDistanceIndex(distanceOne);
    // 从直径的第二个端点再开始BFS
    bfs(diameterSecondPointIndex, n, distanceTwo, pointEdge, head);

    // 第二直径的值
    long secondDiameter = 0;

    // 遍历每个点，找到每个点的最远距离更新第二直径
    for (int i = 0; i < n; i++) {

      // 最长的边是第一直径，如果我们把第一直径的两个端点去掉，就可以把第一直径给忽略了
      // 这样只需要在忽略第一直径后剩下的距离找一个最大值就是第二直径
      if (i != diameterFirstPointIndex && i != diameterSecondPointIndex) {
        // 到i的最远距离的点肯定是第一直径的两个端点之一
        secondDiameter = Math.max(secondDiameter, Math.max(distanceOne[i], distanceTwo[i]));
      }
    }

    return secondDiameter;
  }
}
