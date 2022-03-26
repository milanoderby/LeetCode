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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode temp = head;
        for (int i = 0; i < n - 1; i++) {
            temp = temp.next;
        }

        ListNode prevNode = head;
        ListNode nthFromEnd = head;
        boolean targetIsFirstNode = true;
        while (Objects.nonNull(temp.next)) {
            if (targetIsFirstNode) {
                targetIsFirstNode = false;
            } else {
                prevNode = prevNode.next;
            }

            temp = temp.next;
            nthFromEnd = nthFromEnd.next;
        }

        if (targetIsFirstNode) {
            return head.next;
        }

        ListNode nextNode = nthFromEnd.next;
        prevNode.next = nextNode;
        return head;
    }
}