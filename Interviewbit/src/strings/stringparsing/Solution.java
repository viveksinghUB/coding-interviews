package strings.stringparsing;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sravan on 3/13/16.
 */
public class Solution {

    public int compareVersion(String a, String b) {
        List<String> aList = new ArrayList<>(Arrays.asList(a.split("\\.")));
        List<String> bList = new ArrayList<>(Arrays.asList(b.split("\\.")));

        int lenDiff = Math.abs(aList.size() - bList.size());

        if(aList.size() < bList.size()) {
            for(int i=0; i<lenDiff; i++) {
                aList.add("0");
            }
        }
        else {
            for(int i=0; i<lenDiff; i++) {
                bList.add("0");
            }
        }

        for(int i=0; i<aList.size(); i++) {
            BigInteger bigIntegerA = new BigInteger(aList.get(i));
            BigInteger bigIntegerB = new BigInteger(bList.get(i));
            int comparison = bigIntegerA.compareTo(bigIntegerB);
            if( comparison !=0 ){
                return comparison;
            }

        }
        return 0;
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("13.0", "13.0.8"));
    }
}
