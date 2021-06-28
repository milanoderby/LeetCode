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
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
        ListNode answer = new ListNode();
        ListNode temp = answer;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            if (l1.val <= l2.val) {
                temp.next = new ListNode(l1.val);
                l1 = l1.next;
            } else {
                temp.next = new ListNode(l2.val);
                l2 = l2.next;
            }
            temp = temp.next;
        }

        ListNode rest = Objects.nonNull(l1) ? l1 : l2;
        while (Objects.nonNull(rest)) {
            temp.next = new ListNode(rest.val);
            rest = rest.next;

            temp = temp.next;
        }
        return answer.next;
    }
}