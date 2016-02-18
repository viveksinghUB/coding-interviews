package maths.numberencoding;

import java.util.ArrayList;
import java.util.Arrays;

/**
 * Created by Sravan on 2/17/16.
 */
public class Solution {

    public void arrange(ArrayList<Integer> a) {
        int N = a.size();

        for(int i=0; i<N; i++){
            int B = a.get(i);
            int C = a.get(B);
            if(C >= N) {
                C = a.get(B)%N;
            }
            int encode = B + C*N;
            a.set(i, encode);
        }
        for(int i=0; i<N; i++) {
            a.set(i, a.get(i)/N);
        }

    }

    public static void main(String... args) {

        Solution solution = new Solution();
        ArrayList<Integer> a = new ArrayList<>(Arrays.asList(1, 2, 0, 3));
        solution.arrange(a);


    }
}
