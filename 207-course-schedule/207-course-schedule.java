class Solution {
    public boolean canFinish(int numCourses, int[][] prerequisites) {
        List<Integer>[] graph = new List[numCourses];
        for (int i = 0; i < graph.length; i++) {
            graph[i] = new ArrayList<>();
        }

        // 진입차수를 저장하는 배열
        int[] countOfDegree = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int source = prerequisite[1];
            int destination = prerequisite[0];

            graph[source].add(destination);
            countOfDegree[destination]++;
        }

        int countOfFinishedCourse = 0;
        Queue<Integer> nodeQueue = new ArrayDeque<>();
        boolean[] isVisited = new boolean[numCourses];
        for (int nodeNum = 0; nodeNum < countOfDegree.length; nodeNum++) {
            if (countOfDegree[nodeNum] == 0) {
                nodeQueue.add(nodeNum);
                isVisited[nodeNum] = true;
                countOfFinishedCourse++;
            }
        }

        while (!nodeQueue.isEmpty()) {
            int currentNode = nodeQueue.poll();
            for (Integer nextNode : graph[currentNode]) {
                if (isVisited[nextNode]) {
                    continue;
                }

                countOfDegree[nextNode]--;
                if (countOfDegree[nextNode] == 0) {
                    nodeQueue.add(nextNode);
                    isVisited[nextNode] = true;
                    countOfFinishedCourse++;
                }
            }
        }

        return countOfFinishedCourse == numCourses;
    }
}