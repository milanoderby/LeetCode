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
        ListNode smallNumNode = new ListNode();
        ListNode bigNumNode = new ListNode();

        ListNode s = smallNumNode;
        ListNode b = bigNumNode;

        ListNode temp = head;
        while (Objects.nonNull(temp)) {
            if (temp.val < x) {
                s.next = new ListNode(temp.val);
                s = s.next;
            } else {
                b.next = new ListNode(temp.val);
                b = b.next;
            }
            temp = temp.next;
        }

        s.next = bigNumNode.next;
        return smallNumNode.next;
    }
}