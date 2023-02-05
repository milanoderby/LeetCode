class Solution {
    public long putMarbles(int[] weights, int k) {
        List<Long> boundaryValueList = new ArrayList<>();
        for (int i = 0; i < weights.length - 1; i++) {
            long boundaryValue = weights[i] + weights[i + 1];
            boundaryValueList.add(boundaryValue);
        }

        long maxScore = weights[0] + weights[weights.length - 1];
        Collections.sort(boundaryValueList, Comparator.reverseOrder());
        for (int i = 0; i < k - 1; i++) {
            maxScore += boundaryValueList.get(i);
        }

        long minScore = weights[0] + weights[weights.length - 1];
        Collections.sort(boundaryValueList);
        for (int i = 0; i < k - 1; i++) {
            minScore += boundaryValueList.get(i);
        }

        return maxScore - minScore;
    }
}