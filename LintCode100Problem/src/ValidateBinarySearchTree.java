public class ValidateBinarySearchTree {
    public class TreeNode {
        public int val;
        public TreeNode left, right;
        public TreeNode(int val) {
            this.val = val;
            this.left = this.right = null;
        }
    }

    private class ResultType {
        public boolean isBST;
        public TreeNode maxNode, minNode;
        public ResultType(boolean isBST){
            this.isBST = isBST;
            this.maxNode = null;
            this.minNode = null;
        }
    }

    public boolean isValidBST(TreeNode root) {
        // write your code here
        return divideConquer(root).isBST;
    }

    private ResultType divideConquer(TreeNode root){
        if (root == null) return new ResultType(true);

        ResultType left = divideConquer(root.left);
        ResultType right = divideConquer(root.right);

        // 处理不合法的情况
        if(!left.isBST || !right.isBST) return new ResultType(false);
        if(left.maxNode != null && left.maxNode.val >= root.val) return new ResultType(false);
        if(right.minNode != null && right.minNode.val <= root.val)  return new ResultType(false);

        // 记录最小节点和最大节点，以便于递归后节点的比较
        ResultType result = new ResultType(true);
        result.minNode = left.minNode != null ? left.minNode : root;
        result.maxNode = right.maxNode != null ? right.maxNode : root;

        return result;
    }

}
