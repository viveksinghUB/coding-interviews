package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sravan on 9/18/16.
 */
public class InsertionSort {

    public void sort(List<Integer> array)
    {
        for(int i=1; i<array.size(); i++)
        {
            int value = array.get(i);
            int hole = i;
            while(hole > 0 && array.get(hole-1) > value)
            {
                array.set(hole, array.get(hole-1));
                hole = hole-1;
                System.out.println(array);
            }
            array.set(hole, value);
        }
        System.out.println("============================");
        System.out.println("=====Start Sorted Array=====");
        System.out.println("============================");
        System.out.println(array);
        System.out.println("============================");
        System.out.println("=====End Sorted Array=====");
        System.out.println("============================");

    }

    public static void main(String[] args)
    {
        InsertionSort insertionSort = new InsertionSort();
        insertionSort.sort(Arrays.asList(2, 4, 1, 0, -2, 5));
        insertionSort.sort(Arrays.asList(-10, 100, 1, 205, -2, 5));
        insertionSort.sort(Arrays.asList(2, 7, 4, 1, 5, 3));
    }
}
