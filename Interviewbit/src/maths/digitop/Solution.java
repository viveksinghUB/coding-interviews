package maths.digitop;

import java.util.Stack;

/**
 * Created by Sravan on 2/17/16.
 */
public class Solution {

    public boolean isPalindrome(int a) {
        boolean isPalindrome = true;

        String strInt = String.valueOf(a);

        Stack<Character> stack = new Stack<Character>();

        for(int i=0; i<strInt.length(); i++)
        {
            stack.push(strInt.charAt(i));
        }

        for(int i=0; i<strInt.length(); i++)
        {
            Character c = stack.pop();
            if(!c.equals(strInt.charAt(i)))
            {
                isPalindrome = false;
                break;
            }
        }
        return isPalindrome;
    }

}
