import java.util.LinkedList;

public class LeetCode232 {
    class MyQueue {

        private Stack<Integer> stackLeft;
        private Stack<Integer> stackRight;

        /** Initialize your data structure here. */
        public MyQueue() {
            stackLeft = new Stack<Integer>();
            stackRight = new Stack<Integer>();
        }

        /** Push element x to the back of queue. */
        public void push(int x) {
            stackRight.push(x);
        }

        /** Removes the element from in front of queue and returns that element. */
        public int pop() {
            peek();
            return stackLeft.pop();
        }

        /** Get the front element. */
        public int peek() {
            // 如果stackLeft里面有元素，直接peekstackLeft里面的元素，否则从stackRight里面取
            if(stackLeft.isEmpty()) {
                while(!stackRight.isEmpty()) {
                    stackLeft.push(stackRight.pop());
                }
            }

            return stackLeft.peek();
        }

        /** Returns whether the queue is empty. */
        public boolean empty() {
            return stackLeft.isEmpty() && stackRight.isEmpty();
        }
    }

/**
 * Your MyQueue object will be instantiated and called as such:
 * MyQueue obj = new MyQueue();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.peek();
 * boolean param_4 = obj.empty();
 */
}
