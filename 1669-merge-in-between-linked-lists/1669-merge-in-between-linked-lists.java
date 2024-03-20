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
    public ListNode mergeInBetween(ListNode list1, int a, int b, ListNode list2) {
        int index = 0;
        ListNode beforeList2 = list1, afterList2;
        ListNode temp = list1;
        for ( ; index < b + 1; index++) {
            if (index == a - 1) {
                beforeList2 = temp;
            }
            temp = temp.next;
        }
        afterList2 = temp;

        temp = list2;
        while (Objects.nonNull(temp.next)) {
            temp = temp.next;
        }
        ListNode lastOfList2 = temp;
        ListNode firstOfList2 = list2;

        beforeList2.next = firstOfList2;
        lastOfList2.next = afterList2;

        return list1;
    }
}