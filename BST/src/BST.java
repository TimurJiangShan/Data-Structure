public class BST<E extends Comparable<E>> {
    // 这里的E要extends Comparable类型，因为二叉树节点的值的类型必须可以比较
    private class Node {
        public E e;
        public Node left,right;

        public Node(E e){
            this.e = e;
            left = null;
            right = null;
        }
    }

    private Node root;
    private int size;

    public BST(){
        root = null;
        size = 0;
    }

    public int size(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(E e){
        // 向二分搜索树中添加新的元素e
        add(root, e);
    }

    // 向以node为根的二分搜索树中插入元素e，递归算法
    // 返回插入新节点后二分搜索树的根
    private Node add(Node node, E e){
        if (node == null) {
            size++;
            return new Node(e);
        }

        if (e.compareTo(node.e) < 0)
            node.left = add(node.left, e);
        if (e.compareTo(node.e) > 0)
            node.right = add(node.right, e);

        return node;
    }

    // 看二分搜索树中是否包含元素e
    public boolean contains(E e) {
        return contains(root, e);
    }

    // 看以node为根的二分搜索树中是否包含元素e, 递归算法
    private boolean contains(Node node, E e){
        if (node == null)
            return false;

        if (node.e.compareTo(e) == 0)
            return true;
        else if (node.e.compareTo(e) < 0)
            return contains(node.right, e);
        else
            return contains(node.left, e);
    }

    private void preOrder(Node node){
        if (node == null)
            return;

        System.out.println(node.e);

        preOrder(node.left);
        preOrder(node.right);
    }

    public void preOrder(){
        preOrder(root);
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();

        return res.toString();
    }

    // 生成以node为根节点， 深度为depth的描述二叉树的字符串
    private void generateBSTString(Node node, int depth, StringBuilder res){

        if (node == null) {
            res.append(generateDepthString(depth) + "null\n");
            return;
        }

        res.append(generateDepthString(depth) + node.e + "\n");
        generateBSTString(node.left, depth + 1,res);
        generateBSTString(node.right, depth + 1, res);
    }

    private String generateDepthString(int depth){
        StringBuilder res = new StringBuilder();
        for (int i = 0; i < depth; i++)
            res.append("--");

        return res.toString();
    }


}
