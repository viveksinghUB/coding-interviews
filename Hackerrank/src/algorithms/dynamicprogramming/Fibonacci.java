package algorithms.dynamicprogramming;

import java.math.BigInteger;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

/**
 * Created by Sravan on 10/2/16.
 */
public class Fibonacci {

    public static BigInteger modifiedFibonacci(int t1, int t2, int n) {
        List<BigInteger> memo = new ArrayList<>();
        memo.add(BigInteger.valueOf(t1));
        memo.add(BigInteger.valueOf(t2));
        for(int i=2; i<n; i++) {
            BigInteger previousVal = memo.get(i-2);
            BigInteger squareOfBigInt = memo.get(i-1).multiply(memo.get(i-1));
            BigInteger value = previousVal.add(squareOfBigInt);
            memo.add(value);
        }

        return memo.get(n-1);
    }

    /*public static BigInteger sqrt(BigInteger n) {
        BigInteger a = BigInteger.ONE;
        BigInteger b = n.shiftRight(5).add(BigInteger.valueOf(8));
        while (b.compareTo(a) >= 0) {
            BigInteger mid = a.add(b).shiftRight(1);
            if (mid.multiply(mid).compareTo(n) > 0) {
                b = mid.subtract(BigInteger.ONE);
            } else {
                a = mid.add(BigInteger.ONE);
            }
        }
        return a.subtract(BigInteger.ONE);
    }*/

    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        int t1 = in.nextInt();
        int t2 = in.nextInt();
        int n = in.nextInt();

        System.out.println(modifiedFibonacci(t1, t2, n).toString());
    }

}
