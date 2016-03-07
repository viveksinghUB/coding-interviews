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

    public int singleNumber(final List<Integer> a) {
        //Collections.sort(a);
        int result = a.get(0);
        for(int i = 1; i < a.size(); i++){
            result ^= a.get(i);
        }
        return result;
    }

    public int singleNumber_Thrice(final List<Integer> a) {
        int t1 = 0;
        int t2 = 0;
        int t3 = 0;

        for (int i = 0; i < a.size(); i++){
            t1 = t1 ^ a.get(i);
            t2 = t2 | ( (t1^a.get(i) ) & a.get(i) );
            t3 = ~(t1 & t2);
            t1 = t1 & t3;
            t2 = t2 & t3;
        }

        return t1;
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        System.out.println(solution.numSetBits(11));
        System.out.println(solution.reverse(3));
        System.out.println(solution.singleNumber(Arrays.asList(1, 2, 2, 3, 1)));
        System.out.println(solution.singleNumber(Arrays.asList(723, 256, 668, 723, 140, 360, 597, 233, 128, 845, 737, 804, 986, 701, 906, 512, 845, 510, 510, 227, 430, 701, 366, 946, 464, 619, 946, 627, 209, 771, 424, 555, 959, 711, 530, 937, 716, 261, 505, 658, 706, 140, 511, 277, 396, 233, 819, 196, 475, 906, 583, 261, 147, 658, 517, 197, 196, 702, 944, 711, 128, 555, 149, 483, 530, 291, 716, 258, 430, 464, 601, 749, 149, 415, 802, 573, 627, 771, 660, 601, 360, 986, 291, 51, 415, 51, 227, 258, 937, 366, 923, 669, 33, 517, 417, 702, 475, 706, 110, 417, 275, 804, 500, 473, 746, 973, 669, 275, 973, 147, 817, 657, 277, 923, 144, 660, 197, 511, 793, 893, 944, 505, 322, 817, 586, 512, 322, 668, 33, 424, 962, 597, 144, 746, 345, 753, 345, 269, 819, 483, 368, 802, 573, 962, 583, 615, 208, 209, 269, 749, 256, 657, 619, 893, 959, 473, 753, 299, 396, 299, 500, 368, 586, 110, 793, 737, 615)));
        System.out.println(solution.singleNumber_Thrice(Arrays.asList(890, 992, 172, 479, 973, 901, 417, 215, 901, 283, 788, 102, 726, 609, 379, 587, 630, 283, 10, 707, 203, 417, 382, 601, 713, 290, 489, 374, 203, 680, 108, 463, 290, 290, 382, 886, 584, 406, 809, 601, 176, 11, 554, 801, 166, 303, 308, 319, 172, 619, 400, 885, 203, 463, 303, 303, 885, 308, 460, 283, 406, 64, 584, 973, 572, 194, 383, 630, 395, 901, 992, 973, 938, 609, 938, 382, 169, 707, 680, 965, 726, 726, 890, 383, 172, 102, 10, 308, 10, 102, 587, 809, 460, 379, 713, 890, 463, 108, 108, 811, 176, 169, 313, 886, 400, 319, 22, 885, 572, 64, 120, 619, 313, 3, 460, 713, 811, 965, 479, 3, 247, 886, 120, 707, 120, 176, 374, 609, 395, 811, 406, 809, 801, 554, 3, 194, 11, 587, 169, 215, 313, 319, 554, 379, 788, 194, 630, 601, 965, 417, 788, 479, 64, 22, 22, 489, 166, 938, 66, 801, 374, 66, 619, 489, 215, 584, 383, 66, 680, 395, 400, 166, 572, 11, 992)));
        System.out.println(solution.singleNumber_Thrice(Arrays.asList(1, 1, 1, 2, 3, 3, 3)));
    }
}
