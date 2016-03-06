package bitmanipulation.bitplay;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Stack;

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

    public int singleNumber(final List<Integer> a) {
        //Collections.sort(a);
        int result = a.get(0);
        for(int i = 1; i < a.size(); i++){
            result ^= a.get(i);
        }
        return result;
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        System.out.println(solution.numSetBits(11));
        System.out.println(solution.reverse(3));
        System.out.println(solution.singleNumber(Arrays.asList(1, 2, 2, 3, 1)));
        System.out.println(solution.singleNumber(Arrays.asList(723, 256, 668, 723, 140, 360, 597, 233, 128, 845, 737, 804, 986, 701, 906, 512, 845, 510, 510, 227, 430, 701, 366, 946, 464, 619, 946, 627, 209, 771, 424, 555, 959, 711, 530, 937, 716, 261, 505, 658, 706, 140, 511, 277, 396, 233, 819, 196, 475, 906, 583, 261, 147, 658, 517, 197, 196, 702, 944, 711, 128, 555, 149, 483, 530, 291, 716, 258, 430, 464, 601, 749, 149, 415, 802, 573, 627, 771, 660, 601, 360, 986, 291, 51, 415, 51, 227, 258, 937, 366, 923, 669, 33, 517, 417, 702, 475, 706, 110, 417, 275, 804, 500, 473, 746, 973, 669, 275, 973, 147, 817, 657, 277, 923, 144, 660, 197, 511, 793, 893, 944, 505, 322, 817, 586, 512, 322, 668, 33, 424, 962, 597, 144, 746, 345, 753, 345, 269, 819, 483, 368, 802, 573, 962, 583, 615, 208, 209, 269, 749, 256, 657, 619, 893, 959, 473, 753, 299, 396, 299, 500, 368, 586, 110, 793, 737, 615)));
    }
}
