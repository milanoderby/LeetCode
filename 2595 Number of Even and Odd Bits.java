class Solution {
    public int[] evenOddBit(int n) {
        int[] answer = new int[2];
        String binary = new StringBuilder(Integer.toBinaryString(n)).reverse().toString();
        for (int index = 0; index < binary.length(); index++) {
            if (binary.charAt(index) == '1') {
                answer[index % 2]++;
            }
        }
        return answer;
    }
}