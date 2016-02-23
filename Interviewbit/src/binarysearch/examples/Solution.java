package binarysearch.examples;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sravan on 2/23/16.
 */
public class Solution {

    public int findCount(final List<Integer> a, int b) {
        int startIndex = -1;
        int stopIndex = -1;
        int lowIndex = 0;
        int highIndex = a.size()-1;
        while(lowIndex <= highIndex) {
            int mid = lowIndex + (highIndex - lowIndex)/2;
            if(b == a.get(mid)) {
                startIndex = mid;
            }
            if(b <= a.get(mid)) {
                highIndex = mid - 1;
            }
            else {
                lowIndex = mid + 1;
            }
        }

        lowIndex = 0;
        highIndex = a.size()-1;
        while(lowIndex <= highIndex) {
            int mid = lowIndex + (highIndex - lowIndex)/2;
            if(b == a.get(mid)) {
                stopIndex = mid;
            }
            if(b >= a.get(mid)) {
                lowIndex = mid + 1;
            }
            else {
                highIndex = mid - 1;
            }
        }

        if(startIndex == -1 && stopIndex == -1) {
            return 0;
        }
        else {
            return stopIndex - startIndex + 1;
        }
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(2, 2, 2, 2, 3));

        System.out.println(solution.findCount(a, 2));
        System.out.println(solution.findCount(a, 3));
        System.out.println(solution.findCount(a, 4));
    }
}
