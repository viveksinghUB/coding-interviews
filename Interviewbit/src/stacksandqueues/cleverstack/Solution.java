package stacksandqueues.cleverstack;

import java.util.ArrayList;
import java.util.Stack;

/**
 * Created by Sravan on 5/7/16.
 */
public class Solution {

    public ArrayList<Integer> prevSmaller(ArrayList<Integer> arr) {
        Stack<Integer> st = new Stack<>();
        ArrayList<Integer> output = new ArrayList<>();

        for (Integer a:arr) {
            while (!st.empty() && st.peek() >= a) {
                st.pop();
            }
            if (st.isEmpty()) {
                output.add(-1);
            }
            else {
                output.add(st.peek());
            }
            st.push(a);
        }

        return output;
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        ArrayList<Integer> list1 = new ArrayList<>();
        list1.add(3);
        list1.add(3);
        list1.add(3);

        ArrayList<Integer> list2 = new ArrayList<>();
        list2.add(4);
        list2.add(5);
        list2.add(2);
        list2.add(10);

        //solution.prevSmaller(list1);
        solution.prevSmaller(list2);
    }
}
