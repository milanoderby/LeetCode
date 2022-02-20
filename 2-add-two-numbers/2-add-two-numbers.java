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
        ListNode resultNode = new ListNode();
        ListNode tempNode = resultNode;
        int remain = 0;
        while (Objects.nonNull(l1) && Objects.nonNull(l2)) {
            int sum = l1.val + l2.val + remain;
            remain = sum / 10;

            tempNode.next = new ListNode(sum % 10);
            tempNode = tempNode.next;

            l1 = l1.next;
            l2 = l2.next;
        }

        ListNode remainNode = Objects.nonNull(l1) ? l1 : l2;
        while (Objects.nonNull(remainNode)) {
            int sum = remainNode.val + remain;
            remain = sum / 10;

            tempNode.next = new ListNode(sum % 10);
            tempNode = tempNode.next;

            remainNode = remainNode.next;
        }

        if (remain > 0) {
            tempNode.next = new ListNode(remain);
        }
        
        return resultNode.next;
    }
}