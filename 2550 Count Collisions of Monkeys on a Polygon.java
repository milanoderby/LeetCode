class Solution {
    // 2^n - 2 를 구하는 문제 (단, 3 <= n <= 109)
    public int monkeyMove(int n) {
        int divisor = 1_000_000_007;
        String binary = Integer.toBinaryString(n);

        long answer = 1;
        long squareOfTwo = 2;
        for (int i = binary.length() - 1; i >= 0; i--) {
            if (binary.charAt(i) == '1') {
                answer *= squareOfTwo;
                answer %= divisor;
            }
            squareOfTwo *= squareOfTwo;
            squareOfTwo %= divisor;
        }
        return (int) ((answer - 2 + divisor) % divisor);
    }
}