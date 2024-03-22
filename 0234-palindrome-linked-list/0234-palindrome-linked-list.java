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
    public boolean isPalindrome(ListNode head) {
        ListNode temp = head;
        int hopCount = 0;
        while (Objects.nonNull(temp.next)) {
            hopCount++;
            temp = temp.next;
        }

        if (hopCount <= 0) {
            return true;
        }

        ListNode rightHalfNode = head;
        for (int i = 0; i < hopCount/2 + 1; i++) {
            rightHalfNode = rightHalfNode.next;
        }

        ListNode prevNode = null;
        ListNode leftHalfNode = head;
        for (int i = 0; i < (hopCount-1) / 2; i++) {
            ListNode nextNode = leftHalfNode.next;
            leftHalfNode.next = prevNode;

            prevNode = leftHalfNode;
            leftHalfNode = nextNode;
        }
        leftHalfNode.next = prevNode;

        while (Objects.nonNull(leftHalfNode)) {
            if (leftHalfNode.val != rightHalfNode.val) {
                return false;
            }
            leftHalfNode = leftHalfNode.next;
            rightHalfNode = rightHalfNode.next;
        }
        return true;
    }
}