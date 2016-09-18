package algorithms.sorting;

import java.util.Arrays;
import java.util.List;

/**
 * Created by Sravan on 9/17/16.
 */
public class BubbleSort {

    public void sort(List<Integer> array)
    {
        for(int i=0; i<array.size(); i++)
        {
            for(int j=0; j<array.size()-i-1; j++)
            {
                if(array.get(j) > array.get(j+1))
                {
                    int temp = array.get(j+1);
                    array.set(j+1, array.get(j));
                    array.set(j, temp);
                }
            }
            System.out.println("=====After Pass - " +(i+1) +"=====");
            System.out.println(array);
        }
        System.out.println("============================");
        System.out.println("=====Final Sorted Array=====");
        System.out.println("============================");
        System.out.println(array);
    }

    public static void main(String[] args)
    {
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.sort(Arrays.asList(2, 4, 1, 0, -2, 5));
        bubbleSort.sort(Arrays.asList(-10, 100, 1, 205, -2, 5));
        bubbleSort.sort(Arrays.asList(2, 7, 4, 1, 5, 3));
    }
}
