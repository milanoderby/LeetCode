class Solution {
    public int[] maxSlidingWindow(int[] nums, int k) {
        List<Integer> answer = new ArrayList<>();
        ArrayDeque<Number> maximumDeque = new ArrayDeque<>();
        for (int index = 0; index < nums.length; index++) {
            Number newNumber = new Number(index, nums[index]);
            while (!maximumDeque.isEmpty()) {
                Number lastNumber = maximumDeque.peekLast();
                if (lastNumber.number > newNumber.number) {
                    break;
                }
                maximumDeque.pollLast();
            }
            maximumDeque.addLast(newNumber);

            Number firstNumber = maximumDeque.peekFirst();
            if (firstNumber.index <= index - k) {
                maximumDeque.pollFirst();
            }

            Number maxNumber = maximumDeque.peekFirst();

            if (k - 1 <= index) {
                answer.add(maxNumber.number);
            }
        }

        return answer.stream().mapToInt(Integer::intValue).toArray();
    }
    
    private static class Number {

        private int index;
        private int number;

        public Number(int index, int number) {
            this.index = index;
            this.number = number;
        }
    }
}