package linkedlists.examples;

/**
 * Created by Sravan on 4/11/16.
 */
public class Solution {

    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        int len1 = 0;
        int len2 = 0;
        ListNode p1 = headA, p2 = headB;
        if (p1 == null || p2 == null) {
            return null;
        }
        while (p1 != null) {
            len1++;
            p1 = p1.next;
        }
        while (p2 != null) {
            len2++;
            p2 = p2.next;
        }

        int diff = 0;
        p1 = headA;
        p2 = headB;

        if (len1 > len2) {
            diff = len1 - len2;
            int i = 0;
            while (i < diff) {
                p1 = p1.next;
                i++;
            }
        } else {
            diff = len2 - len1;
            int i = 0;
            while (i < diff) {
                p2 = p2.next;
                i++;
            }
        }

        while (p1 != null && p2 != null) {
            if (p1.hashCode() == p2.hashCode()) {
                return p1;
            }
            p1 = p1.next;
            p2 = p2.next;
        }

        return null;
    }

    public ListNode reverseList(ListNode a) {

        int len = 0;
        ListNode linkedList = a;
        while (linkedList != null) {
            len++;
            linkedList = linkedList.next;
        }

        ListNode current = a;
        ListNode next;
        ListNode previous = null;
        while (current != null) {
            next = current.next;
            current.next = previous;
            previous = current;
            current = next;
        }

        if(len > 1) {
            a = previous;
        }

        return a;
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        solution.reverseList(head);
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
