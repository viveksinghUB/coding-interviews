package stacksandqueues.stackmath;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

/**
 * Created by Sravan on 5/8/16.
 */
public class Solution {

    public int evalRPN(ArrayList<String> tokens) {
        Stack<Integer> integerStack = new Stack<>();
        int a, b;
        for(String elem:tokens) {
            if("+".equals(elem)) {
                a = integerStack.pop();
                b = integerStack.pop();
                integerStack.push(b+a);
            }
            else if("-".equals(elem)) {
                a = integerStack.pop();
                b = integerStack.pop();
                integerStack.push(b-a);
            }
            else if("*".equals(elem)) {
                a = integerStack.pop();
                b = integerStack.pop();
                integerStack.push(a*b);
            }
            else if("/".equals(elem)) {
                a = integerStack.pop();
                b = integerStack.pop();
                integerStack.push(b/a);
            }
            else {
                integerStack.push(Integer.valueOf(elem));
            }
        }

        return integerStack.pop();
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        String[] a = {"18", "5", "/"};

        System.out.println(solution.evalRPN(new ArrayList<String>(Arrays.asList(a))));
    }
}
