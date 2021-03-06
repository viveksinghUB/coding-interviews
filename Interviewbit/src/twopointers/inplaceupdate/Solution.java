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

    public int removeElement(ArrayList<Integer> a, int b) {
        int start = 0;
        for(int i = 0; i < a.size(); i++){
            if(a.get(i) != b){
                a.set(start, a.get(i));
                start++;
            }
        }

        return start;
    }

    public ArrayList<Integer> sortColors(ArrayList<Integer> a) {
        sort(a, 0, a.size()-1);

        return a;
    }

    static void sort(ArrayList<Integer> arr, int start, int end) {
        if (start < end) {
            int pIndex = partition(arr, start, end);
            sort(arr, start, pIndex - 1);
            sort(arr, pIndex + 1, end);
        }
    }

    static int partition(ArrayList<Integer> arr, int start, int end) {
        int pivot = arr.get(end);
        int pIndex = start;
        for (int i = start; i < end; i++) {
            if (arr.get(i) <= pivot) {
                swap(arr, i, pIndex);
                pIndex++;
            }
        }
        swap(arr, pIndex, end);
        return pIndex;
    }

    static void swap(ArrayList<Integer> arr, int x, int y) {
        int temp = arr.get(x);
        arr.set(x, arr.get(y));
        arr.set(y, temp);
    }

    public static void main(String... args) {
        Solution solution = new Solution();
        Integer[] a = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 2, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3, 3};
        Integer[] b = {1, 1, 1, 1, 2, 2, 2};
        Integer[] c = {2, 0, 1, 2, 0, 3, 2, 2, 2, 1, 0, 0, 0, 1, 0, 0, 2, 2, 2, 3, 2, 3, 1, 2, 1, 2, 2, 3, 2, 3, 0, 3, 0, 2, 1, 2, 0, 0, 3, 2, 3, 0, 3, 0, 2, 3, 2, 2, 3, 1, 3, 3, 0, 3, 3, 0, 3, 3, 2, 0, 0, 0, 0, 1, 3, 0, 3, 1, 3, 1, 0, 2, 3, 3, 3, 2, 3, 3, 2, 2, 3, 3, 3, 1, 3, 2, 1, 0, 0, 0, 1, 0, 3, 2, 1, 0, 2, 3, 0, 2, 1, 1, 3, 2, 0, 1, 1, 3, 3, 0, 1, 2, 1, 2, 2, 3, 1, 1, 3, 0, 2, 2, 2, 2, 1, 0, 2, 2, 2, 1, 3, 1, 3, 1, 1, 0, 2, 2, 0, 2, 3, 0, 1, 2, 1, 1, 3, 0, 2, 3, 2, 3, 2, 0, 2, 2, 3, 2, 2, 0, 2, 1, 3, 0, 2, 0, 2, 1, 3, 1, 1, 0, 0, 3, 0, 1, 2, 2, 1, 2, 0, 1, 0, 0, 0, 1, 1, 0, 3, 2, 3, 0, 1, 3, 0, 0, 1, 0, 1, 0, 0, 0, 0, 3, 2, 2, 0, 0, 1, 2, 0, 3, 0, 3, 3, 3, 0, 3, 3, 1, 0, 1, 2, 1, 0, 0, 2, 3, 1, 1, 3, 2};
        Integer[] d = {1, 1, 2, 3, 4};

        System.out.println(solution.removeDuplicates(new ArrayList<Integer>(Arrays.asList(a))));

        System.out.println(solution.removeDuplicates_WithAtMost2(new ArrayList<Integer>(Arrays.asList(a))));
        System.out.println(solution.removeDuplicates_WithAtMost2(new ArrayList<Integer>(Arrays.asList(b))));

        System.out.println(solution.removeElement(new ArrayList<Integer>(Arrays.asList(d)), 1));

        System.out.println(solution.sortColors(new ArrayList<Integer>(Arrays.asList(c))));
    }
}
