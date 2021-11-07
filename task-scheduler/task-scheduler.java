class Solution {
    public int leastInterval(char[] tasks, int n) {
        int[] countOfTasks = new int[26];
        for (int i = 0; i < tasks.length; i++) {
            int charNum = tasks[i] - 'A';
            countOfTasks[charNum]++;
        }

        Arrays.sort(countOfTasks);
        for (int i = 0; i < countOfTasks.length / 2; i++) {
            int temp = countOfTasks[i];
            countOfTasks[i] = countOfTasks[countOfTasks.length - i -1];
            countOfTasks[countOfTasks.length - i -1] = temp;
        }
        int maxTask = countOfTasks[0];

        int countOfMaxTask = 0;
        for (int i = 0; i < countOfTasks.length - 1; i++) {
            if (countOfTasks[i] == maxTask) {
                countOfMaxTask++;
            }
        }

        int answer = (maxTask - 1) * (n + 1);
        answer += countOfMaxTask;
        answer = Math.max(tasks.length, answer);
        return answer;
    }
}