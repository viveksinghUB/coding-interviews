package bitmanipulation.bitplay;

import java.util.*;

/**
 * Created by Sravan on 3/3/16.
 */
public class Solution {

    public int numSetBits(long a) {
        ArrayList<Integer> numberOf1s = new ArrayList<>();

        while(a>0) {

            if(a%2 == 1) {
                numberOf1s.add(1);
            }
            a = a/2;
        }

        return numberOf1s.size();
    }

    public long reverse(long a) {
        long temp = 0;
        Stack<Integer> integerStack = new Stack<Integer>();
        while(a>0) {
            integerStack.add((int)(a%2));
            a = a/2;
        }
        for(int i=integerStack.size(); i<32; i++) {
            integerStack.add(0);
        }
        int i = 0;
        while (!integerStack.isEmpty()) {
            temp += integerStack.pop()*Math.pow(2, i);
            i++;
        }

        return temp;
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        System.out.println(solution.numSetBits(11));
        System.out.println(solution.reverse(3));
    }
}
