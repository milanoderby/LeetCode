class Solution {
    public int findSmallestInteger(int[] nums, int value) {
        int[] countOfRemainder = new int[value];

        for (int num : nums) {
            if (num >= 0) {
                countOfRemainder[num % value]++;
            } else {
                num = -(-num % value) + value;
                countOfRemainder[num % value]++;
            }
        }

        int minimumCountOfNumber = Integer.MAX_VALUE;
        for (int num = 0; num < value; num++) {
            minimumCountOfNumber = Math.min(minimumCountOfNumber, countOfRemainder[num]);
        }

        int answer = minimumCountOfNumber * value;
        for (int num = 0; num < value; num++) {
            countOfRemainder[num] -= minimumCountOfNumber;
        }

        for (int num = 0; num < value; num++) {
            if (countOfRemainder[num] == 0) {
                answer += num;
                break;
            }
        }
        return answer;
    }
}