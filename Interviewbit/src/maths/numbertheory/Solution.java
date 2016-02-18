package maths.numbertheory;

import java.util.Stack;

/**
 * Created by Sravan on 2/17/16.
 */
public class Solution {

    public int gcd(int a, int b) {
        if(a == 0 || b == 0) {
            return a+b;
        } // base case
        return gcd(b,a%b);
    }

    public int trailingZeroes(int a) {
        int trialingZeros = 0;

        int counter = 1;
        while(a/(int)Math.pow(5, counter) > 0) {
            trialingZeros += a/(int)Math.pow(5, counter);
            counter++;
        }
        return trialingZeros;
    }

    public int reverse(int a) {
        int revInt = 0;
        try {
            if(revInt < Integer.MIN_VALUE || revInt > Integer.MAX_VALUE) {
                return revInt;
            }
            else {
                Stack<Character> stack = new Stack<Character>();
                String strInt = String.valueOf(a);
                String strRevInt = "";
                int t = 0;

                if(a < 0) {
                    t = 1;
                    strRevInt = "-";
                }

                for(int i=t; i<strInt.length(); i++)
                {
                    stack.push(strInt.charAt(i));
                }

                while (!stack.isEmpty()) {
                    strRevInt += stack.pop();
                }

                revInt = Integer.valueOf(strRevInt);

            }
        }
        catch (NumberFormatException nfe)
        {

        }
        return revInt;
    }
}
