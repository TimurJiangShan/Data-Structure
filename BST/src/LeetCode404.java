public class LeetCode404 {
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

    public int sumOfLeftLeaves(TreeNode root) {
        if(root == null) return 0;
        return processSubtree(root, false);
    }

    private int processSubtree(TreeNode root, boolean isLeft) {
        if(root.left == null && root.right == null) {
            return isLeft ? root.val : 0;
        }

        int total = 0;
        if(root.left != null) {
            total += processSubtree(root.left, true);
        }

        if(root.right != null) {
            total += processSubtree(root.right, false);
        }

        return total;
    }
}
