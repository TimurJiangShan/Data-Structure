public class LeetCode938 {
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

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;

        int result = 0;
        result += filter(root, root.val, low, high);
        result += rangeSumBST(root.left, low, high);
        result += rangeSumBST(root.right, low, high);

        return result;
    }

    private int filter(TreeNode root, int val, int low, int high) {

        if(root != null && val >=low && val <= high) return val;
        else return 0;
    }

}
