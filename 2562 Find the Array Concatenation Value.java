class Solution {
    public long findTheArrayConcVal(int[] nums) {
        ArrayDeque<String> queue = new ArrayDeque<>();
        for (int num : nums) {
            queue.add(String.valueOf(num));
        }

        long answer = 0;
        while (true) {
            if (queue.isEmpty()) {
                break;
            }
            StringBuilder value = new StringBuilder(queue.pollFirst());

            if (queue.isEmpty()) {
                answer += Integer.parseInt(value.toString());
                break;
            }

            value.append(queue.pollLast());
            answer += Integer.parseInt(value.toString());
        }
        return answer;
    }
}