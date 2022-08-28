class Solution {
    public int[] minInterval(int[][] intervals, int[] queries) {
        Arrays.sort(intervals,
            Comparator.<int[]>comparingInt(intArray -> intArray[0]).thenComparingInt(
                intArray -> intArray[1]));

        int[] sortedQueries = Arrays.copyOf(queries, queries.length);
        Arrays.sort(sortedQueries);
        PriorityQueue<IntervalSizeAndEnd> minIntervalSizeHeap = new PriorityQueue<>(
            Comparator.comparingInt(IntervalSizeAndEnd::getSizeOfInterval).thenComparingInt(
                IntervalSizeAndEnd::getEndOfInterval));

        Map<Integer, Integer> queryResultMap = new HashMap<>();
        int index = 0;
        for (int query : sortedQueries) {

            while (index < intervals.length) {
                int start = intervals[index][0];
                if (start > query) {
                    break;
                }
                int end = intervals[index][1];
                int sizeOfInterval = end - start + 1;

                minIntervalSizeHeap.add(new IntervalSizeAndEnd(sizeOfInterval, end));
                index++;
            }

            while (!minIntervalSizeHeap.isEmpty()) {
                IntervalSizeAndEnd minimumInterval = minIntervalSizeHeap.peek();
                if (query <= minimumInterval.getEndOfInterval()) {
                    queryResultMap.put(query, minimumInterval.getSizeOfInterval());
                    break;
                }
                minIntervalSizeHeap.poll();
            }

            if (!queryResultMap.containsKey(query)) {
                queryResultMap.put(query, -1);
            }
        }

        int[] resultArray = Arrays.stream(queries).map(queryResultMap::get).toArray();
        return resultArray;
    }
    
    private static class IntervalSizeAndEnd {

        private int sizeOfInterval;
        private int endOfInterval;

        public IntervalSizeAndEnd(int sizeOfInterval, int endOfInterval) {
            this.sizeOfInterval = sizeOfInterval;
            this.endOfInterval = endOfInterval;
        }

        public int getSizeOfInterval() {
            return sizeOfInterval;
        }

        public int getEndOfInterval() {
            return endOfInterval;
        }
    }
}