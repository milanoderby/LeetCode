class Solution {
    public int findTheLongestBalancedSubstring(String s) {
        int answer = 0;

        int lengthOfBalanceString = 0;
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            int prevNumber = i == 0 ? -1 : s.charAt(i - 1) - '0';
            int currentNumber = s.charAt(i) - '0';

            if (prevNumber == 0 && currentNumber == 0) {
                stack.push(currentNumber);
            } else if (prevNumber == 0 && currentNumber == 1) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    lengthOfBalanceString++;
                    answer = Math.max(answer, lengthOfBalanceString);
                }
            } else if (prevNumber == 1 && currentNumber == 0) {
                stack = new Stack<>();
                lengthOfBalanceString = 0;
                stack.push(currentNumber);
            } else if (prevNumber == 1 && currentNumber == 1) {
                if (!stack.isEmpty()) {
                    stack.pop();
                    lengthOfBalanceString++;
                    answer = Math.max(answer, lengthOfBalanceString);
                }
            } else {
                if (currentNumber == 0) {
                    stack.push(currentNumber);
                }
            }
        }
        return 2 * answer;
    }
}