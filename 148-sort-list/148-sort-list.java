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
    public ListNode sortList(ListNode head) {
        if (head == null || head.next == null) {
            return head;
        }

        ListNode dummyHead = new ListNode();
        ListNode start = head;
        int sizeOfListNode = countSizeOfListNode(head);
        for (int size = 1; size < sizeOfListNode; size *= 2) {
            ListNode tail = dummyHead;

            while (start != null) {
                ListNode mid = splitListNode(start, size);
                ListNode nextSubList = getNextSubListNode(mid, size);
                tail = mergeListNode(tail, start, mid, nextSubList);
                start = nextSubList;
            }
            start = dummyHead.next;
        }
        return dummyHead.next;
    }
    
    private static int countSizeOfListNode(ListNode head) {
        int sizeOfListNode = 0;
        ListNode temp = head;
        while (temp != null) {
            sizeOfListNode++;
            temp = temp.next;
        }
        return sizeOfListNode;
    }

    private static ListNode splitListNode(ListNode start, int size) {
        ListNode mid = start;
        for (int i = 0; i < size; i++) {
            mid = mid.next;
            if (mid == null) {
                break;
            }
        }
        return mid;
    }

    private static ListNode getNextSubListNode(ListNode mid, int size) {
        ListNode nextSubList = mid;
        for (int i = 0; i < size; i++) {
            if (nextSubList == null) {
                break;
            }
            nextSubList = nextSubList.next;
        }
        return nextSubList;
    }

    private static ListNode mergeListNode(ListNode tail, ListNode start, ListNode mid, ListNode nextSubList) {
        if (mid == null) {
            tail.next = start;
            return null;
        }

        ListNode dummyHead = new ListNode();
        ListNode dummyHeadTail = dummyHead;

        ListNode temp1 = start;
        ListNode temp2 = mid;
        while (temp1 != mid && temp2 != nextSubList) {
            if (temp1.val <= temp2.val) {
                dummyHeadTail.next = temp1;
                temp1 = temp1.next;
            } else {
                dummyHeadTail.next = temp2;
                temp2 = temp2.next;
            }
            dummyHeadTail = dummyHeadTail.next;
        }

        if (temp1 == mid) {
            while (temp2 != nextSubList) {
                dummyHeadTail.next = temp2;
                dummyHeadTail = dummyHeadTail.next;
                temp2 = temp2.next;
            }
        } else {
            while (temp1 != mid) {
                dummyHeadTail.next = temp1;
                dummyHeadTail = dummyHeadTail.next;
                temp1 = temp1.next;
            }
        }
        tail.next = dummyHead.next;

        dummyHeadTail.next = null;
        return dummyHeadTail;
    }
}