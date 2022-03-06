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
        ListNode reverseList = null;
        ListNode cur = head;

        while (Objects.nonNull(cur)) {
            ListNode temp = reverseList;
            reverseList = new ListNode(cur.val, temp);

            cur = cur.next;
        }

        ListNode index1 = head;
        ListNode index2 = reverseList;
        while (Objects.nonNull(index1)) {
            if (index1.val != index2.val) {
                return false;
            }

            index1 = index1.next;
            index2 = index2.next;
        }
        return true;
    }
}