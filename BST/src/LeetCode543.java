public class LeetCode543 {
      public class TreeNode {
      int val;
      TreeNode left;
      TreeNode right;
      TreeNode() {}
      TreeNode(int val) { this.val = val; }
      TreeNode(int val, TreeNode left, TreeNode right) {
          this.val = val;
          this.left = left;
          this.right = right;
      }
  }

    // 标记最大的直径
    private int maxDiameter = 0;

    public int diameterOfBinaryTree(TreeNode root) {
        // 如果是空节点，返回0
        if(root==null) return 0;

        // 进入递归
        maxDepth(root);
        return this.maxDiameter;
    }

    public int maxDepth(TreeNode root) {

        // 如果存在左子树，递归遍历左子树(求左子树的深度)
        int leftDepth = root.left==null ? 0 : maxDepth(root.left);

        // 如果存在右子树，递归遍历右子树(求右子树的深度)
        int rightDepth = root.right==null ? 0 : maxDepth(root.right);

        // 树的深度就是其左、右子树深度的最大值再加 1。
        int currentNodeDepth = Math.max(leftDepth, rightDepth) + 1;

        // 此时左子树的深度和右子树的深度都求出来了，计算以当前节点为根节点的左右节点的路径长度
        // 两个叶子节点之间的路径 = 根节点左右二个子树的深度之和
        // 如果这个路径比之前记录的maxDiameter大，就更新maxDiameter；否则保持不变。
        this.maxDiameter = Math.max(this.maxDiameter, leftDepth+rightDepth);

        // 返回当前节点的深度
        return currentNodeDepth;
    }

}

/*
* 1. 递归函数的三个关键点
* 2. 树的深度的定义
* 3. 树的直径的定义
* 4. 两节点之间路径的定义
*
*
* 1. 递归函数三要素：
*           1. 子问题与原问题做同样的事情
*           2. 需要有一个递归结束的出口
*           3. 递归表达式
*
* 2. 当前节点的深度
*   如果根结点只有左子树而没有右子树， 那么树的深度应该是其左子树的深度加 1，
 *  同样如果根结点只有右子树而没有左子树，那么树的深度应该是其右子树的深度加 1。
 *  如果既有右子树又有左子树， 那该树的深度就是其左、右子树深度的较大值再加 1。
*
* 4. 如何求两个叶子节点之间的路径长度
*   两个叶子节点之间的路径 = 根节点左右二个子树的深度之和
*
*
*
* */


