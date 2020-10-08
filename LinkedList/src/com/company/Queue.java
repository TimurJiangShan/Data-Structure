package com.company;

public interface Queue<E> {
    int getSize();
    boolean isEmpty();
    void enqueue(E e);
    E dequeue();
    E getFront();
}


// 对于循环队列 front == tail 队列为空， （tail + 1）% c == front 队列满