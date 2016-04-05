package twopointers.sorting;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;

/**
 * Created by Sravan on 4/4/16.
 */
public class Solution {

    public int threeSumClosest(ArrayList<Integer> a, int b) {

        Collections.sort(a);

        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < a.size(); i++)
        {
            int j = i + 1;
            int k = a.size() - 1;
            while (j < k) {
                int sum = a.get(i) + a.get(j) + a.get(k);
                int diff = Math.abs(sum - b);

                if(diff == 0) {
                    return sum;
                }

                if (diff < min) {
                    min = diff;
                    result = sum;
                }
                if (sum < b) {
                    j++;
                } else {
                    k--;
                }
            }
        }

        return result;
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        Integer[] a = {-1, 2, 4, 1};

        System.out.println(solution.threeSumClosest(new ArrayList<Integer>(Arrays.asList(a)), 1));
    }
}
