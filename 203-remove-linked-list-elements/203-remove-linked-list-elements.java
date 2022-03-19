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
    public ListNode removeElements(ListNode head, int val) {
        while (Objects.nonNull(head)) {
            if (head.val == val) {
                head = head.next;
            } else {
                break;
            }
        }

        ListNode temp = head;
        while (Objects.nonNull(temp)) {
            ListNode next = temp.next;
            if (Objects.isNull(next)) {
                break;
            }

            if (next.val == val) {
                temp.next = next.next;
            } else {
                temp = temp.next;
            }
        }
        return head;
    }
}