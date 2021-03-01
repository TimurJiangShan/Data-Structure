public class LeetCode270 {
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

    public int closestValue(TreeNode root, double target) {
        TreeNode n = root;
        int res = root.val;
        while(n != null) {
            if(Math.abs(n.val - target) < Math.abs(res - target)) {
                res = n.val;
            }
            n = n.val > target ? n.left : n.right;
        }
        return res;

    }
}
