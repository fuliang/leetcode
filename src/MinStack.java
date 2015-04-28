import java.util.Stack;

/**
 * Created by fuliang on 2015/4/12.
 */
public class MinStack {
    private Stack<Integer> stack = new Stack<Integer>();
    private Stack<Integer> minStack = new Stack<Integer>();

    public void push(int x) {
        stack.push(x);
        if (stack.isEmpty() || stack.peek() > x) {
            stack.push(x);
        }
    }

    public void pop() {
        if (stack.empty())
            return;

        int x = stack.pop();

    }

    public int top() {
        return stack.peek();
    }

    public int getMin() {
        return 0;
    }
}
