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
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null) {
            return null;
        }
        
        int sizeOfListNode = 0;
        ListNode temp = head;
        while (temp != null) {
            sizeOfListNode++;
            temp = temp.next;
        }

        k %= sizeOfListNode;
        temp = head;
        for (int i = 0; i < sizeOfListNode - k - 1; i++) {
            temp = temp.next;
        }
        ListNode newLastNode = temp;

        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = head;
        ListNode newFirstNode = newLastNode.next;
        newLastNode.next = null;

        return newFirstNode;
    }
}