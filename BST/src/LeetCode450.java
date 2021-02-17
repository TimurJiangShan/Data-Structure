public class LeetCode450 {
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

    public TreeNode deleteNode(TreeNode root, int key) {
        // 如果是空节点，返回null
        if(root == null) return null;

        // 找到了要删除的节点
        if(root.val == key) {
            // 情况1：待删除的节点没有孩子节点
            if(root.left == null && root.right == null) return null;

            // 情况2：待删除的节点只有一个孩子节点
            if(root.left != null && root.right == null) return root.left;
            if(root.left == null && root.right != null) return root.right;

            // 情况3：待删除的节点有两个孩子节点

            // 找到root的右子树中最小的节点
            TreeNode minNode = getMin(root.right);

            // 删除当前节点（先用交换两个节点的值代替）
            root.val = minNode.val;
            root.right = deleteNode(root.right, minNode.val);

            return root;
        } else if(root.val < key) {
            root.right = deleteNode(root.right, key);
        } else if(root.val > key) {
            root.left = deleteNode(root.left, key);
        }

        return root;
    }

    private TreeNode getMin(TreeNode root){
        while(root != null && root.left != null)    root = root.left;
        return root;
    }
}
