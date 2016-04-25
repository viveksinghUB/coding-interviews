package linkedlists.pointermove;

/**
 * Created by Sravan on 4/23/16.
 */
public class Solution {

    public ListNode swapPairs(ListNode head) {
        if(head == null || head.next == null) {
            return head;
        }
        else {
            ListNode dummy = new ListNode(0);
            ListNode p = dummy;
            dummy.next = head;

            while(p != null && p.next != null && p.next.next != null) {
                ListNode n = p.next;
                ListNode nn = p.next.next;
                p.next = nn;
                n.next = nn.next;
                nn.next = n;
                p = p.next.next;
            }

            return dummy.next;
        }
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        solution.swapPairs(head);
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

