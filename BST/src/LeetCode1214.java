import java.util.ArrayList;

public class LeetCode1214 {
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
    // 中序遍历 + SearchElement
    // 1. Target和root1里面的值相减得到补码
    // 2. 拿这个补码里面的值和root2去比较，如果存在就返回true，否则返回false；

    private ArrayList<Integer> complement;
    private int target;
    public boolean twoSumBSTs(TreeNode root1, TreeNode root2, int target) {
        this.complement = new ArrayList<>();
        inOrder(root1, target);
        for(int i = 0; i < this.complement.size(); i++) {
            TreeNode p = searchBST(root2, this.complement.get(i));
            if(p != null)    return true;

        }
        return false;
    }

    private TreeNode searchBST(TreeNode root, int target) {
        if(root == null || root.val == target) return root;
        else if(root.val < target) return searchBST(root.right, target);
        return searchBST(root.left, target);
    }

    private void inOrder(TreeNode root, int target){
        if(root == null) return;
        inOrder(root.left, target);
        this.complement.add(target - root.val);
        inOrder(root.right, target);
    }
}
