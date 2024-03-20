class Solution {
    public int leastInterval(char[] tasks, int n) {
        // 현재 cycle 에서 실행가능한 Task 중 갯수가 가장 많이 남은 Task를 실행합니다.
        // 현재, 실행가능한 Task을 판단하는 여부: (최근 실행시점과 현재시점과의 차이) >= n일 경우, 실행 가능

        int[] numberOfTask = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            int task = tasks[i] - 'A';
            numberOfTask[task]++;
        }

        // 모든 Task는 n cycle 이전에 처리되었다고 초기화
        // 즉, 최초 시점인 1초에는 모든 Task를 실행할 수 있도록 초기화
        int[] timeOfTaskCompleted = new int[26];
        for (int i = 0; i < 26; i++) {
            timeOfTaskCompleted[i] = -1 * n;
        }

        int sumOfTask = tasks.length;
        int currentTime;
        for (currentTime = 1; sumOfTask > 0; currentTime++) {
            int completableTask = -1;
            int maxNumberOfTask = -1;
            for (int i = 0; i < 26; i++) {
                if (numberOfTask[i] <= 0) {
                    continue;
                }

                if (currentTime - timeOfTaskCompleted[i] <= n) {
                    continue;
                }

                if (maxNumberOfTask < numberOfTask[i]) {
                    maxNumberOfTask = numberOfTask[i];
                    completableTask = i;
                }
            }

            if (completableTask != -1) {
                numberOfTask[completableTask]--;
                sumOfTask--;

                timeOfTaskCompleted[completableTask] = currentTime;
            }
        }
        return currentTime - 1;
    }
}