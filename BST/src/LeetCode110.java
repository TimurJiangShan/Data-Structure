public class LeetCode110 {
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

    public boolean isBalanced(TreeNode root) {
        // 任意一个节点的左右子树的高度不会相差1
        if(root == null) return true;
        return Math.abs(getHeight(root.left) - getHeight(root.right)) < 2 && isBalanced(root.left) && isBalanced(root.right);
    }

    private int getHeight(TreeNode root) {
        // 这里要返回 -1 ，因为如果此节点是叶子节点，后面的递归是不加1的；
        if(root == null) return -1;
        return 1 + Math.max(getHeight(root.left) , getHeight(root.right));

    }
}