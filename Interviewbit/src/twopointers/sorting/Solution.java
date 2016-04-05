package twopointers.sorting;

import java.util.*;

/**
 * Created by Sravan on 4/4/16.
 */
public class Solution {

    public int threeSumClosest(ArrayList<Integer> a, int b) {

        Collections.sort(a);

        int min = Integer.MAX_VALUE;
        int result = 0;
        for (int i = 0; i < a.size(); i++) {
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

    public ArrayList<ArrayList<Integer>> threeSumZero(ArrayList<Integer> a) {
        Collections.sort(a);
        Set<ArrayList<Integer>> threeSumZeroSet = new HashSet<ArrayList<Integer>>();
        ArrayList<ArrayList<Integer>> threeSumZeroArr = new ArrayList<ArrayList<Integer>>();

        for (int i = 0; i < a.size(); i++) {
            int j = i + 1;
            int k = a.size() - 1;
            while (j < k) {
                int sum = a.get(i) + a.get(j) + a.get(k);

                if (sum < 0) {
                    j++;
                }
                else if(sum > 0){
                    k--;
                }
                else {
                    ArrayList<Integer> temp = new ArrayList<Integer>();

                    temp.add(a.get(i));
                    temp.add(a.get(j));
                    temp.add(a.get(k));

                    threeSumZeroSet.add(temp);

                    j++;
                    k--;
                }
            }
        }

        Iterator<ArrayList<Integer>> arrayListIterator = threeSumZeroSet.iterator();
        while (arrayListIterator.hasNext()) {
            threeSumZeroArr.add(arrayListIterator.next());
        }

        return threeSumZeroArr;

    }

    public static void main(String... args) {
        Solution solution = new Solution();

        Integer[] a = {-1, 2, 4, 1};
        Integer[] b = {-1, 2, 0, 1};
        Integer[] c = {-1, 0, 1, 2, -1, -4};
        Integer[] d = {1, -4, 0, 0, 5, -5, 1, 0, -2, 4, -4, 1, -1, -4, 3, 4, -1, -1, -3};

        System.out.println(solution.threeSumClosest(new ArrayList<Integer>(Arrays.asList(a)), 1));

        System.out.println(solution.threeSumZero(new ArrayList<Integer>(Arrays.asList(b))));
        System.out.println(solution.threeSumZero(new ArrayList<Integer>(Arrays.asList(c))));
        System.out.println(solution.threeSumZero(new ArrayList<Integer>(Arrays.asList(d))));
    }
}
