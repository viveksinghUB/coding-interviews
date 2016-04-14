package linkedlists.list2pointer;

/**
 * Created by Sravan on 4/11/16.
 */
public class Solution {

    public ListNode mergeTwoLists(ListNode a, ListNode b) {
        ListNode head = new ListNode(Integer.MIN_VALUE);
        ListNode temp = head;
        while(a != null && b !=null) {
            if(a.val <= b.val) {
                temp.next = a;
                a = a.next;
            }
            else {
                temp.next = b;
                b = b.next;
            }
            temp = temp.next;
        }

        if(a == null) {
            temp.next = b;
        }
        else {
            temp.next = a;
        }

        return head.next;
    }

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

    public ListNode deleteDuplicates2(ListNode a) {

        if(a == null) {
            return a;
        }

        ListNode prev = new ListNode(0);
        prev.next = a;
        a = prev;

        ListNode n1=a;
        while(n1.next != null) {
            ListNode n2 = n1.next;
            while(n2.next != null && n2.next.val == n2.val) {
                n2 = n2.next;
            }
            if(n2 != n1.next) {
                n1.next = n2.next;
            }
            else {
                n1 = n1.next;
            }
        }

        return a.next;
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(1);
        head.next.next = new ListNode(2);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next = new ListNode(3);
        head.next.next.next.next.next.next = new ListNode(4);

        solution.deleteDuplicates(head);

        solution.deleteDuplicates2(head);

        ListNode listNode1 = new ListNode(1);
        listNode1.next = new ListNode(2);
        listNode1.next.next = new ListNode(4);
        listNode1.next.next.next = new ListNode(5);
        listNode1.next.next.next.next = new ListNode(7);

        ListNode listNode2 = new ListNode(2);
        listNode2.next = new ListNode(3);
        listNode2.next.next = new ListNode(5);
        listNode2.next.next.next = new ListNode(8);
        listNode2.next.next.next.next = new ListNode(9);

        solution.mergeTwoLists(listNode1, listNode2);
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
