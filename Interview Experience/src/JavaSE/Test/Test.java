package JavaSE.Test;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Stack;

public class Test {

}

class MyQueue {
    private Stack<Integer> s1;
    private Stack<Integer> s2;

    public MyQueue() {
        s1 = new Stack<>();
        s2 = new Stack<>();
    }

    public void push(int x) {
        s1.push(x);

    }

    public int pop() {
        if (empty()) return 0;

        if (s2.isEmpty()) {
            while (!s1.isEmpty()) {
                int i = s1.pop();
                s2.push(i);
            }
        }

            return s2.pop();

    }

        public int peek () {
            if (empty()) return 0;

            if (s2.isEmpty()) {
                while (!s1.isEmpty()) {
                    int i = s1.pop();
                    s2.push(i);
                }
            }
            return s2.peek();
        }


        public boolean empty () {
            return s1.isEmpty() && s2.isEmpty();

        }

}

class MyStack {
    Queue<Integer> queue;

    public MyStack() {
        queue = new LinkedList<>();

    }

    public void push(int x) {
        queue.add(x);

    }

    public int pop() {


        for (int i = 0 ; i < queue.size() - 1;i++){
            queue.add(queue.poll());
        }
        return  queue.poll();

    }

    public int top() {
        for (int i = 0 ; i < queue.size() - 1;i++){
            queue.add(queue.poll());
        }
       return queue.peek();

    }

    public boolean empty() {
       return queue.isEmpty();
    }
}

