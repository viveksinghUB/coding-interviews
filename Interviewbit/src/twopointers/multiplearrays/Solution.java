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

    public ArrayList<Integer> merge(ArrayList<Integer> a, ArrayList<Integer> b) {
        int i = 0;
        int j = 0;

        while(i < a.size() && j < b.size()) {
            if(a.get(i) < b.get(j)) {
                i++;
            }
            else if(a.get(i) >= b.get(j)) {
                a.add(i, b.get(j));
                i++;
                j++;
            }
            else {
                j++;
            }
        }
        if(j < b.size()) {
            a.add(b.get(j++));
        }

        return a;
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        Integer[] a = {1, 1, 1, 1, 2, 2, 3};
        Integer[] b = {1, 2, 3, 5, 6};
        Integer[] c = {10000};
        Integer[] d = {10000};
        Integer[] e = {1, 3, 5, 7};
        Integer[] f = {2, 2, 4, 6, 8};
        Integer[] g = {1, 2};
        Integer[] h = {-1, 2};

        System.out.println(solution.intersect(new ArrayList<Integer>(Arrays.asList(a)), new ArrayList<Integer>(Arrays.asList(b))));
        System.out.println(solution.intersect(new ArrayList<Integer>(Arrays.asList(c)), new ArrayList<Integer>(Arrays.asList(d))));

        System.out.println(solution.merge(new ArrayList<Integer>(Arrays.asList(e)), new ArrayList<Integer>(Arrays.asList(f))));
        System.out.println(solution.merge(new ArrayList<Integer>(Arrays.asList(g)), new ArrayList<Integer>(Arrays.asList(h))));
    }
}
