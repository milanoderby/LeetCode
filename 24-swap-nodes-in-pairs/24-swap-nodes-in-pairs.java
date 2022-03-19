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
    public ListNode swapPairs(ListNode head) {
        if (Objects.isNull(head) || Objects.isNull(head.next)) {
            return head;
        }

        ListNode prev = new ListNode();
        ListNode cur = head;
        
        ListNode newHead = head.next;
        while (Objects.nonNull(cur)) {
            ListNode next = cur.next;
            if (Objects.isNull(next)) {
                break;
            }

            ListNode temp = next.next;

            prev.next = next;
            next.next = cur;
            cur.next = temp;

            prev = cur;
            cur = cur.next;
        }
        return newHead;
    }
}