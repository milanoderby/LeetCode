class Solution {
    public int[] twoSum(int[] nums, int target) {
        List<Number> numbers = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            numbers.add(new Number(i, nums[i]));
        }

        Collections.sort(numbers, new NumberComparator());
        int first = 0;
        int last = numbers.size() - 1;

        int[] answer = new int[2];
        while (first < last) {
            int sum = numbers.get(first).number + numbers.get(last).number;
            if (sum < target) {
                first++;
            } else if(sum == target) {
                answer[0] = numbers.get(first).originIndex;
                answer[1] = numbers.get(last).originIndex;
                break;
            } else {
                last--;
            }
        }
        return answer;
    }
    
    private static class Number {
        private int originIndex;
        private int number;

        public Number(int originIndex, int number) {
            this.originIndex = originIndex;
            this.number = number;
        }
    }

    private static class NumberComparator implements Comparator<Number> {

        @Override
        public int compare(Number n1, Number n2) {
            return n1.number - n2.number;
        }
    }
}