/**
 * Definition for singly-linked list.
 * class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode(int x) {
 *         val = x;
 *         next = null;
 *     }
 * }
 */
public class Solution {
    public boolean hasCycle(ListNode head) {
        Set<ListNode> listNodeSet = new HashSet<>();
        ListNode temp = head;
        while (Objects.nonNull(temp)) {
            if (listNodeSet.contains(temp)) {
                return true;
            }

            listNodeSet.add(temp);
            temp = temp.next;
        }
        return false;
    }
}