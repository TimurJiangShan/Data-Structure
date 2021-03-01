public class LeetCode112 {
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

   /*
        思路： 先判断是不是空节点，如果是，直接返回false
        采用sum 减去 当前节点val的方法，如果当前节点的值 == 传进来的sum 并且当前节点是叶子节点，就返回true如果当前节点不满足条件，就分别去左子树和右子树寻找，所以中间是 or 的关系
    */

    public boolean hasPathSum(TreeNode root, int targetSum) {
        return helper(root, targetSum);
    }

    private boolean helper(TreeNode root, int targetSum) {
        if(root == null)
            return false;

        if(root.left == null && root.right == null && root.val == targetSum)
            return true;
        else
            return helper(root.left, targetSum - root.val) || helper(root.right, targetSum - root.val);

    }
}
