package twopointers.inplaceupdate;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Sravan on 3/13/16.
 */
public class Solution {

    public int removeDuplicates(ArrayList<Integer> a) {
        int index = 1;
        for(int i = 1; i < a.size(); i++){
            if(!a.get(i).equals(a.get(i-1))){
                a.set(index, a.get(i));
                index++;
            }
        }

        return index;
    }

    public int removeDuplicates_WithAtMost2(ArrayList<Integer> a) {
        int index = 1;
        boolean addedTwice = false;
        for(int i = 1; i < a.size(); i++){
            if(!addedTwice && a.get(i).equals(a.get(i-1))) {
                a.set(index, a.get(i));
                addedTwice = true;
                index++;
            }
            if(!a.get(i).equals(a.get(i-1))){
                a.set(index, a.get(i));
                addedTwice = false;
                index++;
            }
        }

        return index;
    }

    public static void main(String... args) {
       Solution solution = new Solution();
        Integer[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        Integer[] b = {1, 1, 1, 1, 2, 2, 2};
        System.out.println(solution.removeDuplicates(new ArrayList<Integer>(Arrays.asList(a))));
        System.out.println(solution.removeDuplicates_WithAtMost2(new ArrayList<Integer>(Arrays.asList(a))));
        System.out.println(solution.removeDuplicates_WithAtMost2(new ArrayList<Integer>(Arrays.asList(b))));
    }
}
