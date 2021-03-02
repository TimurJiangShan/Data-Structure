public class LeetCode993 {
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

    private int depthX;
    private int depthY;
    private TreeNode parentX;
    private TreeNode parentY;

    public boolean isCousins(TreeNode root, int x, int y) {
        this.parentX = new TreeNode();
        this.parentY = new TreeNode();
        preOrder(root, x, y, null, 0);
        return this.parentX != this.parentY && this.depthX == this.depthY;
    }

    private void preOrder(TreeNode root, int x, int y, TreeNode parent, int depth){
        if(root == null) return;
        if(root.val == x) {
            this.depthX = depth;
            this.parentX = parent;
        }

        if(root.val == y) {
            this.depthY = depth;
            this.parentY = parent;
        }

        preOrder(root.left, x, y, root, depth+1);
        preOrder(root.right, x, y, root, depth+1);
    }
}
