/*
// Definition for a Node.
class Node {
    int val;
    Node next;
    Node random;

    public Node(int val) {
        this.val = val;
        this.next = null;
        this.random = null;
    }
}
*/

class Solution {
    public Node copyRandomList(Node head) {
        Node temp = head;
        while (temp != null) {
            Node newNode = new Node(temp.val);
            Node next = temp.next;

            temp.next = newNode;
            newNode.next = next;

            temp = next;
        }

        temp = head;
        while (temp != null) {
            Node copiedNode = temp.next;
            if (temp.random == null) {
                copiedNode.random = null;
            } else {
                copiedNode.random = temp.random.next;
            }
            temp = copiedNode.next;
        }

        temp = head;
        Node answer = new Node(0);
        Node copiedTemp = answer;
        while (temp != null) {
            Node copiedNode = temp.next;
            copiedTemp.next = copiedNode;

            copiedTemp = copiedTemp.next;
            temp.next = copiedNode.next;
            temp = temp.next;
        }
        return answer.next;
    }
}