/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public ListNode getIntersectionNode(ListNode headA, ListNode headB) {
        Set<ListNode> listNodeSet = new HashSet<>();
        ListNode temp = headA;
        while (Objects.nonNull(temp)) {
            listNodeSet.add(temp);
            temp = temp.next;
        }

        temp = headB;
        while (Objects.nonNull(temp)) {
            if (listNodeSet.contains(temp)) {
                return temp;
            }
            temp = temp.next;
        }
        return null;
    }
}