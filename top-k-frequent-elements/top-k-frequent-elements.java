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

        NumberCount[] numberCountArray = countOfNumber.values().toArray(new NumberCount[countOfNumber.size()]);
        Arrays.sort(numberCountArray, Comparator.comparingInt(NumberCount::getCount).reversed());

        int[] answer = new int[k];
        for (int i = 0; i < numberCountArray.length; i++) {
            if (i == k) {
                break;
            }

            answer[i] = numberCountArray[i].getNum();
        }
        return answer;
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