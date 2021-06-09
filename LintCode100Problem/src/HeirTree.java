public class HeirTree {
  private int val;
  private List<MyTreeNode> child;
  private MyTreeNode parent;
  private boolean is_deleted;

  /**
     * @param val: the val of the node
     * @return: a MyTreeNode Object
     */
    MyTreeNode(int val) {
        this.val = val;
        child = new ArrayList<MyTreeNode>();
        parent = null;
        is_deleted = false;
    }

  /**
   * @param root: the root treenode
   * @return: get the traverse of the treenode
   */
  public ArrayList<Integer> traverse(MyTreeNode root) {
    // write your code here
    ArrayList<Integer> path = new ArrayList<Integer>();
    traverse_helper(root, path);
    return path;
  }

  private void traverse_helper(MyTreeNode root, List<Integer> path) {
    if (!root.is_deleted) {
      path.add(root.val);
    }
    for (MyTreeNode child : root.child) {
      traverse_helper(child, path);
    }
  }

  /**
   * @param root:  the node where added
   * @param value: the added node's value
   * @return: add a node, return the node
   */
  public MyTreeNode addNode(MyTreeNode root, int value) {
    // write your code here
    MyTreeNode newNode = new MyTreeNode(value);
    newNode.parent = root;
    root.child.add(newNode);
    return newNode;
  }

  /**
   * @param root: the deleted node
   * @return: nothing
   */
  public void deleteNode(MyTreeNode root) {
    // write your code here
    root.is_deleted = true;
  }
}
