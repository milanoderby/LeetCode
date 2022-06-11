
// Definition for a Node.
/*
class Node {
    public int val;
    public List<Node> neighbors;
    public Node() {
        val = 0;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val) {
        val = _val;
        neighbors = new ArrayList<Node>();
    }
    public Node(int _val, ArrayList<Node> _neighbors) {
        val = _val;
        neighbors = _neighbors;
    }
}
*/

class Solution {
    public Node cloneGraph(Node node) {
        if (node == null) {
            return null;
        }

        Set<Integer> isVisited = new HashSet<>();
        Queue<Node> graphNodeQueue = new ArrayDeque<>();

        isVisited.add(node.val);
        graphNodeQueue.add(node);

        Node newRoot = new Node(node.val);
        Queue<Node> newGraphNodeQueue = new ArrayDeque<>();
        newGraphNodeQueue.add(newRoot);

        Map<Integer, Node> indexGraphNodeMap = new HashMap<>();
        indexGraphNodeMap.put(node.val, newRoot);

        while (!graphNodeQueue.isEmpty()) {
            Node cur = graphNodeQueue.poll();
            Node copied = newGraphNodeQueue.poll();
            for (Node next : cur.neighbors) {
                if (!isVisited.contains(next.val)) {
                    isVisited.add(next.val);
                    graphNodeQueue.add(next);

                    Node newNode = new Node(next.val);
                    copied.neighbors.add(newNode);

                    newGraphNodeQueue.add(newNode);
                    indexGraphNodeMap.put(next.val, newNode);
                } else {
                    Node nodeToAdd = indexGraphNodeMap.get(next.val);
                    copied.neighbors.add(nodeToAdd);
                }
            }
        }

        return newRoot;
    }
}