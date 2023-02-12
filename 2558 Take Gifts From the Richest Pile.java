class Solution {
    public long pickGifts(int[] gifts, int k) {
        PriorityQueue<Integer> priorityQueue = new PriorityQueue<>(Comparator.reverseOrder());
        for (int gift : gifts) {
            priorityQueue.add(gift);
        }

        for (int i = 0; i < k; i++) {
            int number = priorityQueue.poll();

            int leftNumber = (int) Math.floor(Math.sqrt(number));
            priorityQueue.add(leftNumber);
        }

        long answer = 0;
        for (Integer number : priorityQueue) {
            answer += number;
        }
        return answer;
    }
}