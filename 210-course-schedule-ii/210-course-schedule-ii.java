class Solution {
    public int[] findOrder(int numCourses, int[][] prerequisites) {
        List<Integer> courseOrder = new ArrayList<>();
        List<Integer>[] courseGraph = new List[numCourses];
        for (int i = 0; i < courseGraph.length; i++) {
            courseGraph[i] = new ArrayList<>();
        }

        int[] countOfPreCourse = new int[numCourses];
        for (int[] prerequisite : prerequisites) {
            int course = prerequisite[0];
            int preCourse = prerequisite[1];

            courseGraph[preCourse].add(course);
            countOfPreCourse[course]++;
        }

        Queue<Integer> courseQueue = new ArrayDeque<>();
        for (int course = 0; course < numCourses; course++) {
            if (countOfPreCourse[course] == 0) {
                courseQueue.add(course);
                courseOrder.add(course);
            }
        }

        while (!courseQueue.isEmpty()) {
            int preCourse = courseQueue.poll();
            for (Integer nextCourse : courseGraph[preCourse]) {
                countOfPreCourse[nextCourse]--;
                if (countOfPreCourse[nextCourse] == 0) {
                    courseQueue.add(nextCourse);
                    courseOrder.add(nextCourse);
                }
            }
        }

        return courseOrder.size() == numCourses ? courseOrder.stream().mapToInt(
            Integer::intValue).toArray()
            : new int[]{};
    }
}