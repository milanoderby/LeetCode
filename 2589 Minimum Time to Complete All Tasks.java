class Solution {
    public int findMinimumTime(int[][] tasks) {
        List<Task> taskList = new ArrayList<>();
        for (int[] task : tasks) {
            taskList.add(new Task(task[0], task[1], task[2]));
        }

        Collections.sort(taskList, Comparator.comparingInt(Task::getEndTime).thenComparingInt(Task::getStartTime));

        boolean[] isUsed = new boolean[2001];
        int answer = 0;
        for (Task task : taskList) {
            int runTime = 0;
            for (int time = task.endTime; time >= task.startTime; time--) {
                if (isUsed[time]) {
                    runTime++;
                }
            }

            if (runTime >= task.duration) {
                continue;
            }

            for (int time = task.endTime; runTime < task.duration; time--) {
                if (!isUsed[time]) {
                    isUsed[time] = true;
                    runTime++;

                    answer++;
                }
            }
        }

        return answer;
    }
    
    private static class Task {
        private int startTime;
        private int endTime;
        private int duration;

        public Task(int startTime, int endTime, int duration) {
            this.startTime = startTime;
            this.endTime = endTime;
            this.duration = duration;
        }

        public int getStartTime() {
            return startTime;
        }

        public int getEndTime() {
            return endTime;
        }
    }
}