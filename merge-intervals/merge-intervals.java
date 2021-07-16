class Solution {
    public int[][] merge(int[][] intervals) {
        Arrays.sort(intervals, new IntervalComparator());
        for (int i = 0; i < intervals.length; i++) {
            System.out.println(intervals[i][0] + " " + intervals[i][1]);
        }

        int index = 0;
        List<int[]> answer = new ArrayList<>();
        answer.add(new int[]{intervals[0][0], intervals[0][1]});
        for (int i = 1; i < intervals.length; i++) {
            if (intervals[i][0] <= intervals[i-1][1]) {
                intervals[i][1] = Math.max(intervals[i-1][1], intervals[i][1]);

                answer.get(index)[1] = intervals[i][1];
            } else {
                answer.add(new int[]{intervals[i][0], intervals[i][1]});
                index++;
            }
        }
        
        return answer.toArray(new int[answer.size()][2]);
    }
    
    private static class IntervalComparator implements Comparator<int[]> {
        @Override
        public int compare(int[] i1, int[] i2) {
            if (i1[0] == i2[0]) {
                return i1[1] - i2[1];
            }
            return i1[0] - i2[0];
        }
    }
}