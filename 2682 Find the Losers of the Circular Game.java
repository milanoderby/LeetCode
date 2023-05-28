class Solution {
    public int[] circularGameLosers(int n, int k) {
        boolean[] hasReceivedBall = new boolean[n];

        int receiver = 0;
        for (int index = 1; !hasReceivedBall[receiver]; index++) {
            hasReceivedBall[receiver] = true;
            receiver += index * k;
            receiver %= n;
        }

        return IntStream.range(1, n + 1)
            .filter(person -> !hasReceivedBall[person - 1])
            .toArray();
    }
}