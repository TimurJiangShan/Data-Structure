package com.company;

public class LinkedList<E> {

    private class Node {

        public E e;
        public Node next;

        public Node(E e, Node next){
            this.e = e;
            this.next = next;
        }

        public Node(E e) {
            this(e, null);
        }

        public Node(){
            this(null, null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node head;
    private int size;

    public LinkedList(){
        // 初始的时候一个节点也没有
        head = null;
        size = 0;
    }


    // 获取链表中元素的个数
    public int getSize(){
        return size;
    }

    // 返回链表是否为空
    public boolean isEmpty(){
        return size == 0;
    }

    // 在链表头添加新的元素e
    public void addFirst(E e){
        Node node = new Node(e);
        node.next = head;
        head = node;

        // head = new Node(e, head);  They do the same thing.
        size++;
    }

    // 在链表的index位置添加新节点

    public void add(int index, E e){

        // 可以取到size，就是在末尾添加元素
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index");
        }

        if (index == 0) {
            addFirst(e);
        } else {
            Node prev = head;

            // 找到index的前一个元素 也就是index-1, 由于是用过prev = prev.next 来进行移动，所以终点是 index - 1,
            // 也就是 prev.next = index - 1; 那么当前的i = index - 2;
            for (int i = 0; i < index - 1; i++){
                prev = prev.next;
            }

            prev.next = new Node(e, prev.next);
            size++;
        }
    }


    public void addLast(E e){
        add(size, e);
    }


}
