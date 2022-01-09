class Solution {
    public int minReorder(int n, int[][] connections) {
        List<Integer>[] graph = new List[n];
        List<Integer>[] reverseGraph = new List[n];
        for (int i = 0; i < n; i++) {
            graph[i] = new ArrayList<>();
            reverseGraph[i] = new ArrayList<>();
        }

        for (int i = 0; i < n - 1; i++) {
            int src = connections[i][0];
            int dest = connections[i][1];

            graph[src].add(dest);
            reverseGraph[dest].add(src);
        }

        int numOfEdgeChanged = 0 ;

        Queue<Integer> cityQueue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[n];
        cityQueue.add(0);
        isVisited[0] = true;
        while (!cityQueue.isEmpty()) {
            int currentCity = cityQueue.poll();
            for (Integer nextCity : graph[currentCity]) {
                if (!isVisited[nextCity]) {
                    isVisited[nextCity] = true;
                    cityQueue.add(nextCity);
                    
                    numOfEdgeChanged++;
                }
            }

            for (Integer nextCity : reverseGraph[currentCity]) {
                if (!isVisited[nextCity]) {
                    isVisited[nextCity] = true;
                    cityQueue.add(nextCity);
                }
            }
        }
        return numOfEdgeChanged;
    }
}