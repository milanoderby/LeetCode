class Solution {
    public int[] twoSum(int[] numbers, int target) {
        int frontIndex = 0;
        int rearIndex = numbers.length - 1;
        for (int sum = numbers[frontIndex] + numbers[rearIndex]; sum != target; sum = numbers[frontIndex] + numbers[rearIndex]) {
            if (sum < target) {
                frontIndex++;
            } else {
                rearIndex--;
            }
        }

        return new int[]{frontIndex + 1, rearIndex + 1};
    }
}