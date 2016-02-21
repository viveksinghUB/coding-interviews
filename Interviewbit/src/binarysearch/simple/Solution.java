package binarysearch.simple;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Sravan on 2/19/16.
 */
public class Solution {

    public int searchMatrix(ArrayList<ArrayList<Integer>> a, int b) {
        int elementFound = 0;
        int low2D = 0;
        int high2D = a.size() - 1;
        int elementPresentIndex = -1;

        while (low2D <= high2D) {
            int mid2D = low2D + (high2D-low2D)/2;
            int eachArraySize = a.get(mid2D).size();
            if(b >= a.get(mid2D).get(0) && b<= a.get(mid2D).get(eachArraySize-1)) {
                elementPresentIndex = mid2D;
                break;
            }
            else if(b < a.get(mid2D).get(0)) {
                high2D = mid2D -1;
            }
            else if(b > a.get(mid2D).get(eachArraySize-1)) {
                low2D = mid2D + 1;
            }
        }

        if(elementPresentIndex != -1) {
            int low = 0;
            int high = a.get(elementPresentIndex).size() - 1;
            while (low <= high) {
                int mid = low + (high - low)/2;
                if(b == a.get(elementPresentIndex).get(mid)) {
                    elementFound = 1;
                    return elementFound;
                }
                else if(b < a.get(elementPresentIndex).get(mid)) {
                    high = mid - 1;
                }
                else {
                    low = mid + 1;
                }
            }

        }

        return elementFound;
    }

    //INSERTPOS
    public int searchInsert(ArrayList<Integer> a, int b) {
        int elementIndex = -1;
        int low = 0;
        int high = a.size() - 1;
        while (low <= high) {
            int mid = low + (high - low)/2;
            if(b == a.get(mid)) {
                elementIndex = mid;
                return elementIndex;
            }
            else if(b < a.get(mid)) {
                high = mid - 1;
            }
            else {
                low = mid + 1;
            }
        }

        if(elementIndex == -1) {
            low = 0;
            high = a.size() - 1;
            if(b > a.get(high)) {
                return high+1;
            }
            else if(b < a.get(low)) {
                return 0;
            }
            else {
                while (low <= high) {
                    int mid = low + (high - low)/2;
                    if(b < a.get(mid)) {
                        high = mid - 1;
                    }
                    else {
                        low = mid + 1;
                    }
                }
                if(b < a.get(low)) {
                    return low;
                }
                else if(b > a.get(low) && b <a.get(high)) {
                    return low + 1;
                }
                else {
                    return high + 1;
                }
            }
        }

        return elementIndex;

    }

    public static void main(String... args) {
        Solution solution = new Solution();
        ArrayList<ArrayList<Integer>> a = new ArrayList<ArrayList<Integer>>();

        ArrayList<Integer> a1 = new ArrayList<Integer>(Arrays.asList(1, 2, 3, 4, 6, 7));
        //ArrayList<Integer> a2 = new ArrayList<Integer>(Arrays.asList(5, 6, 7, 8));
        //ArrayList<Integer> a3 = new ArrayList<Integer>(Arrays.asList(9, 10, 11, 12));

        a.add(a1);
        //a.add(a2);
        //a.add(a3);

        //System.out.println(solution.searchMatrix(a, 4));
        System.out.println(solution.searchInsert(a1, 5));
    }
}
