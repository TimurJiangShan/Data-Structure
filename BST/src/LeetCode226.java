public class LeetCode226 {
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

    public TreeNode invertTree(TreeNode root) {
        return helper(root);
    }

    public TreeNode helper(TreeNode root) {
        if(root == null) return root;


        TreeNode temNode = root.right;
        root.right = root.left;
        root.left = temNode;

        root.left = helper(root.left);
        root.right = helper(root.right);
        return root;
    }

}
