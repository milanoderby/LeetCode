class Solution {
    public int[] getOrder(int[][] tasks) {
        List<Task> taskList = new ArrayList<>();
        for (int i = 0; i < tasks.length; i++) {
            taskList.add(new Task(i, tasks[i][0], tasks[i][1]));
        }
        taskList.sort(Comparator.comparingInt(Task::getEnqueueTime));

        Queue<Task> waitingQueue = new ArrayDeque<>(taskList);
        PriorityQueue<Task> jobQueue = new PriorityQueue<>(
            Comparator.comparingInt(Task::getProcessingTime).thenComparingInt(Task::getIndex));
        List<Task> completedTaskList = new ArrayList<>();
        int currentTime = 0;
        while (completedTaskList.size() < tasks.length) {
            // waitingQueue에 있는 Task 중 enqueueTime이 currentTime 보다 지난 것을 jobQueue로 이동합니다.
            while (!waitingQueue.isEmpty()) {
                Task waitingTask = waitingQueue.peek();
                if (waitingTask.getEnqueueTime() <= currentTime) {
                    waitingQueue.poll();
                    jobQueue.add(waitingTask);
                } else {
                    break;
                }
            }

            // jobQueue에서 꺼내 수행할 Task가 없다면, 시간을 waitingQueue에 있는 첫번째 Task로 바꿉니다.
            if (jobQueue.isEmpty()) {
                currentTime = waitingQueue.peek().getEnqueueTime();
                continue;
            }

            // jobQueue에서 꺼내 수행할 Task가 있다면, 꺼내어 수행합니다.
            Task processingTask = jobQueue.poll();
            currentTime += processingTask.getProcessingTime();
            completedTaskList.add(processingTask);
        }

        int[] result = completedTaskList.stream().mapToInt(Task::getIndex).toArray();
        return result;
    }
    
    private static class Task {

        private int index;
        private int enqueueTime;
        private int processingTime;

        public Task(int index, int enqueueTime, int processingTime) {
            this.index = index;
            this.enqueueTime = enqueueTime;
            this.processingTime = processingTime;
        }

        public int getIndex() {
            return index;
        }

        public int getEnqueueTime() {
            return enqueueTime;
        }

        public int getProcessingTime() {
            return processingTime;
        }
    }
}