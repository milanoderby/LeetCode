class Solution {
    public int minIncrements(int n, int[] cost) {
        // 0 -> 1
        // 0 -> 2
        // 1 -> 3
        // 1 -> 4
        // 2 -> 5
        // 2 -> 6
        int answer = 0;
        int[] costToLeafNode = new int[cost.length];
        for (int i = n - 1; i >= 0; i--) {
            int leftNode = 2 * i + 1;
            int rightNode = 2 * i + 2;
            if (leftNode >= n) {
                costToLeafNode[i] = cost[i];
                continue;
            }

            int maxCost = Math.max(costToLeafNode[leftNode], costToLeafNode[rightNode]);
            answer += maxCost - costToLeafNode[leftNode];
            answer += maxCost - costToLeafNode[rightNode];

            costToLeafNode[i] = maxCost + cost[i];
        }
        return answer;
    }
}