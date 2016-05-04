package linkedlists.listsort;

import linkedlists.ListNode;

import java.util.ArrayDeque;
import java.util.Queue;

/**
 * Created by Sravan on 5/3/16.
 */
public class Solution {

    public ListNode partition(ListNode head, int x) {
        if(head == null) {
            return head;
        }

        ListNode helper1 = new ListNode(0);
        ListNode helper2 = new ListNode(0);
        ListNode p1 = helper1;
        ListNode p2 = helper2;

        while (head != null) {
            if (head.val < x) {
                p1.next = head;
                p1 = p1.next;
            } else {
                p2.next = head;
                p2 = p2.next;
            }
            head = head.next;
        }
        p2.next = null;
        p1.next = helper2.next;

        return helper1.next;

        /*Queue<Integer> queue = new ArrayDeque<Integer>();
        ListNode temp = head;
        while (temp != null) {
            if(temp.val < x) {
                queue.offer(temp.val);
            }
            temp = temp.next;
        }

        temp = head;
        while (temp != null) {
            if(temp.val >= x) {
                queue.offer(temp.val);
            }
            temp = temp.next;
        }

        ListNode partitionedHead = new ListNode(queue.poll());
        temp = partitionedHead;
        while (!queue.isEmpty()) {
            temp.next = new ListNode(queue.poll());
            temp = temp.next;
        }

        return partitionedHead;*/
    }

    public static void main(String... args) {
        Solution solution = new Solution();

        ListNode head = new ListNode(1);
        head.next = new ListNode(4);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(2);
        head.next.next.next.next = new ListNode(5);
        head.next.next.next.next.next = new ListNode(2);

        solution.partition(head, 3);
    }
}
