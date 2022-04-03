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
    public ListNode reverseKGroup(ListNode head, int k) {
        int countOfNode = 0;
        ListNode temp = head;
        while (Objects.nonNull(temp)) {
            countOfNode++;
            temp = temp.next;
        }

        int countOfLoop = countOfNode / k;

        ListNode cur = head;
        ListNode lastNodeOfPrevLoop = null;
        ListNode newHead = null;
        for (int i = 0; i < countOfLoop; i++) {
            ListNode prev = null;
            ListNode lastNodeOfCurLoop = cur;
            for (int j = 0; j < k; j++) {
                ListNode next = cur.next;
                cur.next = prev;

                prev = cur;
                cur = next;
            }

            if (Objects.nonNull(lastNodeOfPrevLoop)) {
                lastNodeOfPrevLoop.next = prev;
            }

            if (Objects.isNull(newHead)) {
                newHead = prev;
            }

            lastNodeOfPrevLoop = lastNodeOfCurLoop;
        }
        lastNodeOfPrevLoop.next = cur;

        return newHead;
    }
}