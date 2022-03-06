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
        int numberOfNodes = 0;
        ListNode temp = head;
        while (Objects.nonNull(temp)) {
            numberOfNodes++;
            temp = temp.next;
        }

        ListNode prev = head;
        ListNode next = head.next;
        prev.next = null;
        
        int count = 1;
        while (Objects.nonNull(next) && count < numberOfNodes / 2 + numberOfNodes % 2) {
            temp = next.next;
            next.next = prev;

            prev = next;
            next = temp;

            count++;
        }
        
        if (numberOfNodes % 2 == 1) {
            prev = prev.next;
        }
        
        while (Objects.nonNull(next)) {
            if (prev.val != next.val) {
                return false;
            }
            prev = prev.next;
            next = next.next;
        }
        return true;
    }
}