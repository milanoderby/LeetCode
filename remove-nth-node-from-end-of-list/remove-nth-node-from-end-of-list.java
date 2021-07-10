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
    public ListNode removeNthFromEnd(ListNode head, int n) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode temp = head;
        while (Objects.nonNull(temp)) {
            listNodes.add(temp);
            temp = temp.next;
        }

        int nodeIndexToBeRemoved = listNodes.size() - n;
        if (nodeIndexToBeRemoved == 0) {
            head = head.next;
        } else {
            ListNode nodeToBeRemoved = listNodes.get(nodeIndexToBeRemoved);
            ListNode prevnode = listNodes.get(nodeIndexToBeRemoved - 1);
            prevnode.next = nodeToBeRemoved.next;
        }

        return head;
    }
}