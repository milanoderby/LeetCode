class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        if (k == 0) {
            return 0;
        }

        int start = 0;

        Map<Integer, Deque<Integer>> numberIndexMap = new HashMap<>();
        PriorityQueue<Number> pq = new PriorityQueue<>(Comparator.comparingInt(Number::getIndex));
        int answer = 0;
        for (int end = 0; end < nums.length; end++) {
            int newNumber = nums[end];
            Deque<Integer> indexDeque = numberIndexMap.getOrDefault(newNumber, new ArrayDeque<>());
            indexDeque.add(end);
            numberIndexMap.put(newNumber, indexDeque);
            Number numberToAdd = new Number(end, newNumber);

            if (pq.contains(numberToAdd)) {
                pq.remove(numberToAdd);
            }
            pq.add(numberToAdd);

            if (numberIndexMap.size() < k) {
                continue;
            }

            if (numberIndexMap.size() > k) {
                Number oldestNumber = pq.poll();
                int indexOfOldest = oldestNumber.getIndex();
                while (start <= indexOfOldest) {
                    int numToRemove = nums[start];
                    Deque<Integer> indexDequeOfNumToRemove = numberIndexMap.get(numToRemove);
                    indexDequeOfNumToRemove.pollFirst();
                    start++;
                }
                numberIndexMap.remove(oldestNumber.getNumber());
            }

            Number oldest = pq.peek();
            int numberOfOldest = oldest.getNumber();
            Deque<Integer> indexDequeOfOldest = numberIndexMap.get(numberOfOldest);
            int lastIndexOfOldest = indexDequeOfOldest.peekLast();

            answer += lastIndexOfOldest - start + 1;
        }
        return answer;
    }
    
    private static class Number {
        private int index;
        private int number;

        public Number(int index, int number) {
            this.index = index;
            this.number = number;
        }

        public int getIndex() {
            return index;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public boolean equals(Object o) {
            if (this == o) {
                return true;
            }
            if (o == null || getClass() != o.getClass()) {
                return false;
            }
            Number number1 = (Number) o;
            return number == number1.number;
        }

        @Override
        public int hashCode() {
            return Objects.hash(number);
        }
    }
}