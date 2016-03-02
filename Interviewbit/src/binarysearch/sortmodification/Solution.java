package binarysearch.sortmodification;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/**
 * Created by Sravan on 3/1/16.
 */
public class Solution {

    public int search(final List<Integer> a, int b) {

        int pivot = -1;
        int targetIndex = -1;
        int low = 0;
        int high = a.size()-1;

        while(low <= high) {

            if(a.get(low) <= a.get(high)) {
                pivot = low;
                break;
            }

            int mid = low + (high - low)/2;
            int next = (mid + 1)%a.size();
            int prev = (mid + a.size() - 1)%a.size();

            if(a.get(mid) <= a.get(next) && a.get(mid) <= a.get(prev)) {
                pivot = mid;
                break;
            }
            else if(a.get(mid) <= a.get(high)) {
                high = mid - 1;
            }
            else if(a.get(mid) >= a.get(low)) {
                low = mid + 1;
            }
        }

        if(pivot != -1) {
            low = 0;
            high = a.size()-1;
            if(b == a.get(pivot)) {
                targetIndex = pivot;
            }
            else {
                if(b > a.get(pivot) && b<= a.get(high)) {
                    low = pivot;
                }
                else if(b >= a.get(low) && b <= a.get(pivot-1)) {
                    high = pivot-1;
                }
                while (low <= high) {
                    int mid = low + (high - low)/2;
                    if(b == a.get(mid)) {
                        targetIndex = mid;
                        break;
                    }
                    if(b >= a.get(mid)) {
                        low = mid + 1;
                    }
                    else {
                        high = mid - 1;
                    }
                }
            }
        }

        return targetIndex;

    }

    public static void main(String... args) {
        Solution solution = new Solution();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(4, 5, 6, 7, 0, 1, 2));
        ArrayList<Integer> b = new ArrayList<>(Arrays.asList(0, 1, 2, 4, 5, 6, 7));

        System.out.println(solution.search(b, 4));
    }
}
