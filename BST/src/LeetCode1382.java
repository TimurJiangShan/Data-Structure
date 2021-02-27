import java.util.ArrayList;

public class LeetCode1382 {
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

    // 1. 先中序遍历得到一个有序数组
    // 2. 再把这个数组变成一个完全二叉树

    private ArrayList<Integer> numbers;

    public TreeNode balanceBST(TreeNode root) {
        this.numbers = new ArrayList<>();
        getInOrderArray(root);
        return helper(0, numbers.size()-1);
    }

    private TreeNode helper(int left, int right){
        if(left > right) return null;
        int p = (left + right) / 2;
        TreeNode root = new TreeNode(numbers.get(p));
        root.left = helper(left, p-1);
        root.right = helper(p+1, right);
        return root;
    }

    private void getInOrderArray(TreeNode root){
        if(root == null) return;
        getInOrderArray(root.left);
        this.numbers.add(root.val);
        getInOrderArray(root.right);
    }
}
