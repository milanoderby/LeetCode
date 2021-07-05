class Solution {
    public int[] countBits(int n) {
        int[] answer = new int[n + 1];
        for (int i = 0; i <= n; i++) {
            int prevBitNum = i / 2;
            answer[i] = answer[prevBitNum] + (i % 2);
        }
        return answer;
    }
}