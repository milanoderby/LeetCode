class Solution {
    public int coinChange(int[] coins, int amount) {
        final int NUM_OF_MAX_COIN = 10001;
        int[] minNumberToMakeAmount = new int[amount + 1];
        for (int i = 1; i <= amount; i++) {
            minNumberToMakeAmount[i] = NUM_OF_MAX_COIN;
        }

        Arrays.sort(coins);
        for (int i = 0; i < coins.length; i++) {
            if (coins[i] > amount) {
                break;
            }
            minNumberToMakeAmount[coins[i]] = 1;
        }

        for (int money = 1; money <= amount; money++) {
            for (int i = 0; i < coins.length; i++) {
                int coin = coins[i];
                if (money - coin < 0) {
                    break;
                }
                minNumberToMakeAmount[money] = Math.min(minNumberToMakeAmount[money],
                    minNumberToMakeAmount[money - coin] + 1);
            }
        }

        return minNumberToMakeAmount[amount] == NUM_OF_MAX_COIN ? -1
            : minNumberToMakeAmount[amount];
    }
}