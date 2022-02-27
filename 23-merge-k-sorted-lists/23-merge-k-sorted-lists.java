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
    public ListNode mergeKLists(ListNode[] lists) {
        PriorityQueue<ListNode> smallNumber = new PriorityQueue<>(Comparator.comparingInt(listNode -> listNode.val));
        for (ListNode listNode : lists) {
            if (Objects.isNull(listNode)) {
                continue;
            }
            smallNumber.add(listNode);
        }

        ListNode resultNode = new ListNode();
        ListNode tempNode = resultNode;
        while (!smallNumber.isEmpty()) {
            ListNode cur = smallNumber.poll();
            ListNode next = cur.next;
            if (Objects.nonNull(next)) {
                smallNumber.add(next);
            }
            tempNode.next = cur;
            tempNode = tempNode.next;
        }

        return resultNode.next;
    }
}