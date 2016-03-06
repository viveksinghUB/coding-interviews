package strings.stringmanipulation;

import java.util.Stack;

/**
 * Created by Sravan on 3/6/16.
 */
public class Solution {

    public int isPalindrome(String a) {
        int isPalindrome = 0;
        String pattern = "[^a-zA-Z0-9]";
        String extractedStr = a.replaceAll(pattern, "").toLowerCase();
        if("".equals(extractedStr)) {
            return 1;
        }
        else {

            Stack<Character> stack = new Stack<Character>();
            for(int i=0; i<extractedStr.length(); i++) {
                stack.push(extractedStr.charAt(i));
            }
            for(int i=0; i<extractedStr.length(); i++) {
                if(extractedStr.charAt(i) != stack.pop()) {
                    isPalindrome = 0;
                    return isPalindrome;
                }
                isPalindrome = 1;
            }

        }
        return isPalindrome;
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
    }


}
