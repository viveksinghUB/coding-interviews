package crackingcodinginterview.arrays;

import java.util.ArrayDeque;
import java.util.Queue;
import java.util.Scanner;

/**
 * Created by Sravan on 9/28/16.
 */
public class Solution {

    public static int[] arrayLeftRotation(int[] a, int n, int k) {
        Queue<Integer> queue = new ArrayDeque<Integer>();
        int[] rotatedArray = new int[n];
        int l = 0;
        if(k>n) {
            k=k%n;
        }

        for(int i=0; i<k; i++) {
            queue.offer(a[i]);
        }
        for(int j=k; j<n; j++, l++) {
            rotatedArray[l] = a[j];
        }
        while(!queue.isEmpty()) {
            rotatedArray[l] = queue.poll();
            l++;
        }

        return rotatedArray;
    }

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int n = in.nextInt();
        int k = in.nextInt();
        int a[] = new int[n];
        for(int a_i=0; a_i < n; a_i++){
            a[a_i] = in.nextInt();
        }

        int[] output = new int[n];
        output = arrayLeftRotation(a, n, k);
        for(int i = 0; i < n; i++)
            System.out.print(output[i] + " ");

        System.out.println();

    }
}

