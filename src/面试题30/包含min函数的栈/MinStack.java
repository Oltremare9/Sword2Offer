package 面试题30.包含min函数的栈;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class MinStack {

    Stack<Integer> sort;
    Stack<Integer> stack;

    /**
     * initialize your data structure here.
     */
    public MinStack() {
        sort = new Stack<>();
        stack = new Stack<>();
    }

    public void push(int x) {
        stack.push(x);
        if (sort.size() == 0 || x <= sort.peek())
            sort.push(x);
    }

    public void pop() {
        if (stack.peek().equals(sort.peek())) {
            stack.pop();
            sort.pop();
        } else
            stack.pop();
    }

    public int top() {
        return stack.peek();
    }

    public int min() {
        return sort.peek();
    }

    public static void main(String args[]) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
        minStack.pop();
        System.out.println(minStack.min());
    }
}

/**
 * Your MinStack object will be instantiated and called as such:
 * MinStack obj = new MinStack();
 * obj.push(x);
 * obj.pop();
 * int param_3 = obj.top();
 * int param_4 = obj.min();
 */