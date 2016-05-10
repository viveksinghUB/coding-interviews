package stacksandqueues.stacksimple;

import java.util.Stack;

/**
 * Created by Sravan on 5/5/16.
 */
public class Solution {

    public int braces(String a) {
        Stack<Character> stack = new Stack<Character>();
        for (int i = 0; i < a.length(); i++) {
            char c = a.charAt(i);
            if(c != ')' && c != ' ') {
                stack.push(c);
            }
            else if(c == ')' && c != ' ') {
                char elem = stack.pop();
                int elemCount = 0;
                while (elem != '(' && !stack.isEmpty()) {
                    elemCount++;
                    elem = stack.pop();
                }
                if(elemCount <= 1) {
                    return 1;
                }
            }
        }

        return 0;
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        System.out.println(solution.braces("(a+"));
        //System.out.println(solution.braces("(a+((b*c)+c))"));
    }

}
