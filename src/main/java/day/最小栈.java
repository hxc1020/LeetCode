package day;

import java.util.Stack;

public class 最小栈 {
    private final Stack<Integer> stack;
    private int min;

    public 最小栈() {
        this.stack = new Stack<>();
        this.min = Integer.MAX_VALUE;
    }

    public void push(int val) {
        if (val <= min) {
            this.stack.push(min);
            this.stack.push(val);
            min = val;
        } else {
            this.stack.push(val);
        }
    }

    public void pop() {
        Integer pop = this.stack.pop();
        if (pop == this.min) {
            this.min = this.stack.pop();
        }
    }

    public int top() {
        return this.stack.peek();
    }

    public int getMin() {
        return min;
    }
}
