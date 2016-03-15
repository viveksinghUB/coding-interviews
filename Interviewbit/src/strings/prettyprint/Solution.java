package strings.prettyprint;

/**
 * Created by Sravan on 3/14/16.
 */
public class Solution {

    public String convert(String a, int b) {
        if(b == 1) {
            return a;
        }
        StringBuilder result = new StringBuilder();
        int n = b + b - 2;
        for(int i = 0; i < b; i++){
            int cur = i;
            while(cur < a.length()){
                result.append(a.charAt(cur));
                cur += n;
                if(i > 0 && i < b - 1 && (cur-i-i) < a.length()){
                    result.append(a.charAt(cur - i - i));
                }
            }
        }
        return result.toString();
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
    }
}
