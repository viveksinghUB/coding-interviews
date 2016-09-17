package algorithms.strings;

/**
 * Created by Sravan on 9/17/16.
 */
public class Solution {

    public String superReducedString(String var)
    {
        String reducedString = "";
        int i = 0;
        while (i<var.length())
        {
            if(i == var.length()-1)
            {
                reducedString = reducedString + var.charAt(i);
                break;
            }
            else if(var.charAt(i) == var.charAt(i+1))
            {
                i = i+2;
            }
            else
            {
                reducedString = reducedString + var.charAt(i);
                i++;
            }
        }

        if("".equals(reducedString))
        {
            reducedString = "Empty String";
        }

        return reducedString;
    }

    public static void main(String[] args) {

        Solution solution = new Solution();

        System.out.println(solution.superReducedString("aabccd"));
        System.out.println(solution.superReducedString("acdqglrfkqyuqfjkxyqvnrtysfrzrmzlygfveulqfpdbhlqdqrrqdqlhbdpfqluevfgylzmrzrfsytrnvqyxkjfquyqkfrlacdqj"));

    }
}
