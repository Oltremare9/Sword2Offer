package 面试题31.栈的压入弹出序列;

import java.util.Stack;

class Solution {
    public boolean validateStackSequences(int[] pushed, int[] popped) {
        Stack<Integer> stack = new Stack();
        int pointer1 = 0;
        int pointer2 = 0;
        while (pointer1 < pushed.length && pointer2 < popped.length) {
            while (pointer1 < pushed.length && (stack.size() == 0 || stack.peek() != popped[pointer2])) {
                stack.push(pushed[pointer1++]);
            }
            if (stack.peek() != popped[pointer2])
                return false;
            else {
                while (stack.size() != 0 && pointer2 < popped.length && stack.peek() == popped[pointer2]) {
                    stack.pop();
                    pointer2++;
                }
            }
        }
        if (pointer1 == pushed.length && pointer2 == popped.length && stack.size() == 0)
            return true;
        else
            return false;
    }
}