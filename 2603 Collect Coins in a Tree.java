class Solution {
    public int collectTheCoins(int[] coins, int[][] edges) {
        int[] degreeOfVertex = new int[coins.length];
        List<Integer>[] tree = new List[coins.length];
        for (int i = 0; i < coins.length; i++) {
            tree[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int vertex1 = edge[0];
            int vertex2 = edge[1];

            tree[vertex1].add(vertex2);
            tree[vertex2].add(vertex1);

            degreeOfVertex[vertex1]++;
            degreeOfVertex[vertex2]++;
        }

        // leafVertex 에서 시작
        Queue<Integer> vertexQueue = new ArrayDeque<>();
        boolean[] isRemovedLeaf = new boolean[coins.length];
        for (int vertex = 0; vertex < degreeOfVertex.length; vertex++) {
            if (degreeOfVertex[vertex] == 1) {
                vertexQueue.add(vertex);
            }
        }

        // coin이 있는 leafNode만 구합니다.
        List<Integer> coinLeafVertex = new ArrayList<>();
        while (!vertexQueue.isEmpty()) {
            int cur = vertexQueue.poll();
            // coin이 있는 leafNode
            if (coins[cur] == 1) {
                coinLeafVertex.add(cur);
                continue;
            }

            // coin이 없는 leafNode
            isRemovedLeaf[cur] = true;
            for (Integer next : tree[cur]) {
                // 현재 coin이 없는 leafNode와 연결된 부모노드를 새롭게 탐색합니다.
                degreeOfVertex[next]--;
                if (degreeOfVertex[next] == 1) {
                    vertexQueue.add(next);
                }
            }
        }

        // coin이 있는 leafNode는 거리를 0으로 표시합니다.
        // coin이 없는 leafNode는 거리를 MAX_VALUE로 표시합니다.
        int[] distanceFromCoin = new int[coins.length];
        Arrays.fill(distanceFromCoin, -1);

        boolean[] isVisited = new boolean[coins.length];
        for (Integer leafVertex : coinLeafVertex) {
            isVisited[leafVertex] = true;
            distanceFromCoin[leafVertex] = 0;
        }

        Queue<Integer> coinLeafQueue = new ArrayDeque<>(coinLeafVertex);
        while (!coinLeafQueue.isEmpty()) {
            int cur = coinLeafQueue.poll();
            for (Integer next : tree[cur]) {
                if (isRemovedLeaf[next]) {
                    continue;
                }

                if (isVisited[next]) {
                    continue;
                }

                if (distanceFromCoin[next] == -1) {
                    distanceFromCoin[next] = distanceFromCoin[cur] + 1;
                } else {
                    distanceFromCoin[next] = Math.max(distanceFromCoin[next], distanceFromCoin[cur] + 1);
                }

                degreeOfVertex[next]--;
                if (degreeOfVertex[next] == 1) {
                    isVisited[next] = true;
                    coinLeafQueue.add(next);
                }
            }
        }

        int countOfNodeToVisit = 0;
        for (int i = 0; i < distanceFromCoin.length; i++) {
            if (distanceFromCoin[i] >= 2) {
                countOfNodeToVisit++;
            }
        }

        return Math.max(0, 2 * (countOfNodeToVisit - 1));
    }
}