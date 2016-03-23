package twopointers.multiplearrays;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sravan on 3/22/16.
 */
public class Solution {

    public ArrayList<Integer> intersect(final List<Integer> a, final List<Integer> b) {
        ArrayList<Integer> intersectedList = new ArrayList<>();
        int aCounter = 0;
        int bCounter = 0;
        while (aCounter < a.size() && bCounter < b.size()) {
            if(a.get(aCounter).equals(b.get(bCounter))) {
                intersectedList.add(a.get(aCounter));
                aCounter++;
                bCounter++;
            }
            else if(a.get(aCounter) < b.get(bCounter)) {
                aCounter++;
            }
            else {
                bCounter++;
            }
        }

        return intersectedList;
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        Integer[] a = {1, 1, 1, 1, 2, 2, 3};
        Integer[] b = {1, 2, 3, 5, 6};
        Integer[] c = {10000};
        Integer[] d = {10000};

        //System.out.println(solution.intersect(new ArrayList<Integer>(Arrays.asList(a)), new ArrayList<Integer>(Arrays.asList(b))));
        System.out.println(solution.intersect(new ArrayList<Integer>(Arrays.asList(c)), new ArrayList<Integer>(Arrays.asList(d))));
    }
}
