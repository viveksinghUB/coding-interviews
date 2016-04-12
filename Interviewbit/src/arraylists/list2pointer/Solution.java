package arraylists.list2pointer;

import jdk.nashorn.internal.ir.WhileNode;

/**
 * Created by Sravan on 4/11/16.
 */
public class Solution {

    public ListNode deleteDuplicates(ListNode a) {
        ListNode previous = a;
        ListNode current = a.next;

        while (current != null) {
            if(previous.val == current.val) {
                previous.next = current.next;
            }
            else {
                previous = current;
            }
            current = current.next;
        }

        return a;
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);

        solution.deleteDuplicates(head);
    }

}

class ListNode {

    public int val;
    public ListNode next;

    ListNode(int x) {
        val = x;
        next = null;
    }
}
