public class LeetCode572 {
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

    public boolean isSubtree(TreeNode s, TreeNode t) {
        // TreeNode searchResult = searchNode(s,t);
        // if(searchResult == null) {
        //     return false;
        // }
        if(s == null && t == null) return true;
        if(s == null || t == null) return false;
        if(isSameTree(s, t) == true) return true;
        else
            return isSubtree(s.left, t) || isSubtree(s.right,t);
    }

    private boolean isSameTree(TreeNode treeOne, TreeNode treeTwo) {
        if(treeOne == null && treeTwo == null) return true;
        if(treeOne == null || treeTwo == null) return false;
        if(treeOne.val == treeTwo.val) {
            return isSameTree(treeOne.left, treeTwo.left) && isSameTree(treeOne.right, treeTwo.right);
        } else {
            return false;
        }
    }
}
