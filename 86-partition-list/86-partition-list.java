/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode partition(ListNode head, int x) {
        ListNode result = new ListNode();
        result.next = head;

        ListNode front = result;
        ListNode cur = result;

        while (cur.next != null) {
            ListNode next = cur.next;
            if (next.val < x) {
                if (cur == front) {
                    cur = cur.next;
                    front = front.next;
                } else {
                    cur.next = next.next;

                    ListNode temp = front.next;
                    front.next = next;
                    next.next = temp;

                    front = front.next;
                }
            } else {
                cur = cur.next;
            }
        }
        return result.next;
    }
}