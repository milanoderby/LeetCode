class Solution {
    public int countCompleteComponents(int n, int[][] edges) {
        List<Integer>[] graph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
        }

        for (int[] edge : edges) {
            int src = edge[0];
            int dest = edge[1];

            graph[src].add(dest);
            graph[dest].add(src);
        }

        boolean[] isVisitedVertex = new boolean[n];
        int[] groupOfVertex = new int[n];
        int groupNumber = 0;
        List<Integer>[] group = new List[n];
        for (int i = 0; i < n; i++) {
            group[i] = new ArrayList<>();
        }

        for (int vertex = 0; vertex < n; vertex++) {
            if (isVisitedVertex[vertex]) {
                continue;
            }

            Queue<Integer> visitedQueue = new ArrayDeque<>();
            visitedQueue.add(vertex);
            isVisitedVertex[vertex] = true;
            groupOfVertex[vertex] = groupNumber;
            group[groupNumber].add(vertex);
            while (!visitedQueue.isEmpty()) {
                int cur = visitedQueue.poll();
                for (Integer next : graph[cur]) {
                    if (isVisitedVertex[next]) {
                        continue;
                    }

                    visitedQueue.add(next);
                    isVisitedVertex[next] = true;
                    groupOfVertex[next] = groupNumber;
                    group[groupNumber].add(next);
                }
            }

            groupNumber++;
        }

        int[] countOfEdgesOfGroup = new int[groupNumber];
        for (int[] edge : edges) {
            int src = edge[0];
            int groupOfSrc = groupOfVertex[src];
            countOfEdgesOfGroup[groupOfSrc]++;
        }

        int answer = 0;
        for (int i = 0; i < groupNumber; i++) {
            if (group[i].size() * (group[i].size() - 1) / 2 == countOfEdgesOfGroup[i]) {
                answer++;
            }
        }
        return answer;
    }
}