package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sravan on 9/17/16.
 */
public class SelectionSort {

    public void sort(List<Integer> array)
    {
        for(int i=0; i<array.size()-1; i++)
        {
            int minIndex = i;
            for(int j=minIndex+1; j<array.size(); j++)
            {
                if(array.get(j) < array.get(minIndex))
                {
                    minIndex = j;
                }
            }
            int temp = array.get(minIndex);
            array.set(minIndex, array.get(i));
            array.set(i, temp);
        }

        System.out.println(array);
    }

    public static void main(String[] args)
    {
        SelectionSort selectionSort = new SelectionSort();
        selectionSort.sort(Arrays.asList(2, 4, 1, 0, -2, 5));
        selectionSort.sort(Arrays.asList(-10, 100, 1, 205, -2, 5));
    }
}
