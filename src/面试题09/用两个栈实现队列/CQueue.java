package 面试题09.用两个栈实现队列;

import java.util.Stack;

class CQueue {
    Stack<Integer> stack1;
    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();
    }

    public void appendTail(int value) {
        if (!stack1.empty())
            stack2.push(value);
        else if (stack2.empty())
            stack1.push(value);
        else {
            stack2.push(value);
        }

    }

    public int deleteHead() {
        if (!stack1.empty()) {
            return stack1.pop();
        } else if (!stack2.empty()) {
            while (stack2.size() > 0) {
                stack1.push(stack2.pop());
            }
            return stack1.pop();
        }
        return -1;
    }
}

/**
 * Your CQueue object will be instantiated and called as such:
 * CQueue obj = new CQueue();
 * obj.appendTail(value);
 * int param_2 = obj.deleteHead();
 */