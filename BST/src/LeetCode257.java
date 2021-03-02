import java.util.LinkedList;
import java.util.List;

public class LeetCode257 {
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

    public List<String> binaryTreePaths(TreeNode root) {
        LinkedList<String> paths = new LinkedList();
        constructPaths(root, "", paths);

        return paths;
    }

    public void constructPaths(TreeNode root, String path, LinkedList<String> paths) {
        if(root != null) {
            path += Integer.toString(root.val);
            // if reach a leaf node
            if(root.left == null && root.right == null) {
                paths.add(path);
            } else {
                path += "->";
                constructPaths(root.left, path, paths);
                constructPaths(root.right, path, paths);
            }
        }
    }
}