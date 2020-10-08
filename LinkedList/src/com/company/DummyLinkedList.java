package com.company;

public class DummyLinkedList<E> {

    private class Node {
        public E e;
        public Node next;

        public Node(E e, Node next) {
            this.e = e;
            this.next = next;
        }

        public Node(E e){
            this(e,null);
        }

        public Node(){
            this(null,null);
        }

        @Override
        public String toString(){
            return e.toString();
        }
    }

    private Node dummyHead;
    private int size;
    public DummyLinkedList(){
        dummyHead = new Node();
        size = 0;
    }

    public int getSize(){
        return size;
    }

    public boolean isEmpty(){
        return size == 0;
    }

    public void add(int index, E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Add failed. Illegal index.");
        }

        Node prev = dummyHead;

        for (int i = 0; i < index; i++){
            prev = prev.next;
        }

        prev.next = new Node(e, prev.next);
        size++;
    }

    public E remove(int index){
        if (index < 0 || index >= size) {
            throw new IllegalArgumentException("Remove failed. Illegal index");
        }

        Node prev = dummyHead;
        for (int i = 0; i < index; i++) {
            prev = prev.next;
        }
        Node delNode = prev.next;
        prev.next = delNode.next;
        delNode.next = null;
        size--;
        return delNode.e;
    }

    public E removeFirst(){
        return remove(0);
    }
    public void addFirst(E e){
        add(0, e);
    }

    public void addLast(E e){
        add(size, e);
    }


    public E get(int index){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Get failed. Illegal index.");
        }
        Node current = dummyHead.next;

        for (int i = 0; i < index; i++) {
            current = current.next;
        }

        return current.e;
    }

    public E getFirst(){
        return get(0);
    }

    public E getLast(){
        return get(size - 1);
    }

    public void set(int index, E e){
        if (index < 0 || index > size) {
            throw new IllegalArgumentException("Set failed. Illegal index");
        }

        Node current = dummyHead.next;
        for (int i = 0; i < index; i++) {
            current = current.next;
        }
        current.e = e;
    }

    public boolean contains(E e){

        // while和for循环两种方式
        Node current = dummyHead.next;
        while (current != null){
            if (current.e.equals(e))
                return true;
            else
                current = current.next;
        }
//        for (int i = 0; i < size; i++) {
//            if (current.e.equals(e)) {
//                return true;
//            } else {
//                current = current.next;
//            }
//        }
//        return false;
        return false;
    }

    @Override
    public String toString(){
        StringBuilder res = new StringBuilder();
        Node current = dummyHead.next;
        while (current != null) {
            res.append(current + "->");
            current = current.next;
        }
        res.append("NULL");
        return res.toString();
    }
}
