class Solution {
    public int kItemsWithMaximumSum(int numOnes, int numZeros, int numNegOnes, int k) {
        int answer = 0;
        if (numOnes >= k) {
            answer += k;
            return answer;
        }
        answer += numOnes;
        k -= numOnes;

        if (numZeros >= k) {
            return answer;
        }
        k -= numZeros;

        answer -= k;
        return answer;
    }
}