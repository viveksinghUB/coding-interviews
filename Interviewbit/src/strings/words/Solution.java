package strings.words;

/**
 * Created by Sravan on 3/8/16.
 */
public class Solution {

    public int lengthOfLastWord(final String a) {
        if(a.trim().length() == 0 || a == null){
            return 0;
        }
        else {
            String[] b = a.trim().split(" ");
            String lastWord = b[b.length-1];
            return lastWord.length();
        }
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));
    }
}
