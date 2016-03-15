package strings.stringmath;

import java.math.BigInteger;
import java.util.HashMap;
import java.util.Map;

/**
 * Created by Sravan on 3/10/16.
 */
public class Solution {

    public int romanToInt(String a) {
        int romanToInt = 0;
        Map<Character, Integer> romanToIntMap = new HashMap<Character, Integer>();
        romanToIntMap.put('I', 1);
        romanToIntMap.put('V', 5);
        romanToIntMap.put('X', 10);
        romanToIntMap.put('L', 50);
        romanToIntMap.put('C', 100);
        romanToIntMap.put('D', 500);
        romanToIntMap.put('M', 1000);

        if(a != null && a.length() > 0) {
            romanToInt = romanToIntMap.containsKey(a.charAt(0))?romanToIntMap.get(a.charAt(0)):0;
            for(int i=1; i<a.length(); i++) {
                if(a.charAt(i) == 'M') {
                    if(a.charAt(i-1) == 'C') {
                        romanToInt += (romanToIntMap.get('M') - 200);
                    }
                    else {
                        romanToInt += romanToIntMap.get('M');
                    }
                }
                if(a.charAt(i) == 'D') {
                    if(a.charAt(i-1) == 'C') {
                        romanToInt += (romanToIntMap.get('D') - 200);
                    }
                    else {
                        romanToInt += romanToIntMap.get('D');
                    }
                }
                if(a.charAt(i) == 'C') {
                    if(a.charAt(i-1) == 'X') {
                        romanToInt += (romanToIntMap.get('C') - 20);
                    }
                    else {
                        romanToInt += romanToIntMap.get('C');
                    }
                }
                if(a.charAt(i) == 'L') {
                    if(a.charAt(i-1) == 'X') {
                        romanToInt += (romanToIntMap.get('L') - 20);
                    }
                    else {
                        romanToInt += romanToIntMap.get('L');
                    }
                }
                if(a.charAt(i) == 'X') {
                    if(a.charAt(i-1) == 'I') {
                        romanToInt += (romanToIntMap.get('X') - 2);
                    }
                    else {
                        romanToInt += romanToIntMap.get('X');
                    }
                }
                if(a.charAt(i) == 'V') {
                    if(a.charAt(i-1) == 'I') {
                        romanToInt += (romanToIntMap.get('V') - 2);
                    }
                    else {
                        romanToInt += romanToIntMap.get('V');
                    }
                }
                if(a.charAt(i) == 'I') {
                    romanToInt += 1;
                }
            }
        }

        return romanToInt;
    }

    public String intToRoman(int a) {
        StringBuffer sb = new StringBuffer("");
        while(a > 0) {
            if(a >= 1000) {
                sb.append('M');
                a -= 1000;
            }
            if(a >= 500 && a < 1000) {
                sb.append('D');
                a -= 500;
            }
            if(a >= 100 && a < 500) {
                sb.append('C');
                a -= 100;
            }
            if(a >= 50 && a < 100) {
                sb.append('L');
                a -= 50;
            }
            if(a >= 10 && a < 50) {
                sb.append('X');
                a -= 10;
            }
            if(a >= 5 && a < 10) {
                sb.append('V');
                a -= 5;
            }
            if(a >= 1 && a < 5) {
                sb.append('I');
                a -= 1;
            }
        }

        String romanStr = sb.toString();
        romanStr = romanStr.replace("DCCCC", "CM");
        romanStr = romanStr.replace("LXXXX", "XC");
        romanStr = romanStr.replace("VIIII", "IX");
        romanStr = romanStr.replace("CCCC", "CD");
        romanStr = romanStr.replace("XXXX", "XL");
        romanStr = romanStr.replace("IIII", "IV");

        return romanStr;
    }

    public String addBinary(String a, String b) {

        StringBuilder sb = new StringBuilder();
        StringBuilder leadingZerosSB = new StringBuilder();
        int carry = 0;
        int leadingZeros = Math.abs(a.length()-b.length());
        for(int i=0; i<leadingZeros; i++) {
            leadingZerosSB.append("0");
        }

        if(a.length() < b.length()) {
            a = leadingZerosSB.toString() + a;
        }
        else {
            b = leadingZerosSB.toString() + b;
        }

        for(int i=a.length()-1; i>=0; i--) {
            if(a.charAt(i) == '0' && b.charAt(i) == '0' && carry == 0) {
                sb.append(0);
                carry = 0;
            }
            else if(a.charAt(i) == '0' && b.charAt(i) == '0' && carry == 1) {
                sb.append(1);
                carry = 0;
            }
            else if(a.charAt(i) == '1' && b.charAt(i) == '0' && carry == 0) {
                sb.append(1);
            }
            else if(a.charAt(i) == '1' && b.charAt(i) == '0' && carry == 1) {
                sb.append(0);
                carry = 1;
            }
            else if(a.charAt(i) == '0' && b.charAt(i) == '1' && carry == 0) {
                sb.append(1);
                carry = 0;
            }
            else if(a.charAt(i) == '0' && b.charAt(i) == '1' && carry == 1) {
                sb.append(0);
                carry = 1;
            }
            else if(a.charAt(i) == '1' && b.charAt(i) == '1' && carry == 0) {
                sb.append(0);
                carry = 1;
            }
            else if(a.charAt(i) == '1' && b.charAt(i) == '1' && carry == 1) {
                sb.append(1);
                carry = 1;
            }
        }

        if(carry == 1)
        {
            sb.append(1);
        }
        return sb.reverse().toString();
    }

    public int power(String a) {
        BigInteger b = new BigInteger(a);
        while (b.compareTo(BigInteger.valueOf(2)) != 0) {
            BigInteger modValue = b.mod(BigInteger.valueOf(2));
            if(modValue.compareTo(BigInteger.ZERO) != 0) {
                return 0;
            }
            b = b.divide(BigInteger.valueOf(2));
        }

        return 1;
    }

    public String multiply(String a, String b) {
        /*StringBuilder sb = new StringBuilder();
        int carry = 0;
        String sum = "";
        StringBuilder zeros = new StringBuilder();
        for(int i=b.length()-1; i>=0; i--) {
            StringBuilder multipliedVal = new StringBuilder();
            for(int j=a.length()-1; j>=0; j--) {
                int b1 = Integer.valueOf(b.charAt(i)-'0');
                int a1 = Integer.valueOf(a.charAt(j)-'0');
                int mulVal = a1*b1;
                if(mulVal < 9 && carry == 0) {
                    multipliedVal.append(mulVal);
                }
                else if(mulVal > 9 && carry == 0) {
                    String mulValStr = String.valueOf(mulVal);
                    carry = Integer.valueOf(mulValStr.substring(0, mulValStr.length()-1));
                    multipliedVal.append(mulValStr.charAt(0));
                }
                else if(carry > 0) {
                    String mulValStr = String.valueOf(mulVal+carry);
                    carry = Integer.valueOf(mulValStr.substring(0, mulValStr.length()-1));
                    multipliedVal.append(mulValStr.charAt(0));
                }
            }
            sb.append(multipliedVal.reverse().append(zeros));
            zeros.append('0');

            if(sum.length() > 0) {

            }

        }
        return sb.toString();*/

        String n1 = new StringBuilder(a).reverse().toString();
        String n2 = new StringBuilder(b).reverse().toString();

        int[] d = new int[a.length()+b.length()];

        //multiply each digit and sum at the corresponding positions
        for(int i=0; i<n1.length(); i++){
            for(int j=0; j<n2.length(); j++){
                d[i+j] += (n1.charAt(i)-'0') * (n2.charAt(j)-'0');
            }
        }

        StringBuilder sb = new StringBuilder();

        //calculate each digit
        for(int i=0; i<d.length; i++){
            int mod = d[i]%10;
            int carry = d[i]/10;
            if(i+1<d.length){
                d[i+1] += carry;
            }
            sb.insert(0, mod);
        }

        //remove front 0's
        while(sb.charAt(0) == '0' && sb.length()> 1){
            sb.deleteCharAt(0);
        }

        return sb.toString();
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        System.out.println(solution.power("115792089237316195423570985008687907853269984665640564039457584007913129639936"));
        System.out.println(solution.power("2"));
        System.out.println(solution.power("20"));

        System.out.println(solution.multiply("256", "622"));
    }
}
