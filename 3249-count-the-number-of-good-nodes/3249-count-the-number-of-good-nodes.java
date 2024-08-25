class Solution {
    public int countGoodNodes(int[][] edges) {
        int countOfNode = edges.length + 1;
        List<Integer>[] graph = new List[countOfNode];
        for (int i = 0; i < countOfNode; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];

            graph[src].add(dest);
            graph[dest].add(src);
        }

        boolean[] isVisited = new boolean[countOfNode];
        isVisited[0] = true;
        boolean[] isGoodNode = new boolean[countOfNode];
        for (int i = 0; i < countOfNode; i++) {
            isGoodNode[i] = true;
        }
        countOfChildNode(0, graph, isVisited, isGoodNode);

        int answer = 0;
        for (int i = 0; i < countOfNode; i++) {
            if (isGoodNode[i]) {
                answer++;
            }
        }
        return answer;
    }
    
    private static int countOfChildNode(int nodeNumber, List<Integer>[] graph, boolean[] isVisited, boolean[] isGoodNode) {
        int sumOfChildNode = 0;
        int countOfPreviousChildNode = -1;
        for (Integer nextNode : graph[nodeNumber]) {
            if (isVisited[nextNode]) {
                continue;
            }
            isVisited[nextNode] = true;

            int countOfCurrentChildNode = countOfChildNode(nextNode, graph, isVisited, isGoodNode);
            sumOfChildNode += countOfCurrentChildNode;

            if (countOfPreviousChildNode == -1) {
                countOfPreviousChildNode = countOfCurrentChildNode;
            } else {
                if (countOfPreviousChildNode != countOfCurrentChildNode) {
                    isGoodNode[nodeNumber] = false;
                }
            }
        }
        return sumOfChildNode + 1;
    }
}