public class LeetCode101 {
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

    public boolean isSymmetric(TreeNode root) {
        // 如果是空节点，显然对称
        if(root == null) return true;
        return helper(root.left, root.right);
    }

    private boolean helper(TreeNode root1, TreeNode root2) {
        // 如果左右子树同时为空，只有一个节点，显然对称
        if(root1 == null && root2 == null) return true;

        // 如果左右子树有一个为空，一个不为空，显然不对称；如果左右节点的值不相等，显然不对称
        if(root1 == null || root2 == null || root1.val != root2.val) return false;

        // 递归的判断左子树和右子树是否对称
        return helper(root1.left, root2.right) && helper(root1.right, root2.left);
    }
}
