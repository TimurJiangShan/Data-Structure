public class LeetCode108 {
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

    private int[] numbers;

    public TreeNode sortedArrayToBST(int[] nums) {
        this.numbers = nums;
        return helper(0, numbers.length - 1);
    }

    private TreeNode helper(int left, int right) {
        if(left > right) return null;
        int p = (left + right) / 2;
        TreeNode root = new TreeNode(numbers[p]);
        root.left = helper(left, p-1);
        root.right = helper(p+1, right);
        return root;
    }
}
