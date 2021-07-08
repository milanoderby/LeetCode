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
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
        int carry = 0;
        ListNode answer = new ListNode();
        ListNode temp = answer;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            int value = (l1.val + l2.val + carry) % 10;
            carry = (l1.val + l2.val + carry) / 10;
            temp.next = new ListNode(value);
            temp = temp.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode nonNullListNode = Objects.nonNull(l1) ? l1 : l2;
        while (Objects.nonNull(nonNullListNode)) {
            int value = (nonNullListNode.val + carry) % 10;
            carry = (nonNullListNode.val + carry) / 10;
            temp.next = new ListNode(value);
            temp = temp.next;

            nonNullListNode = nonNullListNode.next;
        }

        if (carry == 1) {
            temp.next = new ListNode(carry);
        }

        return answer.next;
    }
}