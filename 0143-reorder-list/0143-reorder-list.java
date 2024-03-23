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
    public void reorderList(ListNode head) {
        ListNode tempNode = head;
        int hopCount = 0;
        while (Objects.nonNull(tempNode.next)) {
            hopCount++;
            tempNode = tempNode.next;
        }

        if (hopCount <= 1) {
            return;
        }

        ListNode leftNode = head;
        ListNode rightNode = head;
        for (int i = 0; i < hopCount / 2 + hopCount % 2; i++) {
            rightNode = rightNode.next;
        }

        ListNode prevNode = null;
        ListNode nextNode = null;
        while (Objects.nonNull(rightNode.next)) {
            nextNode = rightNode.next;

            rightNode.next = prevNode;

            prevNode = rightNode;
            rightNode = nextNode;
        }
        rightNode.next = prevNode;

        for (int i = 0; i < hopCount / 2; i++) {
            ListNode nextLeft = leftNode.next;
            ListNode nextRight = rightNode.next;

            leftNode.next = rightNode;
            rightNode.next = nextLeft;

            leftNode = nextLeft;
            rightNode = nextRight;
        }
    }
}