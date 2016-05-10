package stacksandqueues.multiplestack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Sravan on 5/9/16.
 */
public class Solution {

    public static void main(String... args) {
        MinStack minStack = new MinStack();
        minStack.push(512);
        minStack.push(-1024);
        minStack.push(-1024);
        minStack.push(512);
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
        minStack.pop();
        System.out.println(minStack.getMin());
    }

}

class MinStack {
    ArrayList<Integer> integers = new ArrayList<>();
    Stack<Integer> minStack = new Stack<>();
    int top = -1;

    public void push(int x) {
        if(top == -1) {
            minStack.push(x);
        }
        else if(x <= minStack.peek()){
            minStack.push(x);
        }
        top++;
        integers.add(top, x);

    }

    public void pop() {
        if(top < 0) {
            return;
        }
        int topElement = integers.get(top);
        int minStackTopElement = minStack.peek();
        if(!minStack.isEmpty() && topElement == minStackTopElement) {
            minStack.pop();
        }
        top--;

    }

    public int top() {
        if(top < 0) {
            return -1;
        }
        return integers.get(top);
    }

    public int getMin() {
        int min = -1;
        if(!minStack.isEmpty())
        {
            min = minStack.peek();
        }
        return min;
    }
}
