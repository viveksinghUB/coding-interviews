package maths.paths;

/**
 * Created by Sravan on 2/18/16.
 */
public class Solution {
    public int uniquePaths(int a, int b) {
        int n = a-1 + b-1;
        int r = a-1;
        return nCr(n, r);
    }

    int nCr(int n, int r) {
        if (r == 0 || r == n) {
            return 1;  // stop recursion, we know the answer.
        }
        return nCr(n-1, r-1) + nCr(n-1, r); // the answer is made of the sum of two "easier" ones
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        System.out.print(solution.uniquePaths(1, 1));

    }
}
