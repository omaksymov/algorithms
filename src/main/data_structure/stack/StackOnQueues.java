package data_structure.stack;

import java.util.Deque;
import java.util.LinkedList;

/**
 * <a href="https://leetcode.com/problems/implement-stack-using-queues/">LeetCode problem 225</a>:
 * <p>
 * Implement the following operations of a stack using queues.
 * <p>
 * push(x) -- Push element x onto stack.
 * pop() -- Removes the element on top of the stack.
 * top() -- Get the top element.
 * empty() -- Return whether the stack is empty.
 * <p>
 * Example:
 * <p>
 * MyStack stack = new MyStack();
 * <p>
 * stack.push(1);
 * stack.push(2);
 * stack.top();   // returns 2
 * stack.pop();   // returns 2
 * stack.empty(); // returns false
 * Notes:
 * <p>
 * You must use only standard operations of a queue -- which means only <b>push to back, peek/pop from front, size,
 * and is empty<b/> operations are valid.
 * Depending on your language, queue may not be supported natively. You may simulate a queue by using a list or deque
 * (double-ended queue), as long as you use only standard operations of a queue.
 * You may assume that all operations are valid (for example, no pop or top operations will be called on an empty stack).
 */
public class StackOnQueues {
    /*
        Idea is to use 2 queues: when element is added onto stack - we put it into the empty queue first, then pull all
        elements from second queue and add them one-by-one into the first one. Such a way top()/pop() stack operations
        will be equivalent to peek()/poll() from the first ('active') queue.
     */

    private Deque<Integer> activeQueue;
    private Deque<Integer> passiveQueue;

    /**
     * Initialize your data structure here.
     */
    public StackOnQueues() {
        activeQueue = new LinkedList<>();
        passiveQueue = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        passiveQueue.add(x);
        int size = activeQueue.size();
        for (int i = 1; i <= size; i++) {
            passiveQueue.add(activeQueue.poll());
        }
        Deque<Integer> tmp = activeQueue;
        activeQueue = passiveQueue;
        passiveQueue = tmp;
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (activeQueue.isEmpty()) throw new IllegalStateException("Stack is empty!");
        return activeQueue.poll();
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (activeQueue.isEmpty()) throw new IllegalStateException("Stack is empty!");
        return activeQueue.peek();
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return activeQueue.isEmpty();
    }
}
