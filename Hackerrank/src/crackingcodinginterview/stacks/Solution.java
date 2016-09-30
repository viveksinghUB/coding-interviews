package crackingcodinginterview.stacks;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;
import java.util.Stack;

/**
 * Created by Sravan on 9/29/16.
 */
public class Solution {

    public static boolean isBalanced(String expression) {
        if(expression.length() %2 != 0) {
            return false;
        }
        else {
            int angleBracketCounter = 0;
            int squareBracketCounter = 0;
            int bracketCounter = 0;

            for(int i=0; i<expression.length(); i++) {
                Character character = expression.charAt(i);
                if('{' == character) {
                    angleBracketCounter++;
                }
                else if('}' == character) {
                    angleBracketCounter--;
                }
                else if('[' == character) {
                    squareBracketCounter++;
                }
                else if(']' == character) {
                    squareBracketCounter--;
                }
                else if('(' == character) {
                    bracketCounter++;
                }
                else if(')' == character) {
                    bracketCounter--;
                }
            }

            if( angleBracketCounter == 0 && squareBracketCounter == 0 && bracketCounter == 0) {
                return true;
            }
            else {
                return false;
            }
        }
    }

    /*public static boolean isBalanced(String expression) {
        if(expression.length() %2 != 0) {
            return false;
        }
        else {
            Stack<Character> stack = new Stack<>();
            for(int i=0; i<expression.length()/2; i++) {
                stack.push(expression.charAt(i));
            }
            for(int j=expression.length()/2; j<expression.length(); j++) {
                Character character = stack.pop();
                if('{' == character && '}' == expression.charAt(j)) {
                    continue;
                }
                else if('[' == character && ']' == expression.charAt(j)) {
                    continue;
                }
                else if('(' == character && ')' == expression.charAt(j)) {
                    continue;
                }
                else {
                    return false;
                }
            }
            return true;
        }
    }*/

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
