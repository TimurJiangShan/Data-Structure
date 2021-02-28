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

  /*
  *
  * 递归，如果当前节点在范围内，加到结果里。如果当前节点大于low，遍历左子树，小于high，遍历右子树
  *
  *
  * */

    public int rangeSumBST(TreeNode root, int low, int high) {
        if(root == null) return 0;

        int result = 0;
        result += filter(root, root.val, low, high);

        if(root.val > low)  result += rangeSumBST(root.left, low, high);
        if(root.val < high) result += rangeSumBST(root.right, low, high);

        return result;
    }

    private int filter(TreeNode root, int val, int low, int high) {

        if(root != null && val >=low && val <= high) return val;
        else return 0;
    }

}
