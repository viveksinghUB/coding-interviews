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

    public String countAndSay(int n) {
        if (n <= 0)
            return null;

        String result = "1";
        int i = 1;

        while (i < n) {
            StringBuilder sb = new StringBuilder();
            int count = 1;
            for (int j = 1; j < result.length(); j++) {
                if (result.charAt(j) == result.charAt(j - 1)) {
                    count++;
                } else {
                    sb.append(count);
                    sb.append(result.charAt(j - 1));
                    count = 1;
                }
            }

            sb.append(count);
            sb.append(result.charAt(result.length() - 1));
            result = sb.toString();
            i++;
        }

        return result;
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

        System.out.println(solution.countAndSay(4));
    }


}
