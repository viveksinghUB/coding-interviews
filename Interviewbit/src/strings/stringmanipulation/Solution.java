package strings.stringmanipulation;

import java.util.ArrayList;
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

    public String longestCommonPrefix(ArrayList<String> a) {
        String lcp = "";
        int startIndex = 0;
        int stopIndex = 1;
        String firstElement = a.get(0);

        while(stopIndex <= firstElement.length()) {
            String tempLcp = firstElement.substring(startIndex, stopIndex);
            boolean isLcpPresent = true;
            for(int i=1; i<a.size(); i++) {
                if(!a.get(i).contains(tempLcp)) {
                    isLcpPresent = false;
                    break;
                }
            }
            if(isLcpPresent) {
                if(tempLcp.length() > lcp.length()) {
                    lcp = tempLcp;
                }
            }
            stopIndex++;
        }

        return lcp;
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        ArrayList<String> a = new ArrayList<String>();
        a.add("abcdefgh");
        a.add("aefghijk");
        a.add("abcefgh");

        ArrayList<String> b = new ArrayList<String>();
        b.add("abcdefgh");
        b.add("abcefgh");

        System.out.println(solution.isPalindrome("A man, a plan, a canal: Panama"));
        System.out.println(solution.isPalindrome("race a car"));
        System.out.println(solution.longestCommonPrefix(a));
        System.out.println(solution.longestCommonPrefix(b));
    }


}
