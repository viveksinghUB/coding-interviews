package crackingcodinginterview.stacks;

import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Sravan on 9/29/16.
 */
public class Solution {

    public static boolean isBalanced(String expression) {
        if(expression.length() %2 != 0 || expression.charAt(0) == '}'
                || expression.charAt(0) == ']' || expression.charAt(0) == ')') {
            return false;
        }
        else {
            List<Character> openBraces = Arrays.asList('{', '[', '(');
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<expression.length(); i++) {
                Character character = expression.charAt(i);
                if(openBraces.contains(character)) {
                    stack.push(character);
                }
                else if(!stack.isEmpty()) {
                    Character poppedChar = stack.pop();
                    if(poppedChar.charValue() == '{' && character.charValue() == '}') {
                        continue;
                    }
                    else if(poppedChar.charValue() == '[' && character.charValue() == ']') {
                        continue;
                    }
                    else if(poppedChar.charValue() == '(' && character.charValue() == ')') {
                        continue;
                    }
                    else {
                        return false;
                    }
                }
            }
            return stack.isEmpty();
        }
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t = in.nextInt();
        for(int a0 = 0; a0 < t; a0++) {
            String expression = in.next();
            boolean answer = isBalanced(expression);
            if(answer) {
                System.out.println("YES");
            }
            else {
                System.out.println("NO");
            }
        }
    }
}
