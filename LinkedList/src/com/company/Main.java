package com.company;

public class Main {

    public static void main(String[] args) {
	// write your code here
        DummyLinkedList<Integer> linkedList = new DummyLinkedList<>();
        for (int i = 0; i < 5; i++) {
            linkedList.addFirst(i);
            System.out.println(linkedList);
        }

        linkedList.add(2,888);
        linkedList.add(2,888);
        linkedList.add(2,888);
        linkedList.add(2,888);
        System.out.println(linkedList);
        linkedList.removeAllSelectedElement(888);
        System.out.println(linkedList);

    }
}
