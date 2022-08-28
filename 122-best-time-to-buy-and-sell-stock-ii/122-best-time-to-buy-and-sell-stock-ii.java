class Solution {
    public int maxProfit(int[] prices) {
        // 오늘의 가격이 어제 보다 높을 때, 어제 buy, 오늘 sell
        int maxProfit = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i - 1] < prices[i]) {
                maxProfit += prices[i] - prices[i - 1];
            }
        }
        return maxProfit;
    }
}