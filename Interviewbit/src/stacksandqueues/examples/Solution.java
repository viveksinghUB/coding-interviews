package stacksandqueues.examples;

import java.util.Stack;

/**
 * Created by Sravan on 5/4/16.
 */
public class Solution {

    public String reverseString(String a) {
        int length = a.length();
        StringBuffer strBuffer = new StringBuffer();
        for(int i=length-1; i>=0; i--) {
            strBuffer.append(a.charAt(i));
        }

        return strBuffer.toString();
    }

    public int isValid(String a) {
        int isValid = 1;
        Stack<Character> stack = new Stack<Character>();
        for(int i=0; i<a.length(); i++) {
            stack.push(a.charAt(i));
        }
        for(int i=0; i<a.length(); i++) {
            Character topElement = stack.pop();
            Character strElement = a.charAt(i);
            //if(topElement == '[')
        }

        return isValid;

    }

    public static void main(String... args) {
        Solution sol = new Solution();
        System.out.println(sol.reverseString("abcdef"));
    }
}
