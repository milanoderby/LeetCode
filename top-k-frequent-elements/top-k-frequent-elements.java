import java.util.*;
class Solution {
    public int[] topKFrequent(int[] nums, int k) {
        Map<Integer, NumberCount> countOfNumber = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            int number = nums[i];
            NumberCount numberCount = countOfNumber.getOrDefault(number, new NumberCount(number, 0));
            numberCount.count++;
            countOfNumber.put(number, numberCount);
        }

        int[] kMostFrequentNumbers = countOfNumber.values().stream()
                .sorted(Comparator.comparingInt(NumberCount::getCount).reversed())
                .map(NumberCount::getNum)
                .limit(k)
                .mapToInt(Integer::intValue)
                .toArray();
        return kMostFrequentNumbers;
    }
    
    private static class NumberCount {
        private int num;
        private int count;

        public NumberCount(int num, int count) {
            this.num = num;
            this.count = count;
        }

        public int getNum() {
            return num;
        }

        public int getCount() {
            return count;
        }
    }
}