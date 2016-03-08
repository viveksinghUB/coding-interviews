package binarysearch.searchanswer;

/**
 * Created by Sravan on 2/20/16.
 */
public class Solution {

    public int sqrt(int a) {
        double sqrt = Math.pow(10, Math.log10(a)/2);
        int iPart = (int)sqrt;
        double dPart = sqrt - iPart;
        boolean all9s = true;
        String decimal = String.valueOf(dPart);
        for(int i=2; i<7; i++) {
            if(decimal.charAt(i) != '9') {
                all9s = false;
                break;
            }
        }
        if(all9s) {
            return iPart + 1;
        }
        else {
            return iPart;
        }
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        System.out.println(solution.sqrt(308634616));
        System.out.println((int)Math.sqrt(169078009));
    }
}
