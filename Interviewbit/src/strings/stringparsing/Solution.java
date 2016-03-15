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

    public int isNumber(final String a) {
        String trimmedInput = a.trim();
        if(trimmedInput.length() < 1) {
            return 0;
        }
        int isNumber = 1;
        int expCounter = 0;
        boolean expExists = false;
        Character[] validDigits = {'0', '1', '2', '3', '4', '5', '6', '7', '8', '9'};
        Character[] validChars = {'.', '-', 'e'};
        List<Character> validCharList = new ArrayList<Character>(Arrays.asList(validChars));
        List<Character> validDigitList = new ArrayList<Character>(Arrays.asList(validDigits));
        for(int i=0; i<trimmedInput.length(); i++) {
            char temp = trimmedInput.charAt(i);
            if(!validCharList.contains(temp) && !validDigitList.contains(temp)) {
                return 0;
            }
            else if(temp == 'e') {
                expCounter++;
                if(i == a.length()-1 || expCounter > 1) {
                    return 0;
                }
                expExists = true;
            }
            else if(expExists) {
                if(i == 0 || (i+1) > trimmedInput.length() || temp == '.') {
                    return 0;
                }
                else if(temp == '-' && !validDigitList.contains(trimmedInput.charAt(i+2))) {
                    return 0;
                }
            }
            else if(temp == '.' && !expExists) {
                if(i == a.length()-1 ) {
                    return 0;
                }
                else if(!validDigitList.contains(trimmedInput.charAt(i+1))){
                    return 0;
                }
            }
            else if(temp == '-' && !expExists) {
                if(i == a.length()-1 ) {
                    return 0;
                }
                else if(!validDigitList.contains(trimmedInput.charAt(i+1))){
                    return 0;
                }
            }
        }
        return isNumber;
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        System.out.println(solution.compareVersion("13.0", "13.0.8"));
        System.out.println(solution.isNumber("-1e-10"));
        System.out.println(solution.isNumber("e"));
        System.out.println(solution.isNumber("e10"));
    }
}
